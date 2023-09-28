package servlet;

import dao.prDAO;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toUpdateProductQnt")
public class toUpdateProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pr_id = Integer.parseInt(req.getParameter("pr_ID"));
        int pr_qnt = Integer.parseInt(req.getParameter("pr_new_QNT"));
        new prDAO().updateProductQnt(pr_id, pr_qnt);
        req.getRequestDispatcher("/listProducts").forward(req, resp);
    }
}