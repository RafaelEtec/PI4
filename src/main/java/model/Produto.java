package model;

public class Produto {
    private int id;
    private String nome;
    private String desc;
    private double val;
    private int qnt;
    private double ava;
    private Boolean status;
    private String img;
    private String tag;

    public Produto() {}

    public Produto(int id, String nome, String desc, double val, int qnt, double ava, Boolean status, String img) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.val = val;
        this.qnt = qnt;
        this.ava = ava;
        this.status = status;
        this.img = img;
    }

    public Produto(int id, String nome, String desc, double val, int qnt, double ava, boolean status) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.val = val;
        this.qnt = qnt;
        this.ava = ava;
        this.status = status;
    }

    public Produto(int id, String nome, String desc, double val, int qnt, double ava, String img, String tag) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.val = val;
        this.qnt = qnt;
        this.ava = ava;
        this.img = img;
        this.tag = tag;
    }

    public Produto(int id, String nome, String desc, double val, int qnt, double ava, Boolean status, String img, String tag) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.val = val;
        this.qnt = qnt;
        this.ava = ava;
        this.status = status;
        this.img = img;
        this.tag = tag;
    }

    public Produto(String nome, String desc, double val, int qnt, double ava) {
        this.nome = nome;
        this.desc = desc;
        this.val = val;
        this.qnt = qnt;
        this.ava = ava;
    }

    public Produto(int id, String nome, String desc, String img, double val) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.img = img;
        this.val = val;
    }

    public Produto(String nome, String desc, double val, int qnt, double ava, String img, String tag) {
        this.nome = nome;
        this.desc = desc;
        this.val = val;
        this.qnt = qnt;
        this.ava = ava;
        this.img = img;
        this.tag = tag;
    }

    public Produto(String nome, String desc) {
        this.nome = nome;
        this.desc = desc;
    }

    public Produto(int id, String nome, String desc, String img) {
        this.id = id;
        this.nome = nome;
        this.desc = desc;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}