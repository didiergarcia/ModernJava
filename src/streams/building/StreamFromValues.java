package streams.building;

import java.util.stream.Stream;

public class StreamFromValues {

  public static void main(String[] args) {
    Stream.of("I", "use", "be", "better", "at", "creating", "examples")
        .map(String::toUpperCase)
        .forEach(System.out::println);
  }
}
