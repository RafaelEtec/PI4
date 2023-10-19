package servlet;

import dao.prDAO;
import model.Produto;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listProducts")
public class listProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> prs = new prDAO().listProducts();
        int total = prs.size();
        String strTotal = "Total de produtos cadastrados: " + total;
        req.setAttribute("prs", prs);
        Usuario us = (Usuario) req.getSession().getAttribute("us");
        req.setAttribute("funcao", us.getFuncao());
        req.setAttribute("strTotal", strTotal);
        req.getRequestDispatcher("produtos.jsp").forward(req, resp);
    }
}