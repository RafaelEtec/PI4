package servlet;

import dao.clDAO;
import dao.prDAO;
import model.Cliente;
import model.Endereco;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/removeDoCarrinhoFinal")
public class removeDoCarrinhoFinal extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gonna = req.getParameter("gonna");
        int id_remove = Integer.parseInt(req.getParameter("id-remove"));
        req.setAttribute("gonna", gonna);
        String status;
        String total = "", qnt = "";
        double precoTotal = 0;
        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        int id = cliente.getId();
        List<Endereco> enderecos = new clDAO().pegaEnderecosCliente(id);
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

            Produto prRemover = carrinho.get(id_remove);
            carrinho.remove(id_remove);
            new prDAO().addOne(prRemover.getId());

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
        req.setAttribute("enderecos", enderecos);
        req.setAttribute("qnt", qnt);
        req.setAttribute("total", total);
        req.setAttribute("sessionStatus", status);
        req.getRequestDispatcher("metodosItens.jsp").forward(req, resp);
    }
}