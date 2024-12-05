package br.com.catolica.academia.Model;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String dataNascimento;
    private String email;

    public Pessoa(String nome, String cpf, String telefone, String endereco, String dataNascimento, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public abstract String exibirDetalhes();

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void atualizarEndereco(String novoEndereco) {
        this.endereco = novoEndereco;
    }

    public int calcularIdade() {
        int anoAtual = 2024;
        int anoNascimento = Integer.parseInt(dataNascimento.split("/")[2]);
        return anoAtual - anoNascimento;
    }

    public abstract void exibirMenu();

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Telefone: " + telefone;
    }
}
