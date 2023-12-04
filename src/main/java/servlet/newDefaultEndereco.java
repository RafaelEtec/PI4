package servlet;

import dao.clDAO;
import model.Cliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/newDefaultEndereco")
public class newDefaultEndereco extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        int id = cliente.getId();
        int endereco = Integer.parseInt(req.getParameter("newIdEndereco"));
        int cln = Integer.parseInt(req.getParameter("newIdEnderecoCLN"));

        new clDAO().downAllDefaultEndereco(id);
        new clDAO().newDefaultEndereco(endereco);
        new clDAO().newDefaultClienteEndereco(id, cln);

        req.getRequestDispatcher("/metodosFrete").forward(req, resp);
    }
}