package vitor.dev.model;

public class Person extends Model {
    String name;

    public Person(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
