package servlet;

import dao.prDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateProductStatus")
public class updateProductStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pr_id = Integer.parseInt(req.getParameter("pr_ID"));
        Usuario us = (Usuario) req.getSession().getAttribute("us");
        if (us.getFuncao().equals("ADMIN") || us.getFuncao().equals("STOKIST")) {
            new prDAO().updateStatus(pr_id);
            req.getRequestDispatcher("/listProducts").forward(req, resp);
        } else {
            resp.sendRedirect("/listProducts");
        }
    }
}