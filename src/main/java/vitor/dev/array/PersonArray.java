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
}
