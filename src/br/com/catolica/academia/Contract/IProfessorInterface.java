package br.com.catolica.academia.Contract;

import br.com.catolica.academia.Model.Turma;

public interface IProfessorInterface {

    Turma criarTurma(String nomeDaTurma);
    void listarTurma();

}
