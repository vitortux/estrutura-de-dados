package vitor.dev.model;

import java.util.Objects;

public class Model {
	private int id;

	public Model() {
	}

	public Model(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Model other = (Model) obj;
		return id == other.id;
	}
}
