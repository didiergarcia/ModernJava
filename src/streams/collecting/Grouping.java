package streams.collecting;

import data.Repository;
import data.models.Dish;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Grouping {

  public static void main(String[] args) {
    Repository repo = Repository.getInstance();

    List<Dish> dishes = repo.getListOf(Dish.class);
    System.out.println("Dishes: ");
    dishes.forEach(System.out::println);

    System.out.println("\n");

    Map<Dish.DishType, List<Dish>> dishesByType = dishes.stream().collect(groupingBy(Dish::getDishType));
    System.out.println("Dishes by type: " + dishesByType);

    System.out.println("\n");
    Map<String, List<Dish>> dishesManuallyGrouping = dishes.stream().collect(groupingBy(dish -> {
      if (dish.getCalories() < 1000) {
        return "diet";
      } else {
        return "normal";
      }
    }));
    System.out.println("Dishes manually grouped: " + dishesManuallyGrouping);


    System.out.println("\n");
    System.out.println("Multiple levels of Grouping");
    Map<Dish.DishType, Map<Boolean, List<Dish>>> multipleGrouping = dishes.stream().collect(groupingBy(Dish::getDishType, groupingBy(Dish::isVegetarian)));
    System.out.println(multipleGrouping);

    System.out.println("Grouping and counting");
    Map<Dish.DishType, Long> groupingAndCounting = dishes.stream().collect(groupingBy(Dish::getDishType, counting()));
    System.out.println(groupingAndCounting);

  }
}
