package vitor.dev.model;

public class Carro extends Model {
    String placa;
    String chassi;
    String transmissao;

    public Carro(int id, String placa) {
        super(id);
        this.placa = placa;
    }
}
