package vitor.dev.model;

public class Model {
	private int id;

	public Model(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		Model other = (Model) obj;
		return id == other.id;
	}
}
