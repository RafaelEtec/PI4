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
import java.util.List;

@WebServlet("/addToCarrinho")
public class addToCarrinho extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("pr-id"));
        String gonna = req.getParameter("gonna"), status;
        Produto pr = new prDAO().productInfo(id);
        List<Produto> carrinho = (List<Produto>) req.getSession().getAttribute("carrinho");

        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        if (cliente == null) { status = "naologado";
        } else {               status = "logado";}

        carrinho.add(pr);
        new prDAO().removeOne(id);

        req.getSession().setAttribute("carrinho", carrinho);
        req.setAttribute("pr-id", id);
        req.setAttribute("gonna", gonna);
        req.setAttribute("sessionStatus", status);
        req.getRequestDispatcher("/showProduct").forward(req, resp);
    }
}