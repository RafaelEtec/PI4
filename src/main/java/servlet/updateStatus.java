package servlet;

import dao.usDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateStatus")
public class updateStatus extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int us_id = Integer.parseInt(req.getParameter("us_ID"));
        Usuario us = (Usuario) req.getSession().getAttribute("us");
        if (us.getFuncao().equals("ADMIN") && (us_id != us.getId())) {
            new usDAO().updateStatus(us_id);
            resp.sendRedirect("/listUsers");
        } else {
            resp.sendRedirect("/listUsers");
        }
    }
}