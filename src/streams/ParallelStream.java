package streams;

import java.util.stream.IntStream;

public class ParallelStream {


  public static void main(String[] args) {
    parallelWillJoin();
  }

  private static void parallelWillJoin() {
    int sum = IntStream.rangeClosed(1, 10)
        .parallel()
        .map(i -> {
          System.out.println(Thread.currentThread() + " handled value: " + i);
          return i;
        }
    ).sum();
    System.out.println("Sum: " + sum);
  }
}
