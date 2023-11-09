package servlet;

import dao.clDAO;
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

@WebServlet("/loginCli")
public class LoginCli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cl_email = req.getParameter("cl-email");
        String cl_pass = req.getParameter("cl-pass");
        String error = "";
        String total = "", qnt = "";
        double precoTotal = 0;
        if (!cl_email.isEmpty() || !cl_pass.isEmpty()) {
            boolean resposta = new clDAO().login(cl_email, cl_pass);
            if (resposta) {
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
                Cliente cliente = new clDAO().sessionPorEmail(cl_email);
                req.getSession().setAttribute("cliente", cliente);
                String msg = "login";
                req.setAttribute("error", msg);
                req.getRequestDispatcher("/Disciplina-Musical").forward(req, resp);
            } else {
                error = "notFound";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/Disciplina-Musical").forward(req, resp);
            }
        } else {
            error = "missingInfo";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/Disciplina-Musical").forward(req, resp);
        }
    }
}