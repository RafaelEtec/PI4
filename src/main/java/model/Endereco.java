package model;

public class Endereco {
    private int id;
    private int cl_id;
    private int cl_n;
    private String tipo;
    private String cep;
    private String log;
    private String num;
    private String com;
    private String cid;
    private String est;
    private boolean isdefault;

    public Endereco(int id, int cl_id, int cl_n, String tipo, String cep, String log, String num, String com, String cid, String est, boolean isdefault) {
        this.id = id;
        this.cl_id = cl_id;
        this.cl_n = cl_n;
        this.tipo = tipo;
        this.cep = cep;
        this.log = log;
        this.num = num;
        this.com = com;
        this.cid = cid;
        this.est = est;
        this.isdefault = isdefault;
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

    public int getCl_n() {
        return cl_n;
    }

    public void setCl_n(int cl_n) {
        this.cl_n = cl_n;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public boolean isIsdefault() {
        return isdefault;
    }

    public void setIsdefault(boolean isdefault) {
        this.isdefault = isdefault;
    }
}