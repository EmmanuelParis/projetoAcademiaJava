package br.com.catolica.academia.Contract;

public interface IEquipamentoMusculacaoInterface {

    boolean verificarPesoExcedido(int pesoUtilizado);
    void registrarExercicio(String aluno, String data, int pesoUtilizado, int repeticoes);
    void listarHistorico();
    boolean verificarManutencaoNecessaria();
}
