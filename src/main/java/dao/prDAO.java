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
        String sql = "INSERT INTO tb_PRODUTO (pr_NOME, pr_DESC, pr_VAL, pr_QNT, pr_AVA, pr_IMG, pr_TAG) VALUES (?, ?, ?, ?, ?, ?, ?);";
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
            ps.setString(6, pr.getImg());
            ps.setString(7, pr.getTag());
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
                String pr_IMG = rs.getString("pr_IMG");

                Produto pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_VAL, pr_QNT, pr_AVA, pr_STATUS, pr_IMG);
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
        String sql = "SELECT * FROM tb_PRODUTO WHERE pr_NOME LIKE ? ORDER BY pr_ID DESC;";

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
                String pr_IMG = rs.getString("pr_IMG");

                Produto pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_VAL, pr_QNT, pr_AVA, pr_STATUS, pr_IMG);
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
        String sql = "SELECT * FROM tb_PRODUTO WHERE pr_ID = ?;";
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
                String pr_IMG = rs.getString("pr_IMG");
                String pr_TAG = rs.getString("pr_TAG");

                pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_VAL, pr_QNT, pr_AVA, pr_STATUS, pr_IMG, pr_TAG);
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
        String sql = "UPDATE tb_PRODUTO SET pr_NOME = ?, pr_DESC = ?, pr_VAL = ?, pr_QNT = ?, pr_AVA = ?, pr_IMG = ?, pr_TAG = ? WHERE pr_ID = ?;";
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
            ps.setString(6, pr.getImg());
            ps.setString(7, pr.getTag());
            ps.setInt(8, pr.getId());
            ps.execute();
            saida = true;
            System.out.println("Sucesso na atualização!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na atualização!");
        }
        return saida;
    }

    public boolean updateProductQnt(int id, int qnt) {
        String sql = "UPDATE tb_PRODUTO SET pr_QNT = ? WHERE pr_ID = ?;";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, qnt);
            ps.setInt(2, id);
            ps.execute();
            saida = true;
            System.out.println("Sucesso na atualização!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na atualização!");
        }
        return saida;
    }

    public void removeOne(int id) {
        String sql = "UPDATE tb_PRODUTO SET pr_QNT = pr_QNT - 1 WHERE pr_ID = ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Sucesso na atualização! -1");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na atualização!");
        }
    }

    public void addOne(int id) {
        String sql = "UPDATE tb_PRODUTO SET pr_QNT = pr_QNT + 1 WHERE pr_ID = ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Sucesso na atualização! +1");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na atualização!");
        }
    }

    public List<Produto> listProductsByName(String name) {
        String sql = "SELECT pr_ID, pr_NOME, pr_DESC, pr_IMG, pr_VAL FROM tb_PRODUTO WHERE pr_NOME LIKE ? AND pr_STATUS = TRUE AND pr_QNT > 0";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            List<Produto> prs = new ArrayList<>();

            while (rs.next()) {
                int pr_ID = rs.getInt("pr_ID");
                String pr_NOME = rs.getString("pr_NOME");
                String pr_DESC = rs.getString("pr_DESC");
                String pr_IMG = rs.getString("pr_IMG");
                double pr_VAL = rs.getDouble("pr_VAL");

                Produto pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_IMG, pr_VAL);
                prs.add(pr);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return prs;
        } catch (Exception ex) {
            System.out.println("Erro na listagem de " + name + "!");
            return Collections.emptyList();
        }
    }

    public List<Produto> listCarrouselCardsByTag(String tag) {
        String sql = "SELECT TOP 3 pr_ID, pr_NOME, pr_DESC, pr_IMG FROM tb_PRODUTO WHERE pr_TAG LIKE ? AND pr_STATUS = TRUE AND pr_QNT > 0 ORDER BY RAND();";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tag);
            ResultSet rs = ps.executeQuery();
            List<Produto> prs = new ArrayList<>();

            while (rs.next()) {
                int pr_ID = rs.getInt("pr_ID");
                String pr_NOME = rs.getString("pr_NOME");
                String pr_DESC = rs.getString("pr_DESC");
                String pr_IMG = rs.getString("pr_IMG");

                Produto pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_IMG);
                prs.add(pr);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return prs;
        } catch (Exception ex) {
            System.out.println("Erro na listagem de " + tag + "!");
            return Collections.emptyList();
        }
    }

    public List<Produto> listRandomProducts() {
        String sql = "SELECT TOP 12 pr_ID, pr_NOME, pr_DESC, pr_IMG, pr_VAL FROM tb_PRODUTO WHERE pr_STATUS = TRUE AND pr_QNT > 0 ORDER BY RAND();";

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
                String pr_IMG = rs.getString("pr_IMG");
                double pr_VAL = rs.getDouble("Pr_VAL");

                Produto pr = new Produto(pr_ID, pr_NOME, pr_DESC, pr_IMG, pr_VAL);
                prs.add(pr);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return prs;
        } catch (Exception ex) {
            System.out.println("Erro na listagem dos produtos!");
            return Collections.emptyList();
        }
    }
}