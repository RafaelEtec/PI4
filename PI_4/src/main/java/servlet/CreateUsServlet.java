package servlet;

import dao.usDAO;
import model.Assessor;
import model.Usuario;

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

@WebServlet("/create-us")
public class CreateUsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String> parameters = uploadImage(req);

        String us_img = req.getParameter("img/defaultPFP.jpg");
        String us_nome = req.getParameter("us-nome");
        String us_email = req.getParameter("us-email");
        String us_nasc = req.getParameter("us-nasc");
        String us_pass = "";

        Usuario us = new Usuario(us_img, us_nome, us_email, us_nasc, us_pass);
        req.getSession().setAttribute("usC", us);
        req.getRequestDispatcher("senhaUS.html").forward(req, resp);
    }

    private Map<String, String> uploadImage(HttpServletRequest httpServletRequest) {
        Map<String, String> requestParameters = new HashMap<>();
        if (isMultipartContent(httpServletRequest)) {
            try {
                DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
                List<FileItem> fileItems = new ServletFileUpload(diskFileItemFactory).parseRequest(httpServletRequest);
                for (FileItem fileItem : fileItems) {
                    checkFieldType(fileItem, requestParameters);
                }
            } catch (Exception ex) {
                requestParameters.put("image", "img/defaultPFP.jpg");
            }
        }
        return requestParameters;
    }

    private void checkFieldType(FileItem item, Map requestParameters) throws Exception {
        if (item.isFormField()) {
            requestParameters.put(item.getFieldName(), item.getString());
        } else {
            String fileName = processUploadedFile(item);
            requestParameters.put("image", "img/".concat(fileName));
        }
    }

    private String processUploadedFile(FileItem fileItem) throws Exception {
        Long currentTime = new Date().getTime();
        String fileName = currentTime.toString().concat("-").concat(fileItem.getName().replace(" ", ""));
        String filePath = this.getServletContext().getRealPath("img").concat(File.separator).concat(fileName);
        fileItem.write(new File(filePath));
        return fileName;
    }
}