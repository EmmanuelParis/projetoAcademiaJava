package br.com.catolica.academia.Model;

import br.com.catolica.academia.Contract.IEquipamentoCardioInterface;
import br.com.catolica.academia.Enum.EnumStatusEquipamento;

import java.util.HashMap;

public class EquipamentoCardio extends Equipamento implements IEquipamentoCardioInterface {
    private int duracaoMaximaUso;
    private boolean monitorCardiaco;
    private HashMap<String, String> historicoExercicios;

    public EquipamentoCardio(String nome, String tipo, EnumStatusEquipamento status, String fabricante,
                             String dataCompra, double valorCompra, int duracaoMaximaUso, boolean monitorCardiaco) {
        super(nome, tipo, status, fabricante, dataCompra, valorCompra);
        this.duracaoMaximaUso = duracaoMaximaUso;
        this.monitorCardiaco = monitorCardiaco;
        this.historicoExercicios = new HashMap<>();
    }

    public boolean verificarTempoExcedido(int tempoDeUso) {
        return tempoDeUso > duracaoMaximaUso;
    }

    public void registrarExercicio(String aluno, String data, int tempoDeUso) {
        try {
            if (tempoDeUso > duracaoMaximaUso) {
                throw new IllegalArgumentException("Tempo de uso excede a duração máxima permitida!");
            }
            String detalhes = "Aluno: " + aluno + ", Tempo de Uso: " + tempoDeUso + " minutos.";
            historicoExercicios.put(data, detalhes);
        } catch (Exception e) {
            System.out.println("Erro ao registrar exercício: " + e.getMessage());
        }
    }

    public void listarHistorico() {
        System.out.println("Histórico de exercícios no equipamento de cardio " + getNome() + ":");
        historicoExercicios.forEach((data, detalhes) -> System.out.println("Data: " + data + " | " + detalhes));
    }

    @Override
    public boolean verificarManutencaoNecessaria() {
        try {
            if (duracaoMaximaUso < 30) {
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
        return super.exibirDetalhes() + ", Duração Máxima: " + duracaoMaximaUso + " minutos, Monitor Cardiaco: " + monitorCardiaco;
    }
}
