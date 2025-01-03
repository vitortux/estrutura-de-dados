package vitor.dev.model;

public class Bicicleta extends Model {
	String tipo;
	int marchas;
	boolean temRodinha;

	public Bicicleta(int id, String tipo) {
		super(id);
		this.tipo = tipo;
	}
}
