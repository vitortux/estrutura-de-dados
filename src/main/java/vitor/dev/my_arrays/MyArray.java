package vitor.dev.my_arrays;

import java.util.Random;

import vitor.dev.model.Model;

public class MyArray {
	private Model[] items;
	private Random random;

	public MyArray(int size) {
		this.items = new Model[size];
		this.random = new Random();
	}

	public Model[] getItems() {
		return items;
	}

	public void insert(int position, Model model) {
		items[position] = model;
	}

	public boolean remove(Model model) {
		for (int i = 0; i < items.length; i++) {
			if (items[i] == model) {
				items[i] = null;
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

	public boolean update(int position, Model model) {
		if (items[position] != null) {
			items[position] = model;
			return true;
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