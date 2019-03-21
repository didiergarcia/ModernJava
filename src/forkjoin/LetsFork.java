package forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LetsFork {

  public static void main(String[] args) {
    //java11();

    int[] data = IntStream.rangeClosed(1,200_000_000).map(i -> (i % 2 == 0) ? 0 : i).toArray();
    System.out.println("start");
    Arrays.sort(data);
    // Arrays.stream(data).forEach(System.out::println);
    System.out.println("end");
  }


  private static void java11() {
    System.out.println("Java 11 Features");
    var list = new ArrayList<>(List.of(1, 2, 3));
    System.out.println("list: " + list);
    Object[] array = list.toArray(value -> new Object[value]);
    System.out.println("array: " + Arrays.toString(array));


    Optional a = Optional.of(new Object());
    System.out.println("What is 'a'? ");

    doIt();
  }

  public static void doIt() {
    String msg = Stream.generate(() -> (int) (Math.random() * 100))
        .limit(3000)
        .map(i -> String.valueOf(i))
        .collect(joining(",\n"));

    System.out.println("MSG: \n{" + msg + "}");
  }
}
