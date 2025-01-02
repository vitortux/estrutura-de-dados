package vitor.dev.my_arrays;

import java.util.Random;

import vitor.dev.model.Model;

public class MyArray {
	private Random random;
	private Model[] items;
	private int size;

	public MyArray(int size) {
		this.random = new Random();
		this.items = new Model[size];
		this.size = 0;
	}

	public Model[] getItems() {
		return items;
	}

	public boolean insert(Model model) {
		if (size < items.length) {
			items[size] = model;
			size++;
			return true;
		}

		return false;
	}

	public boolean remove(Model model) {
		for (int i = 0; i < size; i++) {
			if (items[i] != null && items[i].equals(model)) {
				for (int j = i; j < size - 1; j++) {
					items[j] = items[j + 1];
				}
				items[size - 1] = null;
				size--;
				return true;
			}
		}
		return false;
	}

	public boolean search(Model model) {
		for (Model item : items) {
			if (item == model) {
				return true;
			}
		}

		return false;
	}

	public void orderByIdAsc() {
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (items[j].getId() > items[j + 1].getId()) {
					Model temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}
	}

	public void orderByIdDesc() {
		for (int i = 0; i < items.length - 1; i++) {
			for (int j = 0; j < items.length - i - 1; j++) {
				if (items[j].getId() < items[j + 1].getId()) {
					Model temp = items[j];
					items[j] = items[j + 1];
					items[j + 1] = temp;
				}
			}
		}
	}

	public boolean update(Model model, Model newModel) {
		for (int i = 0; i < size; i++) {
			if (items[i] != null && items[i].equals(model)) {
				items[i] = newModel;
				return true;
			}
		}

		return false;
	}

	public void shuffle() {
		for (int i = items.length - 1; i > 0; i--) {
			int randomIndexToSwap = random.nextInt(i + 1);
			Model temp = items[randomIndexToSwap];
			items[randomIndexToSwap] = items[i];
			items[i] = temp;
		}
	}
}
