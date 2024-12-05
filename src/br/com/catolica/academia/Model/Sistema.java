package br.com.catolica.academia.Model;

import java.util.HashMap;
import java.util.Scanner;

public class Sistema {
    private HashMap<String, Pessoa> usuarios;
    private Pessoa usuarioAtual;
    private Scanner scanner;

    public Sistema() {
        usuarios = new HashMap<>();
        scanner = new Scanner(System.in);
        usuarioAtual = null;
    }

    public void cadastrarUsuario() {
        System.out.println("Escolha o tipo de usuário: 1 - Aluno, 2 - Professor");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        if (usuarios.containsKey(cpf)) {
            System.out.println("Erro: CPF já cadastrado!");
            return;
        }

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o email: ");
        String email = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Digite a matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Digite o curso: ");
            String curso = scanner.nextLine();
            Aluno aluno = new Aluno(nome, email, telefone, endereco, cpf, matricula, curso);
            usuarios.put(cpf, aluno);
            System.out.println("Cadastro de Aluno realizado com sucesso!");
        } else if (tipo == 2) {
            System.out.print("Digite a especialidade: ");
            String especialidade = scanner.nextLine();
            Professor professor = new Professor(nome, email, telefone, endereco, cpf, especialidade);
            usuarios.put(cpf, professor);
            System.out.println("Cadastro de Professor realizado com sucesso!");
        } else {
            System.out.println("Opção inválida!");
        }
    }

    public boolean login() {
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        Pessoa usuario = usuarios.get(cpf);

        if (usuario != null) {
            usuarioAtual = usuario;
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("CPF não encontrado.");
            return false;
        }
    }

    public void logout() {
        if (usuarioAtual != null) {
            System.out.println("Logout realizado com sucesso.");
            usuarioAtual = null;
        } else {
            System.out.println("Nenhum usuário está logado.");
        }
    }

    public void exibirMenu() {
        if (usuarioAtual == null) {
            System.out.println("Nenhum usuário logado.");
            return;
        }

        usuarioAtual.exibirMenu();

        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (usuarioAtual instanceof Aluno) {
            Aluno aluno = (Aluno) usuarioAtual;
            switch (opcao) {
                case 1:
                    aluno.verAtividades();
                    break;
                case 2:
                    aluno.matricularNaTurma(Turma turma);
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } else if (usuarioAtual instanceof Professor) {
            Professor professor = (Professor) usuarioAtual;
            switch (opcao) {
                case 1:
                    professor.criarTurma();
                    break;
                case 2:
                    professor.listarTurmas();
                    break;
                case 3:
                    logout();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}