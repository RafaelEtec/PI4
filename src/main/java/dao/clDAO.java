package dao;

import model.Cliente;
import model.Endereco;
import model.Usuario;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class clDAO {

    public boolean addClient(Cliente cl) {
        String sql = "INSERT INTO tb_CLIENTE (cl_NOME, cl_EMAIL, cl_CPF, cl_NASC, cl_GENERO, cl_PASS, cl_END_FATURAMENTO, cl_END_ENTREGA) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        boolean saida = false;
        String pass = encrypt(cl.getPass());
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNome());
            ps.setString(2, cl.getEmail());
            ps.setString(3, cl.getCpf());
            ps.setString(4, cl.getNasc());
            ps.setString(5, cl.getGenero());
            ps.setString(6, pass);
            ps.setInt(7, 1);
            ps.setInt(8, 2);
            ps.execute();

            saida = true;
            System.out.println("Sucesso no cadastro do Cliente!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro do Cliente!");
        }
        return saida;
    }

    public int pegaIdPorEmail(String email) {
        String sql = "SELECT cl_ID FROM tb_CLIENTE WHERE cl_EMAIL = ?";
        int id = 0;
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("cl_ID");
            }
            System.out.println("Sucesso na pesquisa do ID");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa do ID!");
        }
        return id;
    }

    public boolean addEndereco(Endereco en) {
        String sql = "INSERT INTO tb_ENDERECO (en_cl_ID, en_cl_N, en_TIPO, en_CEP, en_LOG, en_NUM, en_COM, en_CID, en_EST, en_DEFAULT) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, en.getCl_id());
            ps.setInt(2, en.getCl_n());
            ps.setString(3, en.getTipo());
            ps.setString(4, en.getCep());
            ps.setString(5, en.getLog());
            ps.setString(6, en.getNum());
            ps.setString(7, en.getCom());
            ps.setString(8, en.getCid());
            ps.setString(9, en.getEst());
            ps.setBoolean(10, en.isIsdefault());
            ps.execute();
            saida = true;
            System.out.println("Sucesso no cadastro do Endereco!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro do Endereco!");
        }
        return saida;
    }

    public int pegaMaxCLN(int cliente) {
        String sql = "SELECT MAX(en_CL_N) FROM tb_ENDERECO WHERE en_CL_ID = ?;";
        int cln = 2;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cln = rs.getInt(1);
            }

            con.close();
            System.out.println("Sucesso na pesquisa de endereços");
            return cln + 1;
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa de endereços!");
            return cln;
        }
    }

    public List<Endereco> pegaEnderecosCliente(int id) {
        String sql = "SELECT * FROM tb_ENDERECO WHERE en_CL_ID = ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Endereco> enderecos = new ArrayList<>();

            while (rs.next()) {
                int en_ID = rs.getInt("en_ID");
                int en_CL_ID = rs.getInt("en_CL_ID");
                int en_CL_N = rs.getInt("en_CL_N");
                String en_TIPO = rs.getString("en_TIPO");
                String en_CEP = rs.getString("en_CEP");
                String en_LOG = rs.getString("en_LOG");
                String en_NUM = rs.getString("en_NUM");
                String en_COM = rs.getString("en_COM");
                String en_CID = rs.getString("en_CID");
                String en_EST = rs.getString("en_EST");
                boolean en_DEFAULT = rs.getBoolean("en_DEFAULT");

                Endereco en = new Endereco(en_ID, en_CL_ID, en_CL_N, en_TIPO, en_CEP, en_LOG, en_NUM, en_COM, en_CID, en_EST, en_DEFAULT);
                enderecos.add(en);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return enderecos;
        } catch (Exception ex) {
            System.out.println("Erro na listagem de endereços!");
            return Collections.emptyList();
        }
    }

    public boolean newDefaultClienteEndereco(int cliente, int endereco) {
        String sql = "UPDATE tb_CLIENTE SET cl_END_ENTREGA = ? WHERE cl_ID = ?";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, endereco);
            ps.setInt(2, cliente);
            ps.execute();

            System.out.println("Sucesso na atualização do endereço do cliente");
            con.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro na atualização do endereço do cliente");
            return false;
        }
    }

    public boolean downAllDefaultEndereco(int cliente) {
        String sql = "UPDATE tb_ENDERECO SET en_DEFAULT = false WHERE en_CL_ID = ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, cliente);
            ps.execute();

            System.out.println("Sucesso na atualização do endereço padrão do cliente");
            con.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Erro na atualização do endereço padrão do cliente!");
            return false;
        }
    }

    public boolean newDefaultEndereco(int endereco) {
        String sql = "UPDATE tb_ENDERECO SET en_DEFAULT = true WHERE en_ID = ?;";
        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, endereco);
            ps.execute();

            con.close();
            System.out.println("Sucesso na atualização do endereço padrão");
            return true;
        } catch (Exception ex) {
            System.out.println("Erro na atualização do endereço padrão!");
            return false;
        }
    }

    public Endereco pegaEnderecoDefault(int id) {
        String sql = "SELECT * FROM tb_ENDERECO WHERE en_CL_ID = ? AND en_DEFAULT = true;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Endereco en = new Endereco();

            while (rs.next()) {
                int en_ID = rs.getInt("en_ID");
                int en_CL_ID = rs.getInt("en_CL_ID");
                int en_CL_N = rs.getInt("en_CL_N");
                String en_TIPO = rs.getString("en_TIPO");
                String en_CEP = rs.getString("en_CEP");
                String en_LOG = rs.getString("en_LOG");
                String en_NUM = rs.getString("en_NUM");
                String en_COM = rs.getString("en_COM");
                String en_CID = rs.getString("en_CID");
                String en_EST = rs.getString("en_EST");
                boolean en_DEFAULT = rs.getBoolean("en_DEFAULT");

                en = new Endereco(en_ID, en_CL_ID, en_CL_N, en_TIPO, en_CEP, en_LOG, en_NUM, en_COM, en_CID, en_EST, en_DEFAULT);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return en;
        } catch (Exception ex) {
            System.out.println("Erro na listagem de endereços!");
            return null;
        }
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
        String sql = "SELECT * FROM tb_CLIENTE WHERE cl_EMAIL = ?";
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

    public Cliente sessionPorId(int sessionId) {
        String sql = "SELECT * FROM tb_CLIENTE WHERE cl_ID = ?";
        Cliente cl = new Cliente();

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sessionId);
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

    public boolean checkExistance(String info) {
        String sql = "SELECT EXISTS (SELECT 1 FROM tb_CLIENTE WHERE cl_EMAIL = ? OR cl_CPF = ?;";
        boolean exists = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, info);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getBoolean(1)) {
                    exists = true;
                }
            }
            System.out.println("busca feita");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na busca!");
        }
        return exists;
    }

    public boolean updateCliente(String info, String target, int id) {
        String sql = "";
        boolean saida = false;

        switch (target) {
            case "nome":
                sql = "UPDATE tb_CLIENTE SET cl_NOME = ? WHERE cl_ID = ?;";
                break;
            case "email":
                sql = "UPDATE tb_CLIENTE SET cl_EMAIL = ? WHERE cl_ID = ?;";
                break;
            case "cpf":
                sql = "UPDATE tb_CLIENTE SET cl_CPF = ? WHERE cl_ID = ?;";
                break;
            case "nasc":
                sql = "UPDATE tb_CLIENTE SET cl_NASC = ? WHERE cl_ID = ?;";
                break;
            case "genero":
                sql = "UPDATE tb_CLIENTE SET cl_GENERO = ? WHERE cl_ID = ?;";
                break;
            default:
                sql = "";
                break;
        }

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, info);
            ps.setInt(2, id);
            ps.execute();
            saida = true;
            System.out.println("Sucesso na atualização");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na atualização!");
        }
        return saida;
    }
}