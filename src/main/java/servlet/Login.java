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
        if (!us_email.isEmpty() && !us_pass.isEmpty()) {
            boolean resposta = new usDAO().login(us_email, us_pass);
            if (resposta) {
                Usuario us = new usDAO().sessionPorEmail(us_email);
                req.getSession().setAttribute("us", us);
                resp.sendRedirect("index.html");
            }
        }
    }
}