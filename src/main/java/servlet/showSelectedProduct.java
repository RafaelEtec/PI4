package servlet;

import dao.prDAO;
import model.Cliente;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showProduct")
public class showSelectedProduct extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("pr-id"));
        String gonna = req.getParameter("gonna");
        Produto pr = new prDAO().productInfo(id);
        req.setAttribute("pr", pr);
        req.setAttribute("gonna", gonna);
        String status;
        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        if (cliente == null) {
            status = "naologado";
        } else {
            status = "logado";
        }
        req.setAttribute("sessionStatus", status);
        req.getRequestDispatcher("product-info.jsp").forward(req, resp);
    }
}