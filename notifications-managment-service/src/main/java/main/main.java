package main;

import java.util.*;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Ana", 25, Arrays.asList("Ler", "Correr")),
                new Pessoa("Jorge", 25, Arrays.asList("Ler", "Correr")),
                new Pessoa("Jorge22", 25, Arrays.asList("Ler", "Correr")),
                new Pessoa("Bruno", 32, Arrays.asList("Futebol", "Cozinhar")),
                new Pessoa("Carla", 19, Arrays.asList("Viajar", "Desenhar")),
                new Pessoa("David", 40, Arrays.asList("Viajar", "Fotografia"))
        );

        //System.out.println(listFilterByAge(pessoas));
        //listFilterByAgeUnder(pessoas).forEach(System.out::println);
        //orderByAgeASC(pessoas).forEach(System.out::println);
        countPeoopleForHobbieMoreThan20(pessoas);
    }

    public static List<Integer> listFilterByAge(List<Pessoa> list) {
        return list.stream().map(s -> s.getIdade()).toList();
    }

    public static List<Pessoa> listFilterByAgeUnder(List<Pessoa> list) {
        return list.stream().filter(s -> s.getIdade() < 40)
                //.peek(System.out::println)
                .toList();
    }

    public static List<Pessoa> orderByAgeASC(List<Pessoa> list) {
        return list.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .collect(Collectors.toList());
    }

    public static List<Pessoa> orderByAgeDESC(List<Pessoa> list) {
        return list.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade)
                        .reversed())
                .collect(Collectors.toList());
    }

    public static List<Integer> ageSquare(List<Pessoa> list) {
        return list.stream()
                .map(s -> s.getIdade() * s.getIdade()).sorted().toList();
    }

    public static Map<String, List<Pessoa>> groupByAge(List<Pessoa> pessoas) {

        Map<String, List<Pessoa>> agrupados = pessoas.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.getIdade() < 20) return "Jovens";
                    else if (p.getIdade() < 40) return "Adultos";
                    else return "Séniores";
                }));
        return agrupados;
    }

    public static Map<String, List<Pessoa>> groupyHobbie(List<Pessoa> pessoas) {
        Map<String, List<Pessoa>> agrupados = pessoas.stream()
                .collect(Collectors.groupingBy(p -> p.getHobbies().get(0)));
        return agrupados;
    }

    public static Map<Integer, List<Pessoa>> groupByDecade(List<Pessoa> pessoas) {
        return pessoas.stream()
                .collect(Collectors.groupingBy(p ->
                        p.getIdade() / 10
                ));
    }

    public static void useFlat(List<Pessoa> pessoas) {
        List<String> hobbiesUnicos = pessoas.stream()
                .flatMap(p -> p.getHobbies().stream()) // transforma Stream<List<String>> em Stream<String>
                .distinct() // remove duplicados
                .collect(Collectors.toList());

        System.out.println("Hobbies únicos: " + hobbiesUnicos);
    }

    public static void contHobbies(List<Pessoa> pessoas){
        System.out.println( pessoas.stream()
                .filter(p -> p.getIdade() > 25)
                .flatMap(p -> p.getHobbies().stream())
                .distinct()
                .count());
    }


 //  💡 Exercício — Contar pessoas por hobby, só para maiores de 20 anos

 //  Filtrar apenas pessoas com idade > 20.

 //  Usar flatMap para “explodir” todos os hobbies.

 //  Agrupar pelas hobbies usando groupingBy, mas ao invés de armazenar os hobbies, armazenar os nomes das pessoas.


    public static void countPeoopleForHobbieMoreThan20(List<Pessoa> pessoas){

        Map<String, List<String>> pessoasPorHobby = pessoas.stream()
                .filter(p -> p.getIdade() > 20) // apenas maiores de 20
                .flatMap(p -> p.getHobbies().stream()
                        .map(hobby -> Map.entry(hobby, p.getNome()))) // par (hobby, nome)
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,                          // chave = hobby
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList()) // valor = nomes
                ));

        pessoasPorHobby.forEach((hobby, nomes) ->
                System.out.println(hobby + ": " + nomes));
    }
}
