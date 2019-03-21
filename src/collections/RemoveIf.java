package collections;

import java.util.ArrayList;
import java.util.List;

public class RemoveIf {

  public static void main(String[] args) {
    System.out.println("The removeIf (Java 8) method removes an element if it matches a Predicate.");
    List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 3, 4, 4, 6, 6, 7));
    System.out.println("List: " + integerList);

    System.out.println("List removeIf (even number):");
    integerList.removeIf(i -> i % 2 == 0);
    System.out.println("List: " + integerList);
  }
}
