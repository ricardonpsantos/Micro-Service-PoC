package main;

import java.util.List;
import java.util.Objects;

public class Pessoa {

    private String nome;
    private int idade;
    private List<String> hobbies;

    public Pessoa(String nome, int idade, List<String> hobbies) {
        this.nome = nome;
        this.idade = idade;
        this.hobbies = hobbies;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", hobbies=" + hobbies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idade == pessoa.idade && Objects.equals(nome, pessoa.nome) && Objects.equals(hobbies, pessoa.hobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade, hobbies);
    }
}
