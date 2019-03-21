package streams;

import java.util.Arrays;

public class StreamWordCounter {

  public static void main(String[] args) {
    String msg = "In this listing, the accumulate method defines how to change the state of the Word- Counter, or, more precisely, with which state to create a new WordCounter because it’s an immutable class. This is important to understand.";


    long count = Arrays.stream(msg.split(" "))
        .parallel()
        .count();
    System.out.println("Word Count: " + count);
  }
}
