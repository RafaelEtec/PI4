package dao;

import model.Usuario;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
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
            ps.setString(3, us.getCpf());
            ps.setString(4, encrypt(us.getPass()));
            ps.setString(5, us.getFuncao());
            ps.execute();

            saida = true;
            System.out.println("Sucesso no cadastro do Usuário!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro do Usuário!");
        }
        return saida;
    }

    public boolean login(String email, String pass) {
        String sql = "SELECT us_PASS FROM tb_USUARIO WHERE us_EMAIL = ? AND us_PASS = ?;";
        boolean saida = false;
        String resposta = "";
        pass = encrypt(pass);
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

    public String encrypt(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            String encoded = Base64.getEncoder().encodeToString(bytes);
            return encoded;
        } catch (Exception ex) {
            return null;
        }
    }

    public String decrypt(String str) {
        try {
            byte[] decoded = Base64.getDecoder().decode(str);
            String decodedStr = new String(decoded, StandardCharsets.UTF_8);
            return decodedStr;
        } catch (Exception ex) {
            return null;
        }
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
                if (resposta.equals("ADMIN") || resposta.equals("STOCKIST")) {
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
                String cpf = rs.getString("us_CPF");
                String pass = rs.getString("us_PASS");
                String funcao = rs.getString("us_FUNCAO");
                boolean status = rs.getBoolean("us_STATUS");

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
        String sql = "SELECT * FROM tb_USUARIO;";

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
                boolean us_STATUS = rs.getBoolean("us_STATUS");

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
                boolean us_STATUS = rs.getBoolean("us_STATUS");

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
        boolean status = false;

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
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return status;
    }

    public boolean getStatus(String email) {
        String sql = "SELECT us_STATUS FROM tb_USUARIO WHERE us_EMAIL = ?;";
        boolean status = false;

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
            con.close();
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
        boolean exists = false;

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

    public boolean checkCPF(String cpf) {
        String sql = "SELECT us_CPF FROM tb_USUARIO WHERE us_CPF = ?;";
        boolean exists = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getString("us_CPF").equals(cpf)) {
                    exists = true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return exists;
    }

    public Usuario userInfo(int id) {
        String sql = "SELECT us_ID, us_NOME, us_EMAIL, us_CPF, us_PASS, us_FUNCAO, us_STATUS FROM tb_USUARIO WHERE us_ID = ?;";
        Usuario us = new Usuario();

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int us_ID = rs.getInt("us_ID");
                String us_NOME = rs.getString("us_NOME");
                String us_EMAIL = rs.getString("us_EMAIL");
                String us_CPF = rs.getString("us_CPF");
                String us_PASS = rs.getString("us_PASS");
                String us_FUNCAO = rs.getString("us_FUNCAO");
                boolean us_STATUS = rs.getBoolean("us_STATUS");

                us_PASS = decrypt(us_PASS);

                us = new Usuario(us_ID, us_NOME, us_EMAIL, us_CPF, us_PASS, us_FUNCAO, us_STATUS);
            }
            System.out.println("Sucesso na coleta!");
            con.close();

            return us;
        } catch (Exception ex) {
            System.out.println("Erro na coleta!");
            return null;
        }
    }

    public boolean updateUser(Usuario us) {
        String sql = "UPDATE tb_USUARIO SET us_NOME = ?, us_CPF = ?, us_PASS = ?, us_FUNCAO = ? WHERE us_ID = ?;";
        boolean saida = false;
        String us_pass = encrypt(us.getPass());
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us.getNome());
            ps.setString(2, us.getCpf());
            ps.setString(3, us_pass);
            ps.setString(4, us.getFuncao());
            ps.setInt(5, us.getId());
            ps.execute();
            saida = true;
            System.out.println("Sucesso na atualização!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na atualização!");
        }
        return saida;
    }
}