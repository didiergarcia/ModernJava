package collections;

import java.util.ArrayList;
import java.util.List;

public class ReplaceAll {

  public static void main(String[] args) {
    System.out.println("The replaceAll method (Java 8) replaces elements in a list using a UnaryOperator.");
    ArrayList<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 5, 6, 6, 7, 9, 22));
    System.out.println("List: " + integerList);

    System.out.println("List replaceAll by i*2: ");
    integerList.replaceAll(i -> i*2);
    System.out.println("List: " + integerList);
  }
}
