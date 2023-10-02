package servlet;

import dao.prDAO;
import model.Produto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.fileupload.servlet.ServletFileUpload.isMultipartContent;

@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Map<String, String> parameters = uploadImage(req);

        String pr_nome = parameters.get("pr-nome");
        String pr_desc = parameters.get("pr-desc");
        double pr_val = Double.parseDouble(parameters.get("pr-val"));
        int pr_qnt = Integer.parseInt(parameters.get("pr-qnt"));
        double pr_ava = Double.parseDouble(parameters.get("pr-ava"));
        String pr_img = parameters.get("img");
        String pr_tag = parameters.get("pr-tag");

        Produto pr = new Produto(pr_nome, pr_desc, pr_val, pr_qnt, pr_ava, pr_img, pr_tag);
        boolean saida = new prDAO().addProduct(pr);

        if (saida) {
            resp.sendRedirect("/listProducts");
        } else {
            req.setAttribute("pr", pr);
            req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
        }
    }

    private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {
        HashMap<String, String> parameters = new HashMap<>();

        if (isMultipartContent(httpServletRequest)) {
            try {
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);
                for (FileItem item: fileItems) {
                    checkFieldType(item, parameters);
                }
            } catch (Exception ex) {
                parameters.put("img", "img/mus.jpg");
            }
        } else {
            return parameters;
        }
        return parameters;
    }

    private void checkFieldType(FileItem fileItem, Map requestParameters) throws Exception {
        if (fileItem.isFormField()) {
            requestParameters.put(fileItem.getFieldName(), fileItem.getString());
        } else {
            String fileName = processUploadedFile(fileItem);
            requestParameters.put("img", fileName);
        }
    }

    private String processUploadedFile(FileItem fileItem) throws Exception {
        Long currentTime = new Date().getTime();
        String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ",  ""));
        String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);
        fileItem.write(new File(filePath));
        return fileName;
    }
}