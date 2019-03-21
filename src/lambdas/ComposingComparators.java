package lambdas;

import data.Repository;
import data.models.JiraProject;

import java.util.Comparator;
import java.util.List;

public class ComposingComparators {


  public static void main(String[] args) {

    List<JiraProject> projects = Repository.getInstance().getListOf(JiraProject.class);

    projects.forEach(jp -> System.out.println(jp.toString()));

    // Sort the list based on Id
    projects.sort(new IdComparator());
    System.out.println("Sorted (new IdComparator()): ");
    projects.forEach(jp -> System.out.println(jp.toString()));

    // Sort the list based on key
    projects.sort(Comparator.comparing(JiraProject::getKey));
    System.out.println("Sorted (comparing(JiraProject::getKey)): ");
    projects.forEach(jp -> System.out.println(jp.toString()));

    // Sort the list based on key Reversed
    projects.sort(Comparator.comparing(JiraProject::getKey).reversed());
    System.out.println("Sorted (comparing(JiraProject::getKey).reversed): ");
    projects.forEach(jp -> System.out.println(jp.toString()));

  }

  // Old School Comparator
  static class IdComparator implements Comparator<JiraProject> {

    @Override
    public int compare(JiraProject o1, JiraProject o2) {
      return Long.compare(o1.getId(), o2.getId());
    }
  }
}
