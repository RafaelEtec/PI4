package servlet;

import dao.clDAO;
import model.Cliente;
import model.Endereco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addEndereco")
public class addEndereco extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String e_cep = req.getParameter("new-e-cep"), e_log = req.getParameter("new-e-log"), e_num = req.getParameter("new-e-num"), e_com = req.getParameter("new-e-com"), e_cid = req.getParameter("new-e-cid"), e_est = req.getParameter("new-e-est");
        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        int idNovoEnd = new clDAO().pegaMaxCLN(cliente.getId()) + 1;

        Endereco novoEndereco = new Endereco(cliente.getId(), idNovoEnd, "ENTREGA", e_cep, e_log, e_num, e_com, e_cid, e_est, false);
        new clDAO().addEndereco(novoEndereco);

        req.getRequestDispatcher("/metodosFrete").forward(req, resp);
    }
}