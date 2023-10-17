package servlet;

import dao.clDAO;
import model.Cliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginCli")
public class LoginCli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cl_email = req.getParameter("cl-email");
        String cl_pass = req.getParameter("cl-pass");
        String error = "";
        if (!cl_email.isEmpty() || !cl_pass.isEmpty()) {
            boolean resposta = new clDAO().login(cl_email, cl_pass);
            if (resposta) {
                Cliente cliente = new clDAO().sessionPorEmail(cl_email);
                req.getSession().setAttribute("cliente", cliente);
                resp.sendRedirect("/Disciplina-Musical");
            } else {
                error = "notFound";
                req.setAttribute("error", error);
                req.getRequestDispatcher("/Disciplina-Musical").forward(req, resp);
            }
        } else {
            error = "missingInfo";
            req.setAttribute("error", error);
            req.getRequestDispatcher("/Disciplina-Musical").forward(req, resp);
        }
    }
}