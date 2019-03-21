package data.models;

// Class that describes a JIRA project
public class JiraProject {
  long id;
  String name;
  String key;
  String description;

  public JiraProject() {
  }

  public JiraProject(long id, String name, String key, String description) {
    this.id = id;
    this.name = name;
    this.key = key;
    this.description = description;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format("[%s(%d) - %s - %s]", key, id, name, description);
  }
}

