package servlet;

import dao.prDAO;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toUpdateProductAll")
public class toUpdateProductAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pr_id = Integer.parseInt(req.getParameter("pr_ID"));
        Produto pr = new prDAO().productInfo(pr_id);
        req.setAttribute("pr", pr);
        String gonna = "UPDATE";
        req.setAttribute("gonna", gonna);
        req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
    }
}