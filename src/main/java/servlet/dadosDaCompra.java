package servlet;

import dao.clDAO;
import model.Cliente;
import model.Endereco;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dadosDaCompra")
public class dadosDaCompra extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String total = "", qnt = "", frete = req.getParameter("metodoFrete"), pag = req.getParameter("metodoPagamento");
        double precoTotal = 0;
        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        int id = cliente.getId();
        List<Endereco> enderecos = new clDAO().pegaEnderecosCliente(id);
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

        if (pag.equals("pix")) {
            req.setAttribute("pixNome", req.getParameter("pixNome"));
            req.setAttribute("pixEmail", req.getParameter("pixEmail"));
            req.setAttribute("pixCpf", req.getParameter("pixCpf"));
        } else if (pag.equals("credito")) {
            req.setAttribute("creditoNome", req.getParameter("creditoNome"));
            req.setAttribute("creditoNum", req.getParameter("creditoNum"));
            req.setAttribute("creditoCvv", req.getParameter("creditoCvv"));
            req.setAttribute("creditoData", req.getParameter("creditoData"));
        } else if (pag.equals("debito")) {
            req.setAttribute("debitoNome", req.getParameter("debitoNome"));
            req.setAttribute("debitoNum", req.getParameter("debitoNum"));
            req.setAttribute("debitoCvv", req.getParameter("debitoCvv"));
            req.setAttribute("debitoData", req.getParameter("debitoData"));
        }

        req.setAttribute("enderecos", enderecos);
        req.setAttribute("qnt", qnt);
        req.setAttribute("total", total);
        req.setAttribute("metodoFrete", frete);
        req.setAttribute("metodoPagamento", pag);
        req.getRequestDispatcher("dadosDaCompra.jsp").forward(req, resp);
    }
}