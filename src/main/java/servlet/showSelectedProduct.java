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
        String total = "", qnt = "";
        double precoTotal = 0;
        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        if (cliente == null) {
            status = "naologado";
        } else {
            status = "logado";
        }

        if (req.getSession().getAttribute("carrinho") == null) {
            List<Produto> carrinho = new ArrayList<>();
            req.getSession().setAttribute("carrinho", carrinho);
            req.getSession().setAttribute("txtCar", "Carrinho vazio");
        } else {
            List<Produto> carrinho = (List<Produto>) req.getSession().getAttribute("carrinho");
            for (int i = 0; i < carrinho.size(); i++) {
                Produto prAtual = carrinho.get(i);
                double precoAtual = prAtual.getVal();
                precoTotal = precoTotal + precoAtual;
            }
            total = "" + precoTotal;
            if (carrinho.size() == 1) {
                qnt = "Há " + carrinho.size() + " item no carrinho";
            } else {
                qnt = "Há " + carrinho.size() + " itens no carrinho";
            }
        }
        req.setAttribute("qnt", qnt);
        req.setAttribute("total", total);

        req.setAttribute("sessionStatus", status);
        req.getRequestDispatcher("product-info.jsp").forward(req, resp);
    }
}