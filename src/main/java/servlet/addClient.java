package servlet;

import dao.clDAO;
import model.Cliente;
import model.Endereco;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addClient")
public class addClient extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String erro = "";
        String cl_nome = req.getParameter("cl-nome"), cl_email = req.getParameter("cl-emailC"), cl_cpf = req.getParameter("cl-cpf"), cl_nasc = req.getParameter("cl-nasc"), cl_genero = req.getParameter("cl-genero");
        if (cl_genero.equals("HOMEM")) {
            cl_genero = "M";
        } else {
            cl_genero = "F";
        }
        String cl_pass = req.getParameter("cl-passC"), f_cep = req.getParameter("f-cep"), f_log = req.getParameter("f-log"), f_num = req.getParameter("f-num"), f_com = req.getParameter("f-com"), f_cid = req.getParameter("f-cid"), f_est = req.getParameter("f-est");
        String e_cep = req.getParameter("e-cep"), e_log = req.getParameter("e-log"), e_num = req.getParameter("e-num"), e_com = req.getParameter("e-com"), e_cid = req.getParameter("e-cid"), e_est = req.getParameter("e-est");
        Cliente cliente = new Cliente(cl_nome, cl_email, cl_cpf, cl_nasc, cl_genero, cl_pass);

        boolean cl_bol = new clDAO().addClient(cliente);
        int id_cli = new clDAO().pegaIdPorEmail(cl_email);

        Endereco end_f = new Endereco(id_cli, 1, "FATURAMENTO", f_cep, f_log, f_num, f_com, f_cid, f_est, false);
        Endereco end_e = new Endereco(id_cli, 2, "ENTREGA", e_cep, e_log, e_num, e_com, e_cid, e_est, true);

        boolean f_bol = new clDAO().addEndereco(end_f);
        boolean e_bol = new clDAO().addEndereco(end_e);

        resp.sendRedirect("/Disciplina-Musical");
    }
}