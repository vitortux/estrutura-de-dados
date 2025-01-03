package vitor.dev.model;

public class Pessoa extends Model {
	String name;
	String rg;
	String cpf;
	int telefone;
	String nacionalidade;

	public Pessoa() {
	}

	public Pessoa(int id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	@Override
	public String toString() {
		return "Pessoa [name=" + name + ", rg=" + rg + ", cpf=" + cpf + ", telefone=" + telefone + ", nacionalidade="
				+ nacionalidade + "]";
	}
}
