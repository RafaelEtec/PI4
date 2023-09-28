package model;

public class Imagem {
    private int id;
    private int pr_id;
    private String path;
    private Boolean defaultImg;

    public Imagem(int id, int pr_id, String path, Boolean defaultImg) {
        this.id = id;
        this.pr_id = pr_id;
        this.path = path;
        this.defaultImg = defaultImg;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getDefaultImg() {
        return defaultImg;
    }

    public void setDefaultImg(Boolean defaultImg) {
        this.defaultImg = defaultImg;
    }
}