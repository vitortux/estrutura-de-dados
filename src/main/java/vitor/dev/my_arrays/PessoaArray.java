package vitor.dev.my_arrays;

import vitor.dev.model.Model;
import vitor.dev.model.Pessoa;

public class PessoaArray extends MyArray {
	public PessoaArray(int size) {
		super(size);
	}

	@Override
	public boolean insert(Model model) {
		return model instanceof Pessoa && super.insert(model);
	}

	@Override
	public boolean remove(Model model) {
		return model instanceof Pessoa && super.remove(model);
	}

	@Override
	public boolean search(Model model) {
		return model instanceof Pessoa && super.search(model);
	}

	@Override
	public boolean update(Model model, Model newModel) {
		return model instanceof Pessoa && super.update(model, newModel);
	}
}
