package data;

import data.models.Dish;
import data.models.JiraProject;
import data.models.fruit.Apple;
import data.models.fruit.FruitColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Repository {

  private static volatile Repository instance;
  private static final Object INSTANCE_LOCK = new Object();

  private static final Map<Class, Supplier<List<?>>> REPO = new HashMap<>();

  private Repository() {
    // Register all Suppliers here.
    REPO.put(Apple.class, Repository::makeApples);
    REPO.put(JiraProject.class, Repository::listJiraProjects);
    REPO.put(Dish.class, Repository::listDishes);
  }


  public static Repository getInstance() {
    if (instance == null) {
      synchronized (INSTANCE_LOCK) {
        if (instance == null) {
          instance = new Repository();
        }
      }
    }

    return instance;
  }

  private static List<Apple> makeApples() {
    List<Apple> apples = new ArrayList<>();

    // Red Apples
    apples.add(new Apple(FruitColor.RED, 100));
    apples.add(new Apple(FruitColor.RED, 90));
    apples.add(new Apple(FruitColor.RED, 110));
    apples.add(new Apple(FruitColor.RED, 150));
    apples.add(new Apple(FruitColor.RED, 130));

    // Green Apples
    apples.add(new Apple(FruitColor.GREEN, 100));
    apples.add(new Apple(FruitColor.GREEN, 90));
    apples.add(new Apple(FruitColor.GREEN, 110));
    apples.add(new Apple(FruitColor.GREEN, 150));
    apples.add(new Apple(FruitColor.GREEN, 130));

    return apples;
  }

  private static List<JiraProject> listJiraProjects() {
    List<JiraProject> projects = new ArrayList<>();

    projects.add(new JiraProject(8, "ATT Server Release", "ATTREL", "ATT Server Release Project"));
    projects.add(new JiraProject(7, "SPT Server Release", "SPTREL", "SPT Server Release Project"));
    projects.add(new JiraProject(6, "VZW Server Release", "VZWREL", "VZW Server Release Project"));
    projects.add(new JiraProject(5, "APK Releases", "APKREL", "APK Release Project"));
    projects.add(new JiraProject(4, "ATT Content Pack", "ATTC", "ATT Content Pack Project"));
    projects.add(new JiraProject(3, "SPT Content Pack", "SPTC", "SPT Content Pack Project"));
    projects.add(new JiraProject(2, "VZW Content Pack", "VZWC", "VZW Content Pack Project"));
    projects.add(new JiraProject(1, "WebShell", "WEBS", "APK Project"));

    return projects;
  }

  private static List<Dish> listDishes() {
    List<Dish> dishes = new ArrayList<>();

    dishes.add(new Dish("Chips and Salsa", 900, true, Dish.DishType.OTHER));
    dishes.add(new Dish("Steak Fajita", 1300, false, Dish.DishType.MEAT));
    dishes.add(new Dish("Grilled Salmon", 800, false, Dish.DishType.FISH));
    dishes.add(new Dish("Pork Roast", 1100, false, Dish.DishType.MEAT));
    dishes.add(new Dish("Fried Plantians", 600, true, Dish.DishType.OTHER));

    return dishes;
  }

  public <T> List<T> getListOf(Class<T> clazz) {
    Supplier<?> supplier = REPO.get(clazz);
    List<T> ts = new ArrayList<>();

    if (supplier != null && supplier.get() != null) {
      ts = (List<T>) supplier.get();
    }

    return ts;
  }
}
