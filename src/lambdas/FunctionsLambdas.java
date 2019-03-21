package lambdas;

import data.Repository;
import data.models.fruit.Apple;
import data.models.fruit.FruitColor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FunctionsLambdas {


  static class WeightComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
      return Integer.compare(o1.getWeight(), o2.getWeight());
    }
  }

  public static void main(String[] args) {

    Stringify f = apple -> "apple-" + apple.toString();


    Repository repo = Repository.getInstance();
    List<Apple> apples = filter(repo.getListOf(Apple.class), (Apple a) -> a.getColor() == FruitColor.GREEN);
    System.out.println("Using a Object Wrapper");
    prettyPrintApple(apples, new AppleStringify());

    System.out.println("Using a method reference");
    prettyPrintApple(apples, Apple::toString);

    System.out.println("Using a Typed lambda");
    prettyPrintApple(apples, (Apple apple) -> apple.toString());

    System.out.println("Using a Infered Type lambda");
    prettyPrintApple(apples, (apple) -> apple.toString());

    System.out.println("Using a no parens Infered Type lambda");
    prettyPrintApple(apples, apple -> apple.toString());


    System.out.println("DONE!!!");
    System.out.println("DONE!!!");
    System.out.println("DONE!!!");
    System.out.println("DONE!!!");
    System.out.println(Thread.currentThread().toString());

    new Thread(() -> System.out.println("Hello from a thread " + Thread.currentThread().toString() + " !")).start();
  }


  static <T> List<T> filter(List<T> items, Predicate<T> p) {

    List<T> filteredItems = new ArrayList<>();

    for (T item : items) {
      if (p.test(item)) {
        filteredItems.add(item);
      }
    }

    return filteredItems;
  }

  static void prettyPrintApple(List<Apple> apples, Stringify stringify) {
    for (Apple a : apples) {
      System.out.println(stringify.of(a));
    }
  }

  interface Stringify {
    String of(Apple o);
  }

  static class AppleStringify implements Stringify {

    public String of(Apple o) {
      if (o instanceof Apple) {
        Apple a = (Apple) o;
        return String.format("%s Apple weighing %d grams", a.getColor(), a.getWeight());
      } else {
        return "Not an Apple.";
      }
    }
  }

}
