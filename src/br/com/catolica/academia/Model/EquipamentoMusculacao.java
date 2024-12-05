package br.com.catolica.academia.Model;

import br.com.catolica.academia.Contract.IEquipamentoMusculacaoInterface;
import br.com.catolica.academia.Enum.EnumStatusEquipamento;

import java.util.HashMap;

public class EquipamentoMusculacao extends Equipamento implements IEquipamentoMusculacaoInterface {
    private int pesoMaximoSuportado;
    private boolean ajustavel;
    private HashMap<String, String> historicoExercicios;

    public EquipamentoMusculacao(String nome, String tipo, EnumStatusEquipamento status, String fabricante,
                                 String dataCompra, double valorCompra, int pesoMaximoSuportado, boolean ajustavel) {
        super(nome, tipo, status, fabricante, dataCompra, valorCompra);
        this.pesoMaximoSuportado = pesoMaximoSuportado;
        this.ajustavel = ajustavel;
        this.historicoExercicios = new HashMap<>();
    }

    public boolean verificarPesoExcedido(int pesoUtilizado) {
        return pesoUtilizado > pesoMaximoSuportado;
    }

    public void registrarExercicio(String aluno, String data, int pesoUtilizado, int repeticoes) {
        try {
            if (pesoUtilizado > pesoMaximoSuportado) {
                throw new IllegalArgumentException("Peso utilizado excede o limite suportado!");
            }
            String detalhes = "Aluno: " + aluno + ", Peso: " + pesoUtilizado + " kg, Repetições: " + repeticoes + ".";
            historicoExercicios.put(data, detalhes);
        } catch (Exception e) {
            System.out.println("Erro ao registrar exercício: " + e.getMessage());
        }
    }

    public void listarHistorico() {
        System.out.println("Histórico de exercícios no equipamento de musculação " + getNome() + ":");
        historicoExercicios.forEach((data, detalhes) -> System.out.println("Data: " + data + " | " + detalhes));
    }

    @Override
    public boolean verificarManutencaoNecessaria() {
        try {
            if (pesoMaximoSuportado < 100) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Erro ao verificar manutenção: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return super.exibirDetalhes() + ", Peso Máximo: " + pesoMaximoSuportado + " kg, Ajustável: " + ajustavel;
    }
}
