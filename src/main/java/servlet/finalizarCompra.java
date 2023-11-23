package servlet;

import dao.clDAO;
import dao.peDAO;
import dao.prDAO;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/finalizarCompra")
public class finalizarCompra extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String metodoFrete = req.getParameter("metodoFrete"), metodoPagamento = req.getParameter("metodoPagamento"), total = "", qnt = "";
        double precoTotal = 0;
        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        List<Produto> carrinho = (List<Produto>) req.getSession().getAttribute("carrinho");
        for (int i = 0; i < carrinho.size(); i++) {
            Produto prAtual = carrinho.get(i);
            double precoAtual = prAtual.getVal();
            precoTotal = precoTotal + precoAtual;
        }
        List<Endereco> enderecos = new clDAO().pegaEnderecosCliente(cliente.getId());
        Endereco en = enderecos.get(1);

        total = "" + precoTotal;
        if (carrinho.size() == 1) { qnt = "Há " + carrinho.size() + " item no carrinho";
        } else { qnt = "Há " + carrinho.size() + " itens no carrinho"; }

        Pedido pe = new Pedido(cliente.getId(), precoTotal, carrinho.size(), en.getId(), metodoFrete, metodoPagamento, "Verificando pagamento");
        new peDAO().addPedido(pe);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int idpeAtual = new peDAO().idPedido();

        for (int i = 0; i < carrinho.size(); i++) {
            Produto prAtual = carrinho.get(i);
            double precoAtual = prAtual.getVal();
            precoTotal = precoTotal + precoAtual;
            PedidoProduto peprAtual = new PedidoProduto(idpeAtual, prAtual.getId(), prAtual.getNome(), 1, prAtual.getVal());
            new peDAO().addPedidoProduto(peprAtual);
        }

        String gonna = req.getParameter("gonna"), status;
        for (int i = 0; i < carrinho.size(); i++) {
            Produto prRemover = carrinho.get(i);
            new prDAO().addOne(prRemover.getId());
        }
        carrinho = new ArrayList<>();
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