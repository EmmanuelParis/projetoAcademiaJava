package br.com.catolica.academia.Model;

import br.com.catolica.academia.Contract.IAlunoInterface;
import br.com.catolica.academia.Enum.EnumStatusPagamento;
import br.com.catolica.academia.Enum.EnumTipoPlano;

import java.util.ArrayList;
import java.util.Scanner;

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

    public double calcularIMC() {
        try {
            if (this.altura <= 0) throw new IllegalArgumentException("Altura deve ser maior que zero.");
            return peso / (altura * altura);
        } catch (Exception e) {
            System.out.println("Erro ao calcular IMC: " + e.getMessage());
            return -1;
        }
    }

    public void alterarPlano(EnumTipoPlano novoPlano) {
        if (novoPlano != null) {
            this.planoContratado = novoPlano;
            System.out.println("Plano alterado com sucesso para: " + novoPlano);
        } else {
            System.out.println("Erro: Novo plano não pode ser nulo.");
        }
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Menu Aluno ===");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Listar turmas");
            System.out.println("3. Alterar plano");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    double imc = calcularIMC();
                    System.out.printf("Seu IMC é: %.2f\n", imc);
                    break;
                case 2:
                    if (turmas.isEmpty()) {
                        System.out.println("Você ainda não está matriculado em nenhuma turma.");
                    } else {
                        System.out.println("Turmas matriculadas:");
                        for (String turma : turmas) {
                            System.out.println("- " + turma);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Escolha o novo plano:");
                    for (EnumTipoPlano plano : EnumTipoPlano.values()) {
                        System.out.println("- " + plano);
                    }
                    String novoPlanoStr = scanner.nextLine().toUpperCase();
                    try {
                        EnumTipoPlano novoPlano = EnumTipoPlano.valueOf(novoPlanoStr);
                        alterarPlano(novoPlano);
                        System.out.println("Plano alterado com sucesso para: " + novoPlano);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Plano inválido.");
                    }
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    @Override
    public String exibirDetalhes() {
        return "Aluno: " + getNome() + "\n" +
                "CPF: " + getCpf() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "Endereço: " + getEndereco() + "\n" +
                "Data de Nascimento: " + getDataNascimento() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Matrícula: " + matricula + "\n" +
                "Plano Contratado: " + planoContratado + "\n" +
                "Peso: " + peso + " kg\n" +
                "Altura: " + altura + " m\n" +
                "Status de Pagamento: " + statusPagamento + "\n" +
                "Turmas: " + (turmas.isEmpty() ? "Nenhuma turma matriculada" : String.join(", ", turmas));
    }

}