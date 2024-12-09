package br.com.catolica.academia.Main;

import br.com.catolica.academia.Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Professor> professores = new ArrayList<>();
        Recepcionista recepcionista = new Recepcionista(
                "Emmanuel Páris",
                "1029384756",
                "839123123",
                "Rua CHUCHUUU",
                "27/12/2005",
                "email@gmail.com",
                "Manhã"
        );

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Sistema de Gerenciamento de Academia ===");
            System.out.println("1. Menu Aluno");
            System.out.println("2. Menu Professor");
            System.out.println("3. Menu Recepcionista");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (alunos.isEmpty()) {
                        System.out.println("Não há alunos cadastrados. Cadastre primeiro no menu recepcionista.");
                        break;
                    }
                    System.out.println("=== Alunos Disponíveis ===");
                    for (int i = 0; i < alunos.size(); i++) {
                        System.out.println((i + 1) + ". " + alunos.get(i).getNome());
                    }
                    System.out.print("Escolha um aluno para acessar o menu: ");
                    int alunoIndex = scanner.nextInt() - 1;
                    if (alunoIndex >= 0 && alunoIndex < alunos.size()) {
                        alunos.get(alunoIndex).exibirMenu();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 2:
                    if (professores.isEmpty()) {
                        System.out.println("Não há professores cadastrados. Cadastre primeiro no menu recepcionista.");
                        break;
                    }
                    System.out.println("=== Professores Disponíveis ===");
                    for (int i = 0; i < professores.size(); i++) {
                        System.out.println((i + 1) + ". " + professores.get(i).getNome());
                    }
                    System.out.print("Escolha um professor para acessar o menu: ");
                    int professorIndex = scanner.nextInt() - 1;
                    if (professorIndex >= 0 && professorIndex < professores.size()) {
                        professores.get(professorIndex).exibirMenu();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    recepcionista.exibirMenu();
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
