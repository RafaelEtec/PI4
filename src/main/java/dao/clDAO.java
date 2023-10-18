package dao;

import model.Cliente;
import model.Usuario;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;

public class clDAO {

    public boolean addClient(Cliente cl) {
        String sql = "";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);


            saida = true;
            System.out.println("Sucesso no cadastro do Cliente!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro do Cliente!");
        }
        return saida;
    }
    public boolean login(String email, String pass) {
        String sql = "SELECT cl_PASS FROM tb_CLIENTE WHERE cl_EMAIL = ? AND cl_PASS = ?;";
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
                    resposta = rs.getString("cl_PASS");
                }
                if (resposta.equals(pass)) {
                    saida = true;
                    System.out.println("Encontrado");
                }
            }
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa!");
        }
        return saida;
    }

    public Cliente sessionPorEmail(String sessionEmail) {
        String sql = "";
        Cliente cl = new Cliente();

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sessionEmail);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("cl_ID");
                String nome = rs.getString("cl_NOME");
                String email = rs.getString("cl_EMAIL");
                String cpf = rs.getString("cl_CPF");
                String nasc = rs.getString("cl_NASC");
                String genero = rs.getString("cl_GENERO");
                String pass = rs.getString("cl_PASS");
                int end_f = Integer.parseInt(rs.getString("cl_END_FATURAMENTO"));
                int end_e = Integer.parseInt(rs.getString("cl_END_ENTREGA"));

                cl = new Cliente(id, nome, email, cpf, nasc, genero, pass, end_f, end_e);
            }
            System.out.println("Sucesso na pesquisa!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return cl;
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
}