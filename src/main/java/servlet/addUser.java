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
        int us_cpf = Integer.parseInt(req.getParameter("us-cpf"));
        String us_pass = req.getParameter("us-pass");
        String us_funcao = req.getParameter("us-funcao");

        Usuario us = new Usuario(us_nome, us_email, us_cpf, us_pass, us_funcao);
        boolean saida = new usDAO().addUser(us);

        if (saida) {
            resp.sendRedirect("/listUsers");
        } else {
            boolean checkEmail = new usDAO().checkEmail(us_email);
            boolean checkCPF = new usDAO().checkCPF(us_cpf);
            String error = "";

            if (checkEmail) {
                error = "emailDupe";
            } else if (checkCPF) {
                error = "cpfDupe";
            } else {
                error = "Erro não identificado";
            }

            req.setAttribute("error", error);
            req.setAttribute("us", us);
            req.getRequestDispatcher("addUser.jsp").forward(req, resp);
        }
    }
}