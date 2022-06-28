package br.com.martinsgms.atividade.numerosrandomicos;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class NumerosRandomicosMain
{
    public static void main(String[] args)
    {
        System.out.println("\n A) Collection com números randomicos \n");

        List<Integer> randomIntegers = new Random().ints().limit(100).boxed().collect(Collectors.toList());
        randomIntegers.forEach(System.out::println);

        System.out.println("\n B) Collection ordenada pela ordem natural \n");

        Set<Integer> randomIntegersCopy = randomIntegers.stream().collect(Collectors.toSet());
        randomIntegersCopy.stream().sorted().forEach(System.out::println);

        System.out.println("\n C) Collection com contagem de duplicatas \n");

        Map<Integer, Integer> duplicatesCount = new HashMap<>();
        randomIntegers.stream().forEach(i -> duplicatesCount.put(i, Collections.frequency(randomIntegers, i)));

        duplicatesCount.forEach((k, v) -> System.out.println(k + " => " + v + "x"));

        System.out.println("\n D) Qualquer número de C \n");

        System.out.println(duplicatesCount.keySet().stream().findFirst().get());
    }
}
