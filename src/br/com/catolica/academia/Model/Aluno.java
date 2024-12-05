package br.com.catolica.academia.Model;

import br.com.catolica.academia.Contract.IAlunoInterface;
import br.com.catolica.academia.Enum.EnumStatusPagamento;
import br.com.catolica.academia.Enum.EnumTipoPlano;

import java.util.ArrayList;

public class Aluno extends Pessoa implements IAlunoInterface {
    private String matricula;
    private EnumTipoPlano planoContratado;
    private double peso;
    private double altura;
    private EnumStatusPagamento statusPagamento;
    private ArrayList<String> turmas;

    public Aluno(String nome, String cpf, String telefone, String endereco, String dataNascimento, String email,
                 String matricula, EnumTipoPlano planoContratado, double peso, double altura, EnumStatusPagamento statusPagamento) {
        super(nome, cpf, telefone, endereco, dataNascimento, email);
        this.matricula = matricula;
        this.planoContratado = planoContratado;
        this.peso = peso;
        this.altura = altura;
        this.statusPagamento = statusPagamento;
        this.turmas = new ArrayList<>();
    }

    public void exibirMenu() {
        System.out.println("=== Menu Aluno ===");
        System.out.println("1. Ver atividades");
        System.out.println("2. Matricular-se em uma turma");
        System.out.println("3. Sair");
    }

    public double calcularIMC() {
        try {
            if (this.altura <= 0) throw new IllegalArgumentException("Altura deve ser maior que zero.");
            return peso / (altura * altura);
        } catch (Exception e) {
            System.out.println("Erro ao calcular IMC: " + e.getMessage());
            return -1;
        }
    }

    public void matricularNaTurma(Turma turma) {
        turma.adicionarAluno(this);
    }

    public void alterarPlano(EnumTipoPlano novoPlano) {
        this.planoContratado = novoPlano;
    }

    @Override
    public String exibirDetalhes() {
        return "Aluno: " + getNome() + ", Matrícula: " + matricula + ", Plano: " + planoContratado;
    }
}