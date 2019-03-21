package streams;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriples {

  public static void main(String[] args) {
    int n = 100;
    Stream<int[]> triples = IntStream.rangeClosed(2, n)
        .boxed()
        .flatMap(a ->
            IntStream.rangeClosed(a, n)
                .mapToObj(b -> new int[]{a, b, (a * a) + (b * b)})
                .filter(t -> Math.sqrt(t[2]) % 1 == 0)
                .map(t -> { t[2] = (int) Math.sqrt(t[2]); return t;})
        );

    triples.forEach(t -> System.out.println(Arrays.toString(t)));
  }
}
