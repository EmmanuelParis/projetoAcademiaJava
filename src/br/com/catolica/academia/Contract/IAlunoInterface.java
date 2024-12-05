package br.com.catolica.academia.Contract;

import br.com.catolica.academia.Enum.EnumTipoPlano;
import br.com.catolica.academia.Model.Turma;

public interface IAlunoInterface {

    double calcularIMC();
    void matricularNaTurma(Turma turma);
    void alterarPlano(EnumTipoPlano novoPlano);

}
