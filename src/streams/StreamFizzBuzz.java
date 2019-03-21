package streams;

import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class StreamFizzBuzz {


  public static void main(String[] args) {
    IntStream.rangeClosed(1, 100).forEach(val -> {
      if (val % 15 == 0) {
        System.out.println("FIZZBUZZ");
      } else if (val % 3 == 0) {
        System.out.println("FIZZ");
      } else if (val % 5 == 0) {
        System.out.println("BUZZ");
      } else {
        System.out.println(val);
      }
    });
  }
}
