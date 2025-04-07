package Aluno;

import java.util.Objects;

public class Aluno {
    // atributos
    public String nome;
    public int anoDeNascimento;
    public double cra;
    public int[] notas;

    // construtor padrão
    // - sem argumentos
    public Aluno() {
        this.notas = new int[3];
    }

    public Aluno(String nome, int anoDeNascimento) {
        this();
        this.nome = nome;
        this.anoDeNascimento = anoDeNascimento;
    }

    public void incrementarCRA() {
        this.cra += 0.5;
    }

    public void setCRA(double cra) {
        this.cra = cra;
    }

    public double getCRA() {
        return this.cra;
    }

    public int getMedia() {
        return (notas[0] + notas[1] + notas[2]) / 3;
    }

    public String getAprovado() {
        if (getMedia() >= 70) {
            return "Aprovado";
        } else {
            return "Reprovado";
        }
    }

    @Override
    public boolean equals(Object o) {
        // Compara se as duas instâncias são iguais
        if (this == o) return true;
        // Verifica se o objeto passado é instância de Aluno
        if (!(o instanceof Aluno aluno)) return false;

        return anoDeNascimento == aluno.anoDeNascimento && Objects.equals(nome, aluno.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoDeNascimento);
    }
}
