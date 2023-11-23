package servlet;

import dao.peDAO;
import model.Pedido;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listPedidos")
public class listPedidos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pedido> pes = new peDAO().listaPedidos();
        int total = pes.size();
        String strTotal = "Total de Pedidos: " + total;
        req.setAttribute("pes", pes);
        Usuario us = (Usuario) req.getSession().getAttribute("us");
        req.setAttribute("funcao", us.getFuncao());
        req.setAttribute("strTotal", strTotal);
        req.getRequestDispatcher("pedidos.jsp").forward(req, resp);
    }
}