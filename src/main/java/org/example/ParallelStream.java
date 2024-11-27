package org.example;
import java.util.List;

public class ParallelStream {
    private List<Integer> numbers;

    public ParallelStream(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public long sum() {
        return numbers.parallelStream().mapToLong(Integer::longValue).sum();
    }

    public double average() {
        return numbers.parallelStream().mapToDouble(Integer::doubleValue)
                        .average()
                        .orElse(0.0);
    }

    public double standardDeviation() {
        double avg = average();
        return Math.sqrt(
                numbers.parallelStream()
                        .mapToDouble(num -> Math.pow(num - avg, 2))
                        .average()
                        .orElse(0.0)
        );
    }

    public List<Integer> doubleElements() {
        return numbers.parallelStream().map(num -> num * 2).toList();
    }

    public List<Integer> filter() {
        return numbers.parallelStream().filter(num -> num % 2 == 0 && num % 3 == 0).toList();
    }
}
