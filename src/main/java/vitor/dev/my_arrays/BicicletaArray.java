package vitor.dev.my_arrays;

import vitor.dev.model.Bicicleta;
import vitor.dev.model.Model;

public class BicicletaArray extends MyArray {
    public BicicletaArray(int size) {
        super(size);
    }

    @Override
    public void insert(int position, Model model) {
        if (model instanceof Bicicleta) {
            super.insert(position, model);
        }
    }

    @Override
    public boolean remove(Model model) {
        if (model instanceof Bicicleta) {
            return super.remove(model);
        }

        return false;
    }

    @Override
    public boolean search(Model model) {
        if (model instanceof Bicicleta) {
            return super.search(model);
        }

        return false;
    }

    @Override
    public boolean update(int position, Model model) {
        if (model instanceof Bicicleta) {
            return super.update(position, model);
        }

        return false;
    }
}
