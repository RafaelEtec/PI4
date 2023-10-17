package model;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String cpf;
    private String nasc;
    private String genero;
    private String pass;
    private int end_faturamento;
    private int end_entrega;

    public Cliente() {}

    public Cliente(int id, String nome, String email, String cpf, String nasc, String genero, String pass, int end_faturamento, int end_entrega) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nasc = nasc;
        this.genero = genero;
        this.pass = pass;
        this.end_faturamento = end_faturamento;
        this.end_entrega = end_entrega;
    }

    public Cliente(int id, String nome, String email, String pass) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pass = pass;
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

    public String getNasc() {
        return nasc;
    }

    public void setNasc(String nasc) {
        this.nasc = nasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEnd_faturamento() {
        return end_faturamento;
    }

    public void setEnd_faturamento(int end_faturamento) {
        this.end_faturamento = end_faturamento;
    }

    public int getEnd_entrega() {
        return end_entrega;
    }

    public void setEnd_entrega(int end_entrega) {
        this.end_entrega = end_entrega;
    }
}
