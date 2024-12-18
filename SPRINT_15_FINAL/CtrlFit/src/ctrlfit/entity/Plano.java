package ctrlfit.entity;

public class Plano {

    private int codigo;
    private String nome;
    private double preco;
    private int duracao;
    private String descricao;

    public Plano() {
    }

    public Plano(int codigo, String nome, double preco, int duracao, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.duracao = duracao;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
