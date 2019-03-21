package lambdas;

import data.models.fruit.Apple;
import data.models.fruit.Banana;
import data.models.fruit.Fruit;
import data.models.fruit.Pear;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ObjectCreator {

  static Map<String, Supplier<Fruit>> creatorMap = new HashMap<>();

  public static void main(String[] args) {

    System.out.println("Starting....");


    ObjectCreator oc = new ObjectCreator();

    Fruit apple = oc.getFruit("apple");
    Fruit banana = oc.getFruit("banana");
    Fruit pear = oc.getFruit("pear");

    apple.hi();
    banana.hi();
    pear.hi();
  }

  public ObjectCreator() {
    System.out.println("lambdas.ObjectCreator created");

    creatorMap.put("apple", Apple::new);
    creatorMap.put("pear", Pear::new);
    creatorMap.put("banana", Banana::new);
  }

  // Dynamically get new Fruit Instances
  public Fruit getFruit(String fruit) {
    Supplier<Fruit> fruitSupplier = creatorMap.get(fruit);

    return fruitSupplier.get();
  }


}
