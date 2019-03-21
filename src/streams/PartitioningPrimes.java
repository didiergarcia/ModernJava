package streams;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class PartitioningPrimes {

  public static void main(String[] args) {

    int n = 20; //5_000_000;
    System.out.println("Lets partition the first " + n + " numbers:");

    long start = System.currentTimeMillis();
    Map<Boolean, List<Integer>> partitionPrimes = partitionPrimes(n);
    long end = System.currentTimeMillis();

    System.out.println("Partitioned Primes/NonPrimes " + (end - start) + " ms: ");
    System.out.println(partitionPrimes);
  }

  private static Map<Boolean, List<Integer>> partitionPrimes(int n) {
    return IntStream.rangeClosed(2, n)
        .boxed()
        .collect(partitioningBy(i -> isPrime(i)));
  }

  private static boolean isPrime(int candidate) {
    // Only care up to the square-root of the candidate.
    int root = (int) Math.sqrt((double) candidate);

    // Returns true if candidate is not divisible by any number from 2..sqrt(candidate).
    return IntStream.rangeClosed(2, root).noneMatch(i -> candidate % i == 0);
  }
}
