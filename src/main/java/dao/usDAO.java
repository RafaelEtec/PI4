package dao;

import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class usDAO {
    public boolean addUser(Usuario us) {
        String sql = "INSERT INTO tb_USUARIO(us_IMG, us_NOME, us_EMAIL, us_CPF, us_NUM, us_NASC, us_PASS, us_FUNCAO, us_STATUS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
        boolean saida = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us.getImg());
            ps.setString(2, us.getNome());
            ps.setString(3, us.getEmail());
            ps.setString(4, us.getCpf());
            ps.setString(5, us.getNum());
            ps.setString(6, us.getNasc());
            ps.setString(7, us.getPass());
            ps.setString(8, us.getFuncao());
            ps.setBoolean(9, us.getStatus());
            ps.execute();
            saida = true;
            System.out.println("Sucesso no cadastro!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro!");
        }
        return saida;
    }

    public boolean login(String email, String pass) {
        String sql = "SELECT us_PASS FROM tb_USUARIO WHERE us_EMAIL = ? AND us_PASS = ?";
        boolean saida = false;
        String resposta = "";
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            if (!email.trim().equals("") && !pass.trim().equals("")) {
                while (rs.next()) {
                    resposta = rs.getString("us_PASS");
                }
                if (resposta.equals(pass)) {
                    saida = true;
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return saida;
    }

    public boolean isADM(String email) {
        String sql = "SELECT us_FUNCAO FROM tb_USUARIO WHERE us_EMAIL = ?";
        boolean saida = false;
        String resposta = "";
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (!email.trim().equals("")) {
                while (rs.next()) {
                    resposta = rs.getString("us_FUNCAO");
                }
                if (resposta.equals("ADMIN")) {
                    saida = true;
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return saida;
    }

    public Usuario sessionPorEmail(String sessionEmail) {
        String sql = "SELECT us_ID, us_IMG, us_NOME, us_EMAIL, us_CPF, us_NUM, us_NASC, us_PASS, us_FUNCAO, us_STATUS FROM tb_USUARIO WHERE us_EMAIL = ?";
        Usuario us = new Usuario();
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sessionEmail);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("us_ID");
                String img = rs.getString("us_IMG");
                String nome = rs.getString("us_NOME");
                String email = rs.getString("us_EMAIL");
                String cpf = rs.getString("us_CPF");
                String num = rs.getString("us_NUM");
                String nasc = rs.getString("us_NASC");
                String pass = rs.getString("us_PASS");
                String funcao = rs.getString("us_FUNCAO");
                Boolean status = rs.getBoolean("us_STATUS");

                us = new Usuario(id, img, nome, email, cpf, num, nasc, pass, funcao, status);
            }
            System.out.println("Sucesso na pesquisa!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return us;
    }

    public List<Usuario> listUsers() {
        String sql = "SELECT us_ID, us_NOME, us_EMAIL, us_FUNCAO, us_STATUS FROM tb_USUARIO";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Usuario> users = new ArrayList<>();

            while (rs.next()) {
                int us_ID = rs.getInt("us_ID");
                String us_NOME = rs.getString("us_NOME");
                String us_EMAIL = rs.getString("us_EMAIL");
                String us_FUNCAO = rs.getString("us_FUNCAO");
                Boolean us_STATUS = rs.getBoolean("us_STATUS");

                Usuario user = new Usuario(us_ID, us_NOME, us_EMAIL, us_FUNCAO, us_STATUS);
                users.add(user);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return users;
        } catch (Exception ex) {
            System.out.println("Erro na listagem!");
            return Collections.emptyList();
        }
    }

    public List<Usuario> listUsersByNome(String nomeToSearch) {
        String sql = "SELECT us_ID, us_NOME, us_EMAIL, us_FUNCAO, us_STATUS FROM tb_USUARIO WHERE us_NOME = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nomeToSearch);
            ResultSet rs = ps.executeQuery();
            List<Usuario> users = new ArrayList<>();

            while (rs.next()) {
                int us_ID = rs.getInt("us_ID");
                String us_NOME = rs.getString("us_NOME");
                String us_EMAIL = rs.getString("us_EMAIL");
                String us_FUNCAO = rs.getString("us_FUNCAO");
                Boolean us_STATUS = rs.getBoolean("us_STATUS");

                Usuario user = new Usuario(us_ID, us_NOME, us_EMAIL, us_FUNCAO, us_STATUS);
                users.add(user);
            }

            System.out.println("Sucesso na listagem!");
            con.close();

            return users;
        } catch (Exception ex) {
            System.out.println("Erro na listagem!");
            return Collections.emptyList();
        }
    }
}