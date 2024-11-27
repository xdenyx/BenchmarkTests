package org.example;
import org.openjdk.jmh.annotations.*;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 10, time = 2, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 15, time = 2, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 1)
public class BenchTest {
    private StreamAPI streamAPI;
    private ParallelStream parallelStream;

    @Setup
    public void setup() {
        List<Integer> intArray = new Random().ints(10000000, 1, 100).boxed().toList();
        streamAPI = new StreamAPI(intArray);
        parallelStream = new ParallelStream(intArray);
    }

    // StreamAPI
    @Benchmark
    public long benchmarkSumStream() {
        return streamAPI.sum();
    }
    @Benchmark
    public double benchmarkAverageStream() {
        return streamAPI.average();
    }
    @Benchmark
    public double benchmarkStandardDeviationStream() {
        return streamAPI.standardDeviation();
    }
    @Benchmark
    public List<Integer> benchmarkDoubleElementsStream() {
        return streamAPI.doubleElements();
    }
    @Benchmark
    public List<Integer> benchmarkFilterStream() {
        return streamAPI.filter();
    }
    // ParallelStream
    @Benchmark
    public long benchmarkSumParallelStream() {
        return parallelStream.sum();
    }
    @Benchmark
    public double benchmarkAverageParallelStream() {
        return parallelStream.average();
    }
    @Benchmark
    public double benchmarkStandardDeviationParallelStream() {
        return parallelStream.standardDeviation();
    }
    @Benchmark
    public List<Integer> benchmarkDoubleElementsParallelStream() {
        return parallelStream.doubleElements();
    }
    @Benchmark
    public List<Integer> benchmarkFilterParallelStream() {
        return parallelStream.filter();
    }
}
