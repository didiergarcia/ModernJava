package data.models.fruit;

public class Apple implements Fruit{
  FruitColor color;
  int weight; // in grams (g)
  FruitSource source;

  public Apple() {}

  public Apple(FruitColor color, int weight) {
    this.color = color;
    this.weight = weight;
    this.source = FruitSource.Unknown;
  }

  public Apple(FruitColor color, int weight, FruitSource source) {
    this.color = color;
    this.weight = weight;
    this.source = source;
  }

  @Override
  public FruitColor getColor() {
    return color;
  }

  @Override
  public void setColor(FruitColor color) {
    this.color = color;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public FruitSource getSource() {
    return source;
  }

  @Override
  public void setSource(FruitSource source) {
    this.source = source;
  }

  @Override
  public String toString() {
    return "Apple{" +
        "color=" + color +
        ", weight=" + weight +
        ", source=" + source +
        '}';
  }

}
