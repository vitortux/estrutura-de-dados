package vitor.dev.my_arrays;

import vitor.dev.model.Model;
import vitor.dev.model.Pessoa;

public class PessoaArray extends MyArray {
	public PessoaArray(int size) {
		super(size);
	}

	@Override
	public void insert(int position, Model model) {
		if (model instanceof Pessoa) {
			super.insert(position, model);
		}
	}

	@Override
	public boolean remove(Model model) {
		if (model instanceof Pessoa) {
			return super.remove(model);
		}

		return false;
	}

	@Override
	public boolean search(Model model) {
		if (model instanceof Pessoa) {
			return super.search(model);
		}

		return false;
	}

	@Override
	public boolean update(int position, Model model) {
		if (model instanceof Pessoa) {
			return super.update(position, model);
		}

		return false;
	}
}
