package servlet;

import dao.peDAO;
import dao.prDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toUpdatePedidoStatus")
public class toUpdatePedidoStatus extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pe_id = Integer.parseInt(req.getParameter("pe_new_ID"));
        String pe_status = req.getParameter("pe-stt");
        new peDAO().altStatusPedido(pe_id, pe_status);
        req.getRequestDispatcher("/listPedidos").forward(req, resp);
    }
}