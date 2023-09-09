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

@WebServlet("/searchUser")
public class searchUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomeToSearch = req.getParameter("nomeToSearch");
        List<Usuario> users = new usDAO().listUsersByNome(nomeToSearch);
        int total = users.size();
        String strTotal;
        if (total == 0) {
            strTotal = "Nenhum usuário encontrado";
        } else if (total > 1) {
            strTotal = total + " Usuários encontrados";
        } else {
            strTotal = total + " Usuário encontrado";
        }
        req.setAttribute("users", users);
        req.setAttribute("id", req.getSession().getAttribute("us_ID"));
        req.setAttribute("strTotal", strTotal);
        req.getRequestDispatcher("usuarios.jsp").forward(req, resp);
    }
}