package data.models.fruit;

// Test Interface and Classes
public interface Fruit {

  default void hi() {
    System.out.println("I'm a " + getClass().getSimpleName());
  }

  default String getName() { return getClass().getSimpleName(); }

  // Weight in grams.
  int getWeight();

  // Set Weight in grams
  void setWeight(int grams);

  FruitColor getColor();

  void setColor(FruitColor color);

  FruitSource getSource();

  void setSource(FruitSource source);
}
