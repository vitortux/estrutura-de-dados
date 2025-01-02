package vitor.dev.my_arrays;

import vitor.dev.model.Carro;
import vitor.dev.model.Model;

public class CarroArray extends MyArray {
	public CarroArray(int size) {
		super(size);
	}

	@Override
	public boolean insert(Model model) {
		return model instanceof Carro && super.insert(model);
	}

	@Override
	public boolean remove(Model model) {
		return model instanceof Carro && super.remove(model);
	}

	@Override
	public boolean search(Model model) {
		return model instanceof Carro && super.search(model);
	}

	@Override
	public boolean update(Model model, Model newModel) {
		return model instanceof Carro && super.update(model, newModel);
	}
}
