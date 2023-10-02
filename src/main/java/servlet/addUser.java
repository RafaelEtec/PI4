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
        if (req.getParameter("gonna").equals("UPDATE")) {
            int us_id = Integer.parseInt(req.getParameter("id"));
            String us_nome = req.getParameter("us-nome");
            String us_email = req.getParameter("email");
            String us_cpf = req.getParameter("us-cpf");
            String cpf = req.getParameter("cpf");
            String us_pass = req.getParameter("us-pass");
            String us_funcao = req.getParameter("us-funcao");
            Usuario us = new Usuario(us_id, us_nome, us_email, us_cpf, us_pass, us_funcao);
            boolean saida = new usDAO().updateUser(us);

            if (saida) {
                resp.sendRedirect("/listUsers");
            } else {
                boolean checkCPF = new usDAO().checkCPF(us_cpf);
                String error = "";

                if (!us_cpf.equals(cpf)) {
                    if (checkCPF) {
                        error = "cpfDupe";
                    } else {
                        error = "Erro não identificado";
                    }
                }

                req.setAttribute("error", error);
                req.setAttribute("gonna", "UPDATE");
                req.setAttribute("usC", us);
                req.getRequestDispatcher("addUser.jsp").forward(req, resp);
            }
        } else {
            String us_nome = req.getParameter("us-nome");
            String us_email = req.getParameter("us-email");
            String us_cpf = req.getParameter("us-cpf");
            String us_pass = req.getParameter("us-pass");
            String us_funcao = req.getParameter("us-funcao");

            Usuario us = new Usuario(us_nome, us_email, us_cpf, us_pass, us_funcao);
            boolean saida = false;
            Usuario check = (Usuario) req.getSession().getAttribute("us");
            String cPass = new usDAO().decrypt(check.getPass());
            if (cPass.equals(us_pass)) {
                if (new usDAO().addUser(us)) {
                    saida = true;
                }
            }
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
                } else if (!cPass.equals(us_pass)) {
                    error = "wrongPass";
                } else {
                    error = "Erro não identificado";
                }

                req.setAttribute("error", error);
                req.setAttribute("usC", us);
                req.getRequestDispatcher("addUser.jsp").forward(req, resp);
            }
        }
    }
}