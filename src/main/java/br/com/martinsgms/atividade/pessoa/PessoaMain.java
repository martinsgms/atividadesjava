package br.com.martinsgms.atividade.pessoa;

import java.util.Comparator;
import java.util.List;

public class PessoaMain
{
    public static void main(String[] args)
    {
        List<Pessoa> pessoas = List.of(new Pessoa("Maria", 31),
            new Pessoa("Maria", 23),
            new Pessoa("João", 40),
            new Pessoa("Francisco", 40),
            new Pessoa("Manuela", 15),
            new Pessoa("João", 20));

        System.out.println("\n A) Ordenando por nome e idade");
        pessoas.stream().sorted(Comparator.comparing(Pessoa::getName).thenComparing(Pessoa::getAge)).forEach(System.out::println);

        System.out.println("\n B) Ordenando por idade");
        pessoas.stream().sorted(Comparator.comparing(Pessoa::getAge)).forEach(System.out::println);
    }
}
