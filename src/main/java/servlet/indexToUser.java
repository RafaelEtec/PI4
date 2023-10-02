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

@WebServlet("/Disciplina-Musical")
public class indexToUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> pianos = new prDAO().listCarrouselCardsByName("Piano");
        List<Produto> guitarras = new prDAO().listCarrouselCardsByName("Guitarra");
        List<Produto> flautas = new prDAO().listCarrouselCardsByName("Flauta");
        List<Produto> violoes = new prDAO().listCarrouselCardsByName("Violao");
        List<Produto> saxofones = new prDAO().listCarrouselCardsByName("Saxofone");

        req.setAttribute("pianos", pianos);
        req.setAttribute("guitarras", guitarras);
        req.setAttribute("flautas", flautas);
        req.setAttribute("violoes", violoes);
        req.setAttribute("saxofones", saxofones);

        req.getRequestDispatcher("Disciplina-Musical.jsp").forward(req, resp);
    }
}