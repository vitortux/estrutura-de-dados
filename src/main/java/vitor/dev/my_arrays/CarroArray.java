package vitor.dev.my_arrays;

import vitor.dev.exception.DataStructureException;
import vitor.dev.model.Carro;
import vitor.dev.model.Model;

public class CarroArray extends MyArray {
	public CarroArray(int size) {
		super(size);
	}

	@Override
	public void insert(Model model) {
		try {
			if (model instanceof Carro)
				super.insert(model);
		} catch (Exception e) {
			throw new DataStructureException("Não foi possível inserir o Model no array: " + e.getMessage());
		}
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
