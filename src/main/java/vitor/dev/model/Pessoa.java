package vitor.dev.model;

public class Pessoa extends Model {
    String name;
    int idade;
    int cpf;
    int rg;

    public Pessoa(int id, String name) {
        super(id);
        this.name = name;
    }
}
