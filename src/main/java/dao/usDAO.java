package dao;

import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class usDAO {
    public boolean addUser(Usuario us) {
        String sql = "INSERT INTO tb_USUARIO (us_NOME, us_EMAIL, us_CPF, us_PASS, us_FUNCAO) VALUES (?, ?, ?, ?, ?);";
        boolean saida = false;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us.getNome());
            ps.setString(2, us.getEmail());
            ps.setInt(3, us.getCpf());
            ps.setString(4, us.getPass());
            ps.setString(5, us.getFuncao());
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
        String sql = "SELECT us_PASS FROM tb_USUARIO WHERE us_EMAIL = ? AND us_PASS = ?;";
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
        String sql = "SELECT us_FUNCAO FROM tb_USUARIO WHERE us_EMAIL = ?;";
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
        String sql = "SELECT us_ID, us_NOME, us_EMAIL, us_CPF, us_PASS, us_FUNCAO, us_STATUS FROM tb_USUARIO WHERE us_EMAIL = ?;";
        Usuario us = new Usuario();
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sessionEmail);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("us_ID");
                String nome = rs.getString("us_NOME");
                String email = rs.getString("us_EMAIL");
                int cpf = rs.getInt("us_CPF");
                String pass = rs.getString("us_PASS");
                String funcao = rs.getString("us_FUNCAO");
                Boolean status = rs.getBoolean("us_STATUS");

                us = new Usuario(id, nome, email, cpf, pass, funcao, status);
            }
            System.out.println("Sucesso na pesquisa!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return us;
    }

    public List<Usuario> listUsers() {
        String sql = "SELECT us_ID, us_NOME, us_EMAIL, us_FUNCAO, us_STATUS FROM tb_USUARIO;";

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
        String sql = "SELECT us_ID, us_NOME, us_EMAIL, us_FUNCAO, us_STATUS FROM tb_USUARIO WHERE us_NOME LIKE ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nomeToSearch + "%");
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

    public boolean getStatus(int id) {
        String sql = "SELECT us_STATUS FROM tb_USUARIO WHERE us_ID = ?;";
        Boolean status = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getBoolean("us_STATUS")) {
                    status = true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return status;
    }

    public boolean getStatus(String email) {
        String sql = "SELECT us_STATUS FROM tb_USUARIO WHERE us_EMAIL = ?;";
        Boolean status = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getBoolean("us_STATUS")) {
                    status = true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return status;
    }

    public void updateStatus(int id) {
        String sql = getStatus(id) ?
                  "UPDATE tb_USUARIO SET us_STATUS = false WHERE us_ID = ?;"
                : "UPDATE tb_USUARIO SET us_STATUS = true WHERE us_ID = ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Status alterado!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no update!");
        }
    }

    public boolean checkEmail(String email) {
        String sql = "SELECT us_EMAIL FROM tb_USUARIO WHERE us_EMAIL = ?;";
        Boolean exists = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("us_EMAIL").equals(email)) {
                    exists = true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return exists;
    }

    public boolean checkCPF(int cpf) {
        String sql = "SELECT us_CPF FROM tb_USUARIO WHERE us_CPF = ?;";
        //SELECT RIGHT('000000000' + CONVERT(VARCHAR(8),Num), 8) FROM #Numbers
        Boolean exists = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getInt("us_CPF") == cpf) {
                    exists = true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return exists;
    }
}