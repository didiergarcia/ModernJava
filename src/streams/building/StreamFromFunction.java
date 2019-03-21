package streams.building;

import java.time.Clock;
import java.util.stream.Stream;

public class StreamFromFunction {

  public static void main(String[] args) {
    System.out.println("Iterating...");
    Stream.iterate(1, n -> n * 2).limit(10).forEach(System.out::println);

    System.out.println("Generating...");
    Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
  }
}
