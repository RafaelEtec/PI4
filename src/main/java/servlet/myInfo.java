package servlet;

import dao.clDAO;
import dao.peDAO;
import model.Cliente;
import model.Endereco;
import model.Pedido;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/myInfo")
public class myInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String total = "", qnt = "";
        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        int id = cliente.getId();
        double precoTotal = 0;
        List<Produto> carrinho = (List<Produto>) req.getSession().getAttribute("carrinho");
        List<Endereco> enderecos = new clDAO().pegaEnderecosCliente(id);
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

        List<Pedido> pes = new peDAO().meusPedidos(id);
        int totalPe = pes.size();
        String strTotal = "Total de Pedidos: " + totalPe;
        req.setAttribute("pes", pes);

        req.setAttribute("strTotal", strTotal);

        req.setAttribute("enderecos", enderecos);
        req.setAttribute("qnt", qnt);
        req.setAttribute("total", total);
        req.getRequestDispatcher("myInfo.jsp").forward(req, resp);
    }
}