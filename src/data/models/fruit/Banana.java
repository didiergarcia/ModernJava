package data.models.fruit;

public class Banana implements Fruit {
  int weight;
  FruitColor color;
  FruitSource source;


  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public void setWeight(int weight) {
    this.weight = weight;
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
  public FruitSource getSource() {
    return source;
  }

  @Override
  public void setSource(FruitSource source) {
    this.source = source;
  }
}
