package streams.collecting;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collectors.partitioningBy;

public class CustomCollector {


  public static void main(String[] args) {

    int n = 5_000_000;
    long start = System.currentTimeMillis();
    Map<Boolean, List<Integer>> partitionedPrimes = IntStream.rangeClosed(2, n).boxed()
        .collect(new PrimeNumberCollector());
    long end = System.currentTimeMillis();
    System.out.println("Partitioned Primes/NonPrimes " + (end - start) + " ms: ");
    //System.out.println(partitionedPrimes);

  }

  private static boolean isPrime(List<Integer> primes, int candidate) {
    int root = (int) Math.sqrt((double) candidate);

    return primes.stream()
        .takeWhile(i -> i <= root)
        .noneMatch(i -> candidate % i == 0);
  }


  static class PrimeNumberCollector
      implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
      return () -> new HashMap<Boolean, List<Integer>>() {{
        put(true, new ArrayList<>());
        put(false, new ArrayList<>());
      }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
      return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
        acc.get(isPrime(acc.get(true), candidate)).add(candidate);
      };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {

      // This algorithm can't actually be used in parallel so we throw and error.

      //throw new UnsupportedOperationException("Can't parallel prime partitioning.");

      // This is how you would implement joining to maps:

      return (Map<Boolean, List<Integer>> map1,
              Map<Boolean, List<Integer>> map2) -> {

        map1.get(true).addAll(map2.get(true));
        map1.get(false).addAll(map2.get(false));
        return map1;
      };

    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
      return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
      return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH));
    }
  }
}
