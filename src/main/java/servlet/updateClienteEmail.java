package servlet;

import dao.clDAO;
import model.Cliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEmail")
public class updateClienteEmail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getParameter("emailInput"), erro = "", msg = "";

        int id = Integer.parseInt(req.getParameter("cl_ID"));

        if (!new clDAO().checkExistance(info)) {
            if (new clDAO().updateCliente(info, "email", id)) {
                Cliente cliente = new clDAO().sessionPorId(id);
                req.getSession().setAttribute("cliente", cliente);

                msg = "altDone";
                req.setAttribute("msg", msg);
                req.getRequestDispatcher("/myInfo").forward(req, resp);
            } else {
                erro = "altError";
                req.setAttribute("error", erro);
                req.getRequestDispatcher("/myInfo").forward(req, resp);
            }
        } else {
            erro = "emailExists";
            req.setAttribute("error", erro);
            req.getRequestDispatcher("/myInfo").forward(req, resp);
        }
    }
}