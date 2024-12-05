package br.com.catolica.academia.Model;

import br.com.catolica.academia.Enum.EnumStatusEquipamento;

public abstract class Equipamento {
    private String nome;
    private String tipo;
    private EnumStatusEquipamento status;
    private String fabricante;
    private String dataCompra;
    private double valorCompra;

    public Equipamento(String nome, String tipo, EnumStatusEquipamento status, String fabricante, String dataCompra, double valorCompra) {
        this.nome = nome;
        this.tipo = tipo;
        this.status = status;
        this.fabricante = fabricante;
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
    }

    public abstract boolean verificarManutencaoNecessaria();

    public String getNome() {
        return nome;
    }

    public EnumStatusEquipamento getStatus() {
        return status;
    }

    public void alterarStatus(EnumStatusEquipamento novoStatus) {
        this.status = novoStatus;
    }

    public double calcularDesgaste(int anosDeUso) {
        double taxaDesgaste = 0.1;
        return valorCompra * Math.pow((1 - taxaDesgaste), anosDeUso);
    }

    public String exibirDetalhes() {
        return nome + " (" + tipo + ") - Status: " + status + ", Fabricante: " + fabricante;
    }

    @Override
    public String toString() {
        return "Equipamento: " + nome + ", Tipo: " + tipo;
    }
}