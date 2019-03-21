package data.models;

public class Dish {
  String name;
  int calories;
  boolean isVegetarian;
  DishType dishType;

  public Dish(String name, int calories, boolean isVegetarian, DishType dishType) {
    this.name = name;
    this.calories = calories;
    this.isVegetarian = isVegetarian;
    this.dishType = dishType;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCalories() {
    return calories;
  }

  public void setCalories(int calories) {
    this.calories = calories;
  }

  public boolean isVegetarian() {
    return isVegetarian;
  }

  public void setVegetarian(boolean vegetarian) {
    isVegetarian = vegetarian;
  }

  public DishType getDishType() {
    return dishType;
  }

  public void setDishType(DishType dishType) {
    this.dishType = dishType;
  }

  @Override
  public String toString() {
    return "Dish{" +
        "name='" + name + '\'' +
        ", calories=" + calories +
        ", isVegetarian=" + isVegetarian +
        ", dishType=" + dishType +
        '}';
  }

  public enum DishType { FISH, MEAT, OTHER}
}
