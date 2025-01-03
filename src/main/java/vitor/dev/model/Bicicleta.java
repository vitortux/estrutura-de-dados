package vitor.dev.model;

public class Bicicleta extends Model {
	String marca;
	int numeroMarchas;
	boolean temRodinha;
	String cor;

	public Bicicleta() {
	}

	public Bicicleta(int id, String marca) {
		super(id);
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getNumeroMarchas() {
		return numeroMarchas;
	}

	public void setNumeroMarchas(int numeroMarchas) {
		this.numeroMarchas = numeroMarchas;
	}

	public boolean isTemRodinha() {
		return temRodinha;
	}

	public void setTemRodinha(boolean temRodinha) {
		this.temRodinha = temRodinha;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public String toString() {
		return "Bicicleta [marca=" + marca + ", numeroMarchas=" + numeroMarchas + ", temRodinha=" + temRodinha
				+ ", cor=" + cor + "]";
	}
}
