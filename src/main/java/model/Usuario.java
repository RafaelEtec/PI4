package model;

public class Usuario {
    private int id;
    private String img;
    private String nome;
    private String email;
    private String cpf;
    private String num;
    private String nasc;
    private String pass;
    private String funcao;
    private Boolean status;

    public Usuario() {}

    public Usuario(int id, String img, String nome, String email, String cpf, String num, String nasc, String pass, String funcao, Boolean status) {
        this.id = id;
        this.img = img;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.num = num;
        this.nasc = nasc;
        this.pass = pass;
        this.funcao = funcao;
        this.status = status;
    }

    public Usuario(String img, String nome, String email, String cpf, String num, String nasc, String pass, String funcao, Boolean status) {
        this.img = img;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.num = num;
        this.nasc = nasc;
        this.pass = pass;
        this.funcao = funcao;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}