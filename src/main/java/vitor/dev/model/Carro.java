package vitor.dev.model;

public class Carro extends Model {
    String placa;

    public Carro(int id, String placa) {
        super(id);
        this.placa = placa;
    }
}
