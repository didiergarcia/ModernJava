package streams.collecting;

import data.Repository;
import data.models.Dish;

import java.util.*;

import static java.util.stream.Collectors.*;

public class ReducingAndSummarizing {


  public static void main(String[] args) {
    System.out.println("Reducing and Summarizing Collectors");

    List<Dish> dishes = Repository.getInstance().getListOf(Dish.class);

    Integer totalCalories = dishes.stream().collect(summingInt(Dish::getCalories));
    System.out.println("Total Calories: "  + totalCalories);
    Optional<Dish> highCalDish = dishes.stream().max(Comparator.comparing(Dish::getCalories));
    System.out.println("High call dish: " + highCalDish);

    IntSummaryStatistics intSummaryStatistics = dishes.stream().collect(summarizingInt(Dish::getCalories));
    System.out.println(intSummaryStatistics);

    System.out.println("There are multiple ways to do the same thing: ");
    Optional<String> collectReducingNames = dishes.stream().map(dish -> dish.getName()).collect(reducing((s, s2) -> s + ", " + s2));
    System.out.println("Dish Names(collectReducingNames): " + collectReducingNames.get());

    Optional<String> reduceNames = dishes.stream().map(dish -> dish.getName()).reduce((s, s2) -> s + ", " + s2);
    System.out.println("Dish Names(reduceName): " + reduceNames.get());

    String collectJoiningNames = dishes.stream().map(dish -> dish.getName()).collect(joining(", "));
    System.out.println("Dish Names(collectJoiningNames): " + collectJoiningNames);
  }

}
