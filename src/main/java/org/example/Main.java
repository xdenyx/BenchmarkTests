package org.example;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new Random().ints(10000000, 1, 100).boxed().toList();
//        for (Integer item: intList) {
//            System.out.print(item + "  ");
//        }
        StreamAPI streamAPI = new StreamAPI(intList);
        ParallelStream parallelStream = new ParallelStream(intList);

        System.out.println("\nStreamAPI:");
        System.out.println("Сумма: " + streamAPI.sum());
        System.out.println("Середнє значення: " + streamAPI.average());
        System.out.println("Стандартне відхилення: " + streamAPI.standardDeviation());
        System.out.println("Помножені на 2: " + streamAPI.doubleElements().size());
        System.out.println("Відфільтровано: " + streamAPI.filter().size());

        System.out.println("\nParallelStream:");
        System.out.println("Сумма: " + parallelStream.sum());
        System.out.println("Середнє значення: " + parallelStream.average());
        System.out.println("Стандартне відхилення: " + parallelStream.standardDeviation());
        System.out.println("Помножені на 2: " + parallelStream.doubleElements().size());
        System.out.println("Відфільтровано: " + parallelStream.filter().size());
    }
}
