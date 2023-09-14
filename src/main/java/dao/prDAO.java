package dao;

import model.Produto;
import model.Usuario;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class prDAO {
    public boolean addProduct(Produto pr) {
        String sql = "INSERT INTO tb_PRODUTO (pr_NOME, pr_DESC, pr_VAL, pr_QNT, pr_AVA) VALUES (?, ?, ?, ?, ?);";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNome());
            ps.setString(2, pr.getDesc());
            ps.setDouble(3, pr.getVal());
            ps.setInt(4, pr.getQnt());
            ps.setDouble(5, pr.getAva());
            ps.execute();

            saida = true;
            System.out.println("Sucesso no cadastro do Produto!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro do Produto!");
        }
        return saida;
    }

    public List<Produto> listProducts() {
        String sql = "SELECT * FROM tb_PRODUTO ORDER BY pr_ID DESC;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Produto> prs = new ArrayList<>();

            while (rs.next()) {
                int pr_ID = rs.getInt("pr_ID");
                String pr_NOME = rs.getString("pr_NOME");
                String pr_DESC = rs.getString("pr_DESC");
                Double pr_VAL= rs.getDouble("pr_VAL");
                int pr_QNT = rs.getInt("pr_QNT");
                Double pr_AVA = rs.getDouble("pr_AVA");
                boolean pr_STATUS = rs.getBoolean("pr_STATUS");

                Produto pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_VAL, pr_QNT, pr_AVA, pr_STATUS);
                prs.add(pr);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return prs;
        } catch (Exception ex) {
            System.out.println("Erro na listagem!");
            return Collections.emptyList();
        }
    }

    public List<Produto> listProductsByNome(String nomeToSearch) {
        String sql = "SELECT * FROM tb_PRODUTO WHERE pr_NOME LIKE ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + nomeToSearch + "%");
            ResultSet rs = ps.executeQuery();
            List<Produto> prs = new ArrayList<>();

            while (rs.next()) {
                int pr_ID = rs.getInt("pr_ID");
                String pr_NOME = rs.getString("pr_NOME");
                String pr_DESC = rs.getString("pr_DESC");
                Double pr_VAL= rs.getDouble("pr_VAL");
                int pr_QNT = rs.getInt("pr_QNT");
                Double pr_AVA = rs.getDouble("pr_AVA");
                boolean pr_STATUS = rs.getBoolean("pr_STATUS");

                Produto pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_VAL, pr_QNT, pr_AVA, pr_STATUS);
                prs.add(pr);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return prs;
        } catch (Exception ex) {
            System.out.println("Erro na listagem!");
            return Collections.emptyList();
        }
    }

    public boolean getStatus(int id) {
        String sql = "SELECT pr_STATUS FROM tb_PRODUTO WHERE pr_ID = ?;";
        boolean status = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getBoolean("pr_STATUS")) {
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
                "UPDATE tb_PRODUTO SET pr_STATUS = false WHERE pr_ID = ?;"
              : "UPDATE tb_PRODUTO SET pr_STATUS = true WHERE pr_ID = ?;";

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

    public Produto productInfo(int id) {
        String sql = "";
        Produto pr = new Produto();

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int pr_ID = rs.getInt("pr_ID");
                String pr_NOME = rs.getString("pr_NOME");
                String pr_DESC = rs.getString("pr_DESC");
                Double pr_VAL = rs.getDouble("pr_VAL");
                int pr_QNT = rs.getInt("pr_QNT");
                Double pr_AVA = rs.getDouble("pr_AVA");
                Boolean pr_STATUS = rs.getBoolean("pr_STATUS");

                pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_VAL, pr_QNT, pr_AVA, pr_STATUS);
            }
            System.out.println("Sucesso na coleta!");
            con.close();

            return pr;
        } catch (Exception ex) {
            System.out.println("Erro na coleta!");
            return null;
        }
    }

    public boolean updateProduct(Produto pr) {
        String sql = "UPDATE tb_PRODUTO SET pr_NOME = ?, pr_DESC = ?, pr_VAL = ?, pr_QNT = ?, pr_AVA, pr_STATUS = ? WHERE pr_ID = ?;";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pr.getNome());
            ps.setString(2, pr.getDesc());
            ps.setDouble(3, pr.getVal());
            ps.setInt(4, pr.getQnt());
            ps.setDouble(5, pr.getAva());
            ps.setBoolean(6, pr.getStatus());
            ps.setInt(7, pr.getId());
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