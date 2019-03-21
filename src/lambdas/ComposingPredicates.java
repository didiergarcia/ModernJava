package lambdas;

import data.Repository;
import data.models.fruit.Apple;
import data.models.fruit.FruitColor;
import data.models.fruit.FruitSource;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComposingPredicates {

  public static void main(String[] args) {
    List<Apple> apples = Repository.getInstance().getListOf(Apple.class);

    System.out.println("All Apples:");
    apples.forEach(apple -> System.out.println(apple));

    System.out.println("Just RED apples:");

    Predicate<Apple> redApple = new RedApple();
    List<Apple> redApples = filter(apples, redApple);
    redApples.forEach(apple -> System.out.println(apple));

    System.out.println("Just Heavy apples:");
    Predicate<Apple> heavyApple = apple -> apple.getWeight() >= 120;
    List<Apple> heavyApples = filter(apples, heavyApple);
    heavyApples.forEach(apple -> System.out.println(apple));

    System.out.println("Just Green Heavy apples:");
    Predicate<Apple> greenApple = apple -> apple.getColor() == FruitColor.GREEN;
    Predicate<Apple> greenHeavyApples = greenApple.and(heavyApple.negate());
    List<Apple> greenAndHeavyApples = filter(apples, greenHeavyApples);
    greenAndHeavyApples.forEach(apple -> System.out.println(apple));


  }


  static class RedApple implements Predicate<Apple> {
    @Override
    public boolean test(Apple apple) {
      return apple.getColor() == FruitColor.RED;
    }
  }


  static List<Apple> filter(List<Apple> apples, Predicate<Apple> predicate) {
    List<Apple> selectedApples = new ArrayList<>();

    for (Apple a: apples) {
      if (predicate.test(a)) {
        selectedApples.add(a);
      }
    }

    return selectedApples;
  }
}
