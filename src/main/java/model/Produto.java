package model;

public class Produto {
    private int id;
    private String nome;
    private String desc;
    private double val;
    private int qnt;
    private double ava;
    private Boolean status;

    public Produto() {}

    public Produto(int id, String nome, String desc, double val, int qnt, double ava, boolean status) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.val = val;
        this.qnt = qnt;
        this.ava = ava;
        this.status = status;
    }

    public Produto(String nome, String desc, double val, int qnt, double ava) {
        this.nome = nome;
        this.desc = desc;
        this.val = val;
        this.qnt = qnt;
        this.ava = ava;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public double getAva() {
        return ava;
    }

    public void setAva(double ava) {
        this.ava = ava;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}