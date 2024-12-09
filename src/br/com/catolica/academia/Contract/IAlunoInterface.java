package br.com.catolica.academia.Contract;

import br.com.catolica.academia.Enum.EnumTipoPlano;

public interface IAlunoInterface {

    void exibirMenu();
    void alterarPlano(EnumTipoPlano novoPlano);
    double calcularIMC();
}
