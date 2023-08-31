package servlet;

import model.Assessor;
import model.Evento;
import dao.evDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search-ev-as")
public class ListEventByAss extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txt = req.getParameter("ev_p");
        Assessor as = (Assessor) req.getSession().getAttribute("ass");
        List<Evento> ev = new evDAO().searchByAss(txt, as.getId());
        int total = ev.size();
        req.setAttribute("ev", ev);
        req.setAttribute("total", total);
        req.getRequestDispatcher("infoAS.jsp").forward(req,resp);
    }
}