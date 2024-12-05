package br.com.catolica.academia.Model;

import br.com.catolica.academia.Contract.IProfessorInterface;

import java.util.ArrayList;

public class Professor extends Pessoa implements IProfessorInterface{
    private String especialidade;
    private double salario;
    private ArrayList<Turma> turmas;

    public Professor(String nome, String cpf, String telefone, String endereco, String dataNascimento, String email, String especialidade, double salario, ArrayList<Turma> turmas) {
        super(nome, cpf, telefone, endereco, dataNascimento, email);
        this.especialidade = especialidade;
        this.salario = salario;
        this.turmas = turmas;
    }

    public void exibirMenu() {
        System.out.println("=== Menu Professor ===");
        System.out.println("1. Criar turma");
        System.out.println("2. Listar turmas");
        System.out.println("3. Sair");
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public double getSalario() {
        return salario;
    }

    public Turma criarTurma(String nomeDaTurma) {
        Turma novaTurma = new Turma(nomeDaTurma, this);
        turmas.add(novaTurma);
        System.out.println("Turma \"" + nomeDaTurma + "\" criada com sucesso!");
        return novaTurma;
    }

    public void listarTurma() {
        System.out.println("Turmas do professor " + getNome() + ":");
        for (Turma turma : turmas) {
            System.out.println("- " + turma);
        }
    }

    @Override
    public String exibirDetalhes() {
        return "Professor: " + getNome() + ", Email: " + getEmail() + ", Especialidade: " + especialidade + ", Salário: " + salario;
    }

}
