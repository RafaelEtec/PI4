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

@WebServlet("/meusPedidos")
public class meusPedidos extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Pedido> pes = new peDAO().listaPedidos();
        int total = pes.size();
        String strTotal = "Total de Pedidos: " + total;
        req.setAttribute("pes", pes);

        req.setAttribute("strTotal", strTotal);
        req.getRequestDispatcher("meusPedidos.jsp").forward(req, resp);
    }
}