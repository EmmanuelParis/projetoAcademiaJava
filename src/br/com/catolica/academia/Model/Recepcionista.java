package br.com.catolica.academia.Model;

import br.com.catolica.academia.Contract.IRecepcionistaInterface;
import br.com.catolica.academia.Enum.EnumStatusPagamento;
import br.com.catolica.academia.Enum.EnumTipoPlano;

import java.util.ArrayList;
import java.util.Scanner;

public class Recepcionista extends Pessoa implements IRecepcionistaInterface {
    private String turno;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;

    public Recepcionista(String nome, String cpf, String telefone, String endereco, String dataNascimento,
                         String email, String turno) {
        super(nome, cpf, telefone, endereco, dataNascimento, email);
        this.turno = turno;
        this.alunos = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    public void cadastrarAluno() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Aluno ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        for (Aluno aluno : alunos) {
            if (aluno.getCpf().equals(cpf)) {
                System.out.println("Erro: Já existe um aluno cadastrado com este CPF.");
                return;
            }
        }

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.println("Escolha o tipo de plano:");
        for (EnumTipoPlano plano : EnumTipoPlano.values()) {
            System.out.println("- " + plano);
        }
        EnumTipoPlano planoContratado;
        try {
            planoContratado = EnumTipoPlano.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Plano inválido. Usando plano padrão: MENSAL.");
            planoContratado = EnumTipoPlano.MENSAL;
        }

        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        System.out.print("Altura (m): ");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Escolha o status de pagamento:");
        for (EnumStatusPagamento status : EnumStatusPagamento.values()) {
            System.out.println("- " + status);
        }
        EnumStatusPagamento statusPagamento;
        try {
            statusPagamento = EnumStatusPagamento.valueOf(scanner.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Status inválido. Usando status padrão: PENDENTE.");
            statusPagamento = EnumStatusPagamento.PENDENTE;
        }


        Aluno novoAluno = new Aluno(nome, cpf, telefone, endereco, dataNascimento, email, matricula, planoContratado, peso, altura, statusPagamento);
        alunos.add(novoAluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }


    public void alterarTurno(String novoTurno) {
        if (novoTurno == null || novoTurno.isEmpty()) {
            System.out.println("O novo turno não pode estar vazio.");
            return;
        }

        this.turno = novoTurno;
        System.out.println("Turno alterado para: " + novoTurno);
    }

    @Override
    public String exibirDetalhes(){return "Nome: " + getNome();}

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Menu Recepcionista ===");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Listar Alunos");
            System.out.println("4. Listar Professores");
            System.out.println("5. Alterar Turno");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    listarAlunos();
                    break;
                case 4:
                    listarProfessores();
                    break;
                case 5:
                    System.out.print("Digite o novo turno: ");
                    String novoTurno = scanner.nextLine();
                    alterarTurno(novoTurno);
                    System.out.println("Turno alterado com sucesso!");
                    break;
                case 6:
                    System.out.println("Encerrando o menu da recepcionista...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }


    public void cadastrarProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Professor ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Professor novoProfessor = new Professor(nome, cpf, telefone, endereco, dataNascimento, email, especialidade, salario);
        professores.add(novoProfessor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public void listarAlunos() {
        System.out.println("=== Lista de Alunos ===");
        for (Aluno aluno : alunos) {
            System.out.println(aluno.exibirDetalhes());
        }
    }

    public void listarProfessores() {
        System.out.println("=== Lista de Professores ===");
        for (Professor professor : professores) {
            System.out.println(professor.exibirDetalhes());
        }
    }
}
