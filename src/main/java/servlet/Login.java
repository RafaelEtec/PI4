package servlet;

import dao.usDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String us_email = req.getParameter("us-email");
        String us_pass = req.getParameter("us-pass");
        System.out.println(us_email + " - " + us_pass);
        String error = "";
        if (!us_email.isEmpty() || !us_pass.isEmpty()) {
            boolean resposta = new usDAO().login(us_email, us_pass);
            boolean admin = new usDAO().isADM(us_email);
            boolean status = new usDAO().getStatus(us_email);
            if (resposta) {
                if (status) {
                    if (admin) {
                        Usuario us = new usDAO().sessionPorEmail(us_email);
                        req.getSession().setAttribute("us", us);
                        resp.sendRedirect("principal.jsp");
                    } else {
                        error = "notAnAdmin";
                        req.setAttribute("error", error);
                        req.getRequestDispatcher("index.jsp").forward(req, resp);
                    }
                } else {
                    error = "notUp";
                    req.setAttribute("error", error);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } else {
                error = "notFound";
                req.setAttribute("error", error);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            error = "missingSpaces";
            req.setAttribute("error", error);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}