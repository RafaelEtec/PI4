package servlet;

import dao.prDAO;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("gonna").equals("UPDATE")) {

        } else {
            String pr_nome = req.getParameter("pr-nome");
            String pr_desc = req.getParameter("pr-desc");
            double pr_val = Double.parseDouble(req.getParameter("pr-val"));
            int pr_qnt = Integer.parseInt(req.getParameter("pr-qnt"));
            double pr_ava = Double.parseDouble(req.getParameter("pr-ava"));

            Produto pr = new Produto(pr_nome, pr_desc, pr_val, pr_qnt, pr_ava);
            boolean saida = new prDAO().addProduct(pr);

            if (saida) {
                resp.sendRedirect("/listProducts");
            } else {

            }
        }
    }
}