package streams;

import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamsVsIteration {


  public static void main(String[] args) {
    System.out.println("StreamsVsIteration test running...");

    // In loop variables.
    long start, end, sum, diff;

    // aggregate time for each sum type.
    long aggSum = 0;
    long aggStreamSum = 0;
    long aggStreamParallelSum = 0;

    // Used to convert nanoTime to millis
    int base = 100000;
    // Number of iterations to loop through. Allows for hotspot-ing.
    int iterations = 10;
    // Number of iterations to skip for timing purposes
    int skipIterations = 1;
    // The number we're summing up-to.
    long n = 10_000_000;

    for (int i = 1; i <= iterations; i++) {
      System.out.println("******************* Iteration " + i + " **************************");
      start = System.nanoTime();

      sum = sum(n);
      end = System.nanoTime();
      diff = (end - start);
      if (i > skipIterations) {
        aggSum += diff;
      }
      System.out.println("sum() = " + sum + " time: " + (diff / base) + "." + (diff % base) + " ms");

      start = System.nanoTime();
      sum = streamSum(n);
      end = System.nanoTime();
      diff = (end - start);
      if (i > skipIterations) {
        aggStreamSum += diff;
      }
      System.out.println("streamSum() = " + sum + " time: " + (diff / base) + "." + (diff % base) + " ms");

      start = System.nanoTime();
      sum = streamParallelSum(n);
      end = System.nanoTime();
      diff = (end - start);
      if (i > skipIterations) {
        aggStreamParallelSum += diff;
      }
      System.out.println("streamParallelSum() = " + sum + " time: " + (diff / base) + "." + (diff % base) + " ms");
    }

    long avgSum = aggSum / (iterations - skipIterations);
    long avgStreamSum = aggStreamSum / (iterations - skipIterations);
    long avgStreamParallelSum = aggStreamParallelSum / (iterations - skipIterations);
    System.out.println("******************* Avg Sum Times **************************");
    System.out.println("Iterations: " + iterations);
    System.out.println("Iterations used for calculation: " + (iterations-skipIterations));
    System.out.println("sum(): " + (avgSum/base) + "." + (avgSum%base) + " ms");
    System.out.println("streamSum(): " + (avgStreamSum/base) + "." + (avgStreamSum%base) + " ms");
    System.out.println("streamParallelSum(): " + (avgStreamParallelSum/base) + "." + (avgStreamParallelSum%base) + " ms");
  }


  private static long streamSum(long n) {
    return LongStream.rangeClosed(1, n)
        .sum();
  }

  private static long streamParallelSum(long n) {
    return LongStream.rangeClosed(1, n)
        .parallel()
        .sum();
  }

  private static long sum(long n) {
    long sum = 0;

    for (long i = 1; i <= n; i++) {
      sum += i;
    }

    return sum;
  }
}
