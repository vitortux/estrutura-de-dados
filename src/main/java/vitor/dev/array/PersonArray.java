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
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean remove(Model model) {
        if (model instanceof Person) {
            return super.remove(model);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean search(Model model) {
        if (model instanceof Person) {
            return super.search(model);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean update(int position, Model model) {
        if (model instanceof Person) {
            return super.update(position, model);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
