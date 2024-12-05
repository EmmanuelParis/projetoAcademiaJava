package br.com.catolica.academia.Contract;

public interface IEquipamentoCardioInterface {

    boolean verificarTempoExcedido(int tempoDeUso);
    void registrarExercicio(String aluno, String data, int tempoDeUso);
    void listarHistorico();
    boolean verificarManutencaoNecessaria();

}
