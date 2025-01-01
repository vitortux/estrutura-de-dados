package vitor.dev.my_arrays;

import vitor.dev.model.Carro;
import vitor.dev.model.Model;

public class CarroArray extends MyArray {
	public CarroArray(int size) {
		super(size);
	}

	@Override
	public void insert(int position, Model model) {
		if (model instanceof Carro) {
			super.insert(position, model);
		}
	}

	@Override
	public boolean remove(Model model) {
		if (model instanceof Carro) {
			return super.remove(model);
		}

		return false;
	}

	@Override
	public boolean search(Model model) {
		if (model instanceof Carro) {
			return super.search(model);
		}

		return false;
	}

	@Override
	public boolean update(int position, Model model) {
		if (model instanceof Carro) {
			return super.update(position, model);
		}

		return false;
	}
}
