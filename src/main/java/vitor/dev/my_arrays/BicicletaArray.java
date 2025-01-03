package vitor.dev.my_arrays;

import vitor.dev.exception.DataStructureException;
import vitor.dev.model.Bicicleta;
import vitor.dev.model.Model;

public class BicicletaArray extends MyArray {
	public BicicletaArray(int size) {
		super(size);
	}

	@Override
	public void insert(Model model) {
		try {
			if (model instanceof Bicicleta)
				super.insert(model);
		} catch (Exception e) {
			throw new DataStructureException("Não foi possível inserir o Model no array: " + e.getMessage());
		}
	}

	@Override
	public boolean remove(Model model) {
		return model instanceof Bicicleta && super.remove(model);
	}

	@Override
	public boolean search(Model model) {
		return model instanceof Bicicleta && super.search(model);
	}

	@Override
	public boolean update(Model model, Model newModel) {
		return model instanceof Bicicleta && super.update(model, newModel);
	}
}
