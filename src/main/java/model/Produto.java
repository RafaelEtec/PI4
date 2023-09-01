package model;

public class Produto {
    private int id;
    private String img;
    private String nome;
    private String desc;
    private String data;
    private double val;
    private int fav;

    public Produto() {}

    public Produto(int id, String img, String nome, String desc, String data, double val, int fav) {
        this.id = id;
        this.img = img;
        this.nome = nome;
        this.desc = desc;
        this.data = data;
        this.val = val;
        this.fav = fav;
    }

    public Produto(String img, String nome, String desc, String data, double val, int fav) {
        this.img = img;
        this.nome = nome;
        this.desc = desc;
        this.data = data;
        this.val = val;
        this.fav = fav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }
}