package br.com.catolica.academia.Contract;

public interface IRecepcionistaInterface {

    void registrarAtendimento(String cpfCliente, String descricao);
    void listarAtendimentos();
    void alterarTurno(String novoTurno);

}
