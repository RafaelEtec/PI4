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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/limparCarrinhoIndex")
public class limparCarrinhoIndex extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gonna = req.getParameter("gonna"), status;
        List<Produto> carrinho = new ArrayList<>();

        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        if (cliente == null) {
            status = "naologado";
        } else {
            status = "logado";
        }

        req.getSession().setAttribute("carrinho", carrinho);
        req.setAttribute("gonna", gonna);
        req.setAttribute("sessionStatus", status);
        req.getRequestDispatcher("/Disciplina-Musical").forward(req, resp);
    }
}