package ctrlfit.entity;

import java.util.Date;

public class Funcionario {

    private int codigo;
    private String nome;
    private String cargo;
    private String cpf;
    private Date dtNascimento;
    private String telefone;
    private String celular;
    private String endereco;
    private String bairro;
    private String cep;
    private char sexo;
    private double salario;
    private Date dtAdmissao;
    private String email;
    private String usuario;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(int codigo, String nome, String cargo, String cpf, Date dtNascimento, String telefone, String celular, String endereco, String bairro, String cep, char sexo, double salario, Date dtAdmisao, String email, String usuario, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf;
        this.dtNascimento = dtNascimento;
        this.telefone = telefone;
        this.celular = celular;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cep = cep;
        this.sexo = sexo;
        this.salario = salario;
        this.dtAdmissao = dtAdmisao;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDtAdmissao() {
        return dtAdmissao;
    }

    public void setDtAdmissao(Date dtAdmisao) {
        this.dtAdmissao = dtAdmisao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
