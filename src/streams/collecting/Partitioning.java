package streams.collecting;

import data.Repository;
import data.models.Dish;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
/**
 * Partitioning is a special-case of Grouping. What ever you can do with partitioning
 * you CAN do with grouping, but the benefit is that partitioning produces an specialized
 * more efficient MAP implementation that is FASTER.
 */
public class Partitioning {

  public static void main(String[] args) {
    Repository repo = Repository.getInstance();
    List<Dish> dishes = repo.getListOf(Dish.class);

    System.out.println("Let's partition into vegetarian and non-vegetarian dishes:");
    Map<Boolean, List<Dish>> vegetarianPartitionedDishes = dishes.stream().collect(partitioningBy(Dish::isVegetarian));
    System.out.println(vegetarianPartitionedDishes);
  }
}
