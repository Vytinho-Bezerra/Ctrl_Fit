package ctrlfit.entity;

public class Exercicio {

    private int codigo;
    private int matricula;
    private char divisaoTreino;
    private String nome;
    private int quantSeries;
    private int quantRepeticoes;
    private String observacoes;

    public Exercicio() {
    }

    public Exercicio(int codigo, int matricula, char divisaoTreino, String nome, int quantSeries, int quantRepeticoes, String observacoes) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.divisaoTreino = divisaoTreino;
        this.nome = nome;
        this.quantSeries = quantSeries;
        this.quantRepeticoes = quantRepeticoes;
        this.observacoes = observacoes;
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

    public char getDivisaoTreino() {
        return divisaoTreino;
    }

    public void setDivisaoTreino(char divisaoTreino) {
        this.divisaoTreino = divisaoTreino;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantSeries() {
        return quantSeries;
    }

    public void setQuantSeries(int quantSeries) {
        this.quantSeries = quantSeries;
    }

    public int getQuantRepeticoes() {
        return quantRepeticoes;
    }

    public void setQuantRepeticoes(int quantRepeticoes) {
        this.quantRepeticoes = quantRepeticoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
