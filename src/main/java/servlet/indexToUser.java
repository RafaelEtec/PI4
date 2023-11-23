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

@WebServlet("/Disciplina-Musical")
public class indexToUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> pianos = new prDAO().listCarrouselCardsByTag("PIANO");
        List<Produto> guitarras = new prDAO().listCarrouselCardsByTag("GUITARRA");
        List<Produto> flautas = new prDAO().listCarrouselCardsByTag("FLAUTA");
        List<Produto> violoes = new prDAO().listCarrouselCardsByTag("VIOLAO");
        List<Produto> saxofones = new prDAO().listCarrouselCardsByTag("SAXOFONE");
        List<Produto> randomPrs = new prDAO().listRandomProducts();
        String total = "", qnt = "";
        double precoTotal = 0;
        req.setAttribute("pianos", pianos);
        req.setAttribute("guitarras", guitarras);
        req.setAttribute("flautas", flautas);
        req.setAttribute("violoes", violoes);
        req.setAttribute("saxofones", saxofones);
        req.setAttribute("prsShow", randomPrs);
        String status = "";

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
        req.getRequestDispatcher("Disciplina-Musical.jsp").forward(req, resp);
    }
}