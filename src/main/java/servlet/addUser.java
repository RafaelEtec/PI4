package servlet;

import dao.usDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addUser")
public class addUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String us_nome = req.getParameter("us-nome");
        String us_email = req.getParameter("us-email");
        String us_cpf = req.getParameter("us-cpf");
        String us_funcao = req.getParameter("us-funcao");
        String us_pass = req.getParameter("us-pass");

        Usuario us = new Usuario(us_nome, us_email, us_cpf, us_pass, us_funcao);
        boolean saida = new usDAO().addUser(us);

        if (saida) {
            req.getRequestDispatcher("/listUsers").forward(req, resp);
        } else {
            resp.sendRedirect("addUser.jsp");
        }
    }
}