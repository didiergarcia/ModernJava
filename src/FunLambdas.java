import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class FunLambdas {

  public static void main(String[] args) {

    List<Integer> list = new ArrayList<>();
    list.add(42);
    list.add(7);
    list.add(73);
    list.add(72);
    list.add(17);
    list.add(3);
    list.add(31);
    list.add(33);
    list.add(24);
    list.add(5);
    list.add(51);
    list.add(25);


    Collections.sort(list, Integer::compareTo);

    list.forEach(System.out::println);

    System.out.println("Filtered ");


    Evens evens = new Evens();
    Big big = new Big();

    filter(list, new Divisible(3).and(big.negate())).forEach(System.out::println);

  }

  static class Divisible implements Predicate<Integer> {
    Integer divisor;

    public Divisible(Integer divisor) {
      this.divisor = divisor;
    }

    @Override
    public boolean test(Integer integer) {
      return integer % divisor == 0;
    }
  }

  static class Evens implements Predicate<Integer>{
    @Override
    public boolean test(Integer integer) {

      return (integer % 2 == 0);
    }
  }

  static class Big implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
      return integer > 25;
    }
  }

  public static List<Integer> filter(List<Integer> list, Predicate<Integer> p) {
    List<Integer> result = new ArrayList<>();

    list.forEach(i-> {
      if (p.test(i)) {
        result.add(i);
      }
    });

    return result;
  }
}
