package org.example;
import java.util.List;

public class StreamAPI {
    private List<Integer> numbers;

    public StreamAPI(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public long sum() {
        return numbers.stream().mapToLong(Integer::longValue).sum();
    }

    public double average() {
        return numbers.stream().mapToDouble(Integer::doubleValue)
                        .average()
                        .orElse(0.0);
    }

    public double standardDeviation() {
        double avg = average();
        return Math.sqrt(
                numbers.stream()
                        .mapToDouble(num -> Math.pow(num - avg, 2))
                        .average()
                        .orElse(0.0)
        );
    }

    public List<Integer> doubleElements() {
        return numbers.stream().map(num -> num * 2).toList();
    }

    public List<Integer> filter() {
        return numbers.stream().filter(num -> num % 2 == 0 && num % 3 == 0).toList();
    }
}
