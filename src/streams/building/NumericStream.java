package streams.building;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStream {

  public static void main(String[] args) {
    IntStream.rangeClosed(1,20).forEach(System.out::println);

    LongStream.range(1,20).forEach(System.out::println);
  }
}
