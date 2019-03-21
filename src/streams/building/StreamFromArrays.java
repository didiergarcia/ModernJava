package streams.building;

import java.util.Arrays;

public class StreamFromArrays {

  public static void main(String[] args) {
    int[] primes = {1, 2, 3, 5, 7, 11, 13};

    int sum = Arrays.stream(primes).sum();
    System.out.println("sum: " + sum);
  }
}
