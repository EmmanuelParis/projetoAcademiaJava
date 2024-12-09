package br.com.catolica.academia.Model;

import br.com.catolica.academia.Contract.IProfessorInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Pessoa implements IProfessorInterface {
    private String especialidade;
    private double salario;
    private ArrayList<Turma> turmas;

    public Professor(String nome, String cpf, String telefone, String endereco, String dataNascimento, String email,
                     String especialidade, double salario) {
        super(nome, cpf, telefone, endereco, dataNascimento, email);
        this.especialidade = especialidade;
        this.salario = salario;
        this.turmas = new ArrayList<>();
    }

    public void criarTurma(String nomeDaTurma) {
        Turma novaTurma = new Turma(nomeDaTurma, this);
        turmas.add(novaTurma);
        System.out.println("Turma \"" + nomeDaTurma + "\" criada com sucesso!");
    }

    public void listarTurmas() {
        System.out.println("Turmas do professor " + getNome() + ":");
        for (Turma turma : turmas) {
            System.out.println("- " + turma.getNome());
        }
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("=== Menu Professor ===");
            System.out.println("1. Criar turma");
            System.out.println("2. Listar turmas");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da turma: ");
                    String nomeDaTurma = scanner.nextLine();
                    criarTurma(nomeDaTurma);
                    break;
                case 2:
                    listarTurmas();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    @Override
    public String exibirDetalhes() {
        return "Professor: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "Endereço: " + getEndereco() + "\n" +
                "Data de Nascimento: " + getDataNascimento() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Especialidade: " + especialidade + "\n" +
                "Salário: R$ " + salario + "\n" +
                "Turmas: " + (turmas.isEmpty() ? "Nenhuma turma criada" : turmas.size() + " turma(s)");
    }

}
