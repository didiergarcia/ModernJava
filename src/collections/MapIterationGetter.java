package collections;

import java.util.HashMap;
import java.util.Map;

public class MapIterationGetter {

  public static void main(String[] args) {
    Map<String, Integer> fruitCountMap = Map.of("apple", 12, "banana", 23, "pear", 5);

    System.out.println("Maps now (Java 8) have a \"forEach\" that makes iteraction easier:");
    fruitCountMap.forEach((k, v) -> System.out.println("There are " + v + " " + k + "s"));

    System.out.println("Maps can now (Java 8) have a default to the get() method to avoid nulls.");
    Integer coconutCount = fruitCountMap.getOrDefault("coconut", 0);
    System.out.println("There are " + coconutCount + " coconuts.");

    System.out.println("Maps can now (Java 8) compute values on the fly if the key is present or missing");
    HashMap<String, String> userInfo = new HashMap<>(Map.of("fName", "Didier", "lName", "Garcia"));
    System.out.println("User Info: " + userInfo);
    System.out.println("Set salary to negative number");

    System.out.println("User Info: " + userInfo);
    String firstName = userInfo.compute("fName", (key, value) -> value.toUpperCase());
    System.out.println("computed first name: " + firstName);

    System.out.println("Create a key with a default value if the key is missing:");
    userInfo.computeIfAbsent("mName",  s -> "<missing>");
    System.out.println("User Info: " + userInfo);

    System.out.println("Change the value if the key if present:");
    userInfo.computeIfPresent("mName",(s, s2) -> "hi");
    System.out.println("User Info: " + userInfo);

  }
}
