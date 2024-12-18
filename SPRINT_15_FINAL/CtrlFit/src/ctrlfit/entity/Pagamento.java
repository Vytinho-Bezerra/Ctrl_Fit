package ctrlfit.entity;

import java.util.Date;

public class Pagamento {

    private int codigo;
    private int matricula;
    private String nome;
    private String plano;
    private double preco;
    private String forma;
    private Date dtPagamento;
    private Date dtInicio;
    private Date dtFim;
    private String situacao;

    public Pagamento() {
    }

    public Pagamento(int codigo, int matricula, String nome, String plano, double preco, String forma, Date dtPagamento, Date dtInicio, Date dtFim, String situacao) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.plano = plano;
        this.preco = preco;
        this.forma = forma;
        this.dtPagamento = dtPagamento;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.situacao = situacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public Date getDtPagamento() {
        return dtPagamento;
    }

    public void setDtPagamento(Date dtPagamento) {
        this.dtPagamento = dtPagamento;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return dtFim;
    }

    public void setDtFim(Date dtFim) {
        this.dtFim = dtFim;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

}
