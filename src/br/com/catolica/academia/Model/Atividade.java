package br.com.catolica.academia.Model;

import br.com.catolica.academia.Enum.EnumIntensidade;
import br.com.catolica.academia.Enum.EnumNivel;

public abstract class Atividade {
    private String nome;
    private String descricao;
    private int duracao;
    private EnumIntensidade intensidade;
    private EnumNivel nivel;
    private String instrutor;

    public Atividade(String nome, String descricao, int duracao, EnumIntensidade intensidade, EnumNivel nivel, String instrutor) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.intensidade = intensidade;
        this.nivel = nivel;
        this.instrutor = instrutor;
    }

    public abstract int calcularCalorias();

    public String getNome() {
        return nome;
    }

    public void alterarInstrutor(String novoInstrutor) {
        this.instrutor = novoInstrutor;
    }

    public String getDescricaoCompleta() {
        return descricao + " (" + intensidade + " - " + nivel + ")";
    }

    public boolean verificarDuracaoMinima(int minima) {
        return duracao >= minima;
    }

    public EnumIntensidade getIntensidade() {
        return intensidade;
    }

    public EnumNivel getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "Atividade: " + nome + ", Instrutor: " + instrutor + ", Intensidade: " + intensidade + ", Nível: " + nivel;
    }
}