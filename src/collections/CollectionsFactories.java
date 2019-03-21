package collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.entry;

public class CollectionsFactories {

  public static void main(String[] args) {
    List<Integer> integerList = List.of(1, 2, 3, 4, 5);
    Set<String> appleSet = Set.of("Apple", "Banana", "Orange");
    Map<String, Double> fruitCostMap = Map.of("Apple", 2.99, "Orange", 3.58, "Tomato", 1.00);
    Map<String, String> nameTypesMaps = Map.ofEntries(entry("cool", "Didier"), entry("uncool", "Scott"));

    System.out.println("Collections Factory Methods (Java 9) make creating simple small list, sets, and maps easier.");
    System.out.println(integerList);
    System.out.println(appleSet);
    System.out.println(fruitCostMap);
    System.out.println(nameTypesMaps);
  }
}
