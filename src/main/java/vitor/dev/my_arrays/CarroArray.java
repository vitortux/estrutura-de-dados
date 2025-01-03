package vitor.dev.my_arrays;

import vitor.dev.exception.DataStructureException;
import vitor.dev.model.Carro;
import vitor.dev.model.Model;
import vitor.dev.utils.LoggerApi;

public class CarroArray extends MyArray {
	public CarroArray(int size) {
		super(size);
	}

	@Override
	public void insert(Model model) {
		try {
			if (model instanceof Carro) {
				super.insert(model);
				LoggerApi.info(String.format("Model %s inserido no array de carros.", model.toString()));
			}
		} catch (Exception e) {
			LoggerApi.error(String.format("Não foi posível inserir o Model %s no array de bicicletas: %s",
					model.toString(), e.getMessage()));
			throw new DataStructureException("Não foi possível inserir o Model no array: " + e.getMessage());
		}
	}

	@Override
	public boolean remove(Model model) {
		if (model instanceof Carro && super.remove(model)) {
			LoggerApi.info(String.format("Model %s removido do array de carros.", model.toString()));
			return true;
		} else {
			LoggerApi.info(
					String.format("Não foi possível remover Model %s do array de carros: Model não presente no array.",
							model.toString()));
			return false;
		}
	}

	@Override
	public boolean search(Model model) {
		if (model instanceof Carro && super.search(model)) {
			LoggerApi.info(String.format("Model %s está presente no array de carros.", model.toString()));
			return true;
		} else {
			LoggerApi.info(String.format("Model %s NÃO está presente no array de carros.", model.toString()));
			return false;
		}
	}

	@Override
	public boolean update(Model model, Model newModel) {
		if (model instanceof Carro && super.update(model, newModel)) {
			LoggerApi.info(String.format("Model %s foi atualizado com sucesso.", model.toString()));
			return true;
		} else {
			LoggerApi.error(String.format("Model %s não foi atualizado Verifique se o Model está presente no array.",
					model.toString()));
			return false;
		}
	}
}
