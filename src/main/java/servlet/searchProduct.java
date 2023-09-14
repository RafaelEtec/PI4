package servlet;

import dao.prDAO;
import model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchProduct")
public class searchProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeToSearch = req.getParameter("nomeToSearch");
        List<Produto> prs = new prDAO().listProductsByNome(nomeToSearch);
        int total = prs.size();
        String strTotal;
        if (total ==  0) {
            strTotal = "Nenhum produto encontrado";
        } else if (total > 1) {
            strTotal = total + " Produtos encontrados";
        } else {
            strTotal = total + " Produto encontrado";
        }
        req.setAttribute("prs", prs);
        req.setAttribute("id", req.getSession().getAttribute("us_ID"));
        req.setAttribute("strTotal", strTotal);
        req.getRequestDispatcher("produtos.jsp").forward(req, resp);
    }
}