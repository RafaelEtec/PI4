package dao;

import model.Pedido;
import model.PedidoProduto;
import model.Produto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class peDAO {
    public boolean addPedido(Pedido pe) {
        String sql = "INSERT INTO tb_PEDIDO(pe_cl_ID, pe_TOTAL, pe_QNT, pe_en_ID, pe_FRETE, pe_PAGAMENTO, pe_STATUS) VALUES(?, ?, ?, ?, ?, ?, ?);";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pe.getCl_id());
            ps.setDouble(2, pe.getTotal());
            ps.setInt(3, pe.getQnt());
            ps.setInt(4, pe.getEndereco());
            ps.setString(5, pe.getFrete());
            ps.setString(6, pe.getPagamento());
            ps.setString(7, pe.getStatus());
            ps.execute();

            saida = true;
            System.out.println("Sucesso no cadastro do Pedido!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro do Pedido!");
        }
        return saida;
    }

    public void addPedidoProduto(PedidoProduto pr) {
        String sql = "INSERT INTO tb_PEDIDO_PRODUTO(pe_ID, pe_pr_ID, pe_pr_NOME, pe_pr_QNT, pe_VAL) VALUES(?, ?, ?, ?, ?);";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pr.getId());
            ps.setInt(2, pr.getPr_id());
            ps.setString(3, pr.getPr_nome());
            ps.setInt(4, pr.getQnt());
            ps.setDouble(5, pr.getVal());
            ps.execute();

            System.out.println("Sucesso no cadastro do Produto do Pedido!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro no cadastro do Produto do Pedido!");
        }
    }

    public int idPedido() {
        String sql = "SELECT MAX(pe_ID) FROM tb_PEDIDO;";
        int saida = 0;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                saida = rs.getInt(1);
            }
            System.out.println("Sucesso na pesquisa do ID do Pedido!");
            con.close();
        } catch (Exception ex) {
            System.out.println("Erro na pesquisa do ID do Pedido!");
        }
        return saida;
    }

    public boolean altStatusPedido(int id, String status) {
        String sql = "UPDATE tb_PEDIDO SET pe_STATUS = ? WHERE pe_ID = ?;";
        boolean saida = false;

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
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

    public List<Pedido> meusPedidos(int id) {
        String sql = "SELECT * FROM tb_PEDIDO WHERE pe_cl_ID = ?;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            List<Pedido> pes = new ArrayList<>();

            while (rs.next()) {
                int pe_id = rs.getInt(1);
                int pe_cl_id = rs.getInt(2);
                double pe_total = rs.getDouble(3);
                int pe_qnt = rs.getInt(4);
                int pe_end = rs.getInt(5);
                String pe_frete = rs.getString(6);
                String pe_pagamento = rs.getString(7);
                String pe_status = rs.getString(8);

                Pedido pe = new Pedido(pe_id, pe_cl_id, pe_total, pe_qnt, pe_end, pe_frete, pe_pagamento, pe_status);
                pes.add(pe);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return pes;
        }  catch (Exception ex) {
            System.out.println("Erro na listagem!");
            return Collections.emptyList();
        }
    }

    public List<Pedido> listaPedidos() {
        String sql = "SELECT * FROM tb_PEDIDO;";

        try {
            Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            System.out.println("Conectado");
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Pedido> pes = new ArrayList<>();

            while (rs.next()) {
                int pe_id = rs.getInt(1);
                int pe_cl_id = rs.getInt(2);
                double pe_total = rs.getDouble(3);
                int pe_qnt = rs.getInt(4);
                int pe_end = rs.getInt(5);
                String pe_frete = rs.getString(6);
                String pe_pagamento = rs.getString(7);
                String pe_status = rs.getString(8);

                Pedido pe = new Pedido(pe_id, pe_cl_id, pe_total, pe_qnt, pe_end, pe_frete, pe_pagamento, pe_status);
                pes.add(pe);
            }
            System.out.println("Sucesso na listagem!");
            con.close();

            return pes;
        }  catch (Exception ex) {
            System.out.println("Erro na listagem!");
            return Collections.emptyList();
        }
    }
}