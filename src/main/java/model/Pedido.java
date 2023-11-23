package model;

public class Pedido {
    private int id;
    private int cl_id;
    private double total;
    private int qnt;
    private int endereco;
    private String frete;
    private String pagamento;
    private String status;

    public Pedido() {}

    public Pedido(int cl_id, double total, int qnt, int endereco, String frete, String pagamento, String status) {
        this.cl_id = cl_id;
        this.total = total;
        this.qnt = qnt;
        this.endereco = endereco;
        this.frete = frete;
        this.pagamento = pagamento;
        this.status = status;
    }

    public Pedido(int id, int cl_id, double total, int qnt, int endereco, String frete, String pagamento, String status) {
        this.id = id;
        this.cl_id = cl_id;
        this.total = total;
        this.qnt = qnt;
        this.endereco = endereco;
        this.frete = frete;
        this.pagamento = pagamento;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCl_id() {
        return cl_id;
    }

    public void setCl_id(int cl_id) {
        this.cl_id = cl_id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}