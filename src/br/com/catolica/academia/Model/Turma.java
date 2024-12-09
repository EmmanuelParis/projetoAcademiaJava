package br.com.catolica.academia.Model;

import java.util.ArrayList;

public class Turma {
    private String nome;
    private Professor professor;
    private ArrayList<Aluno> alunos;
    private ArrayList<String> atividades;

    public Turma(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAluno(Aluno aluno) {
        if (!alunos.contains(aluno)) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " matriculado na turma " + nome + ".");
        } else {
            System.out.println("Aluno " + aluno.getNome() + " já está matriculado na turma.");
        }
    }

    public void removerAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            alunos.remove(aluno);
            System.out.println("Aluno " + aluno.getNome() + " removido da turma " + nome + ".");
        } else {
            System.out.println("Aluno não encontrado na turma.");
        }
    }

    public void adicionarAtividade(String atividade) {
        atividades.add(atividade);
        System.out.println("Atividade \"" + atividade + "\" adicionada à turma " + nome + ".");
    }

    public void listarAlunos() {
        System.out.println("Alunos matriculados na turma " + nome + ":");
        for (Aluno aluno : alunos) {
            System.out.println("- " + aluno.getNome());
        }
    }

    public void exibirInfo() {
        System.out.println("Turma: " + nome + ", Professor: " + professor.getNome());
        listarAlunos();
        System.out.println("Atividades: " + atividades);
    }

    @Override
    public String toString() {
        return nome + " (Professor: " + professor.getNome() + ")";
    }
}