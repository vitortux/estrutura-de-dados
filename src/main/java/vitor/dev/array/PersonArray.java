package vitor.dev.array;

import vitor.dev.model.Model;
import vitor.dev.model.Person;

public class PersonArray extends MyArray {
	public PersonArray(int size) {
		super(size);
	}

	@Override
	public void insert(int position, Model model) {
		if (model instanceof Person) {
			super.insert(position, model);
		}
	}

	@Override
	public boolean remove(Model model) {
		if (model instanceof Person) {
			return super.remove(model);
		}

		return false;
	}

	@Override
	public boolean search(Model model) {
		if (model instanceof Person) {
			return super.search(model);
		}

		return false;
	}

	@Override
	public boolean update(int position, Model model) {
		if (model instanceof Person) {
			return super.update(position, model);
		}

		return false;
	}
}
