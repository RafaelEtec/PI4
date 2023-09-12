package servlet;

import dao.usDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/toUpdate")
public class toUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int us_id = Integer.parseInt(req.getParameter("us_ID"));
        Usuario us = new usDAO().userInfo(us_id);
        req.setAttribute("usC", us);
        req.setAttribute("gonna", "UPDATE");
        req.getRequestDispatcher("addUser.jsp").forward(req, resp);
    }
}