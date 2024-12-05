package br.com.catolica.academia.Model;

import java.util.HashMap;

public class Recepcionista extends Pessoa {
    private String turno;
    private double salario;
    private HashMap<String, String> registrosAtendimento;

    public Recepcionista(String nome, String cpf, String telefone, String endereco, String dataNascimento, String email,
                         String turno, double salario) {
        super(nome, cpf, telefone, endereco, dataNascimento, email);
        this.turno = turno;
        this.salario = salario;
        this.registrosAtendimento = new HashMap<>();
    }

    public void registrarAtendimento(String cpfCliente, String descricao) {
        registrosAtendimento.put(cpfCliente, descricao);
    }

    public void listarAtendimentos() {
        System.out.println("Atendimentos realizados:");
        registrosAtendimento.forEach((cpf, descricao) -> System.out.println("CPF: " + cpf + " - " + descricao));
    }

    public void alterarTurno(String novoTurno) {
        this.turno = novoTurno;
    }

    @Override
    public String exibirDetalhes() {
        return "Recepcionista: " + getNome() + ", Turno: " + turno + ", Salário: " + salario;
    }
}
