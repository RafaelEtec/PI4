package model;

public class PedidoProduto {
    private int id;
    private int pr_id;
    private String pr_nome;
    private int qnt;
    private double val;

    public PedidoProduto() {}

    public PedidoProduto(int id, int pr_id, String pr_nome, int qnt, double val) {
        this.id = id;
        this.pr_id = pr_id;
        this.pr_nome = pr_nome;
        this.qnt = qnt;
        this.val = val;
    }

    public PedidoProduto(int pr_id, String pr_nome, int qnt, double val) {
        this.pr_id = pr_id;
        this.pr_nome = pr_nome;
        this.qnt = qnt;
        this.val = val;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPr_id() {
        return pr_id;
    }

    public void setPr_id(int pr_id) {
        this.pr_id = pr_id;
    }

    public String getPr_nome() {
        return pr_nome;
    }

    public void setPr_nome(String pr_nome) {
        this.pr_nome = pr_nome;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }
}