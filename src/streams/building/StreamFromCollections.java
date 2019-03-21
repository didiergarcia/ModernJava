package streams.building;

import java.util.ArrayList;
import java.util.List;

public class StreamFromCollections {

  public static void main(String[] args) {
    List<Integer> evens = new ArrayList<>();

    evens.add(2);
    evens.add(4);
    evens.add(6);
    evens.add(8);

    evens.stream()
        .map(e -> "Number: " + e)
        .forEach(System.out::println);
  }
}
