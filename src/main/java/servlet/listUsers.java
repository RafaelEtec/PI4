package servlet;

import dao.usDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listUsers")
public class listUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Usuario> users = new usDAO().listUsers();
        int total = users.size();
        String strTotal = "Total de usuários cadastrados: " + total;
        req.setAttribute("users", users);
        req.setAttribute("id", req.getSession().getAttribute("us_ID"));
        req.setAttribute("strTotal", strTotal);
        req.getRequestDispatcher("usuarios.jsp").forward(req, resp);
    }
}