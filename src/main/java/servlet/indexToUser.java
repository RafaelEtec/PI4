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

@WebServlet("/Disciplina-Musical")
public class indexToUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> pianos = new prDAO().listCarrouselCardsByTag("PIANO");
        List<Produto> guitarras = new prDAO().listCarrouselCardsByTag("GUITARRA");
        List<Produto> flautas = new prDAO().listCarrouselCardsByTag("FLAUTA");
        List<Produto> violoes = new prDAO().listCarrouselCardsByTag("VIOLAO");
        List<Produto> saxofones = new prDAO().listCarrouselCardsByTag("SAXOFONE");

        req.setAttribute("pianos", pianos);
        req.setAttribute("guitarras", guitarras);
        req.setAttribute("flautas", flautas);
        req.setAttribute("violoes", violoes);
        req.setAttribute("saxofones", saxofones);
        String status = "";

        Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
        if (cliente == null) {
            status = "naologado";
        } else {
            status = "logado";
        }

        req.setAttribute("sessionStatus", status);
        req.getRequestDispatcher("Disciplina-Musical.jsp").forward(req, resp);
    }
}