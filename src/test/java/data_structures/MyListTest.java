package data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vitor.dev.data_structures.MyList;
import vitor.dev.model.Model;

class MyListTest {

    private MyList<Model> myList;

    @BeforeEach
    void setUp() {
        myList = new MyList<>();

        for (int i = 0; i < 10; i++) {
            myList.add(new Model(i));
        }
    }

    @Test
    void shouldAddElement() {
        Model model = new Model(123);
        myList.add(model);
        assertTrue(myList.contains(model));
    }

    @Test
    void shouldGrowWhenReachingDefaultCapacity() {
        myList.add(new Model(123));
        assertEquals(11, myList.size());
    }

    @Test
    void currentListShouldNotBeEmpty() {
        assertFalse(myList.isEmpty());
    }

    @Test
    void shouldClearList() {
        myList.clear();
        assertEquals(0, myList.size());
        assertTrue(myList.isEmpty());
    }

    @Test
    void shouldRemoveNullObject() {
        myList.add(null);
        assertTrue(myList.remove(null));
    }

    @Test
    void shouldRemoveObject() {
        Model model = new Model(123);
        myList.add(model);
        assertTrue(myList.remove(model));
    }

    @Test
    void shoudNotRemoveObjectNotInList() {
        assertFalse(myList.remove(null));
        assertFalse(myList.remove(new Model(123)));
    }
}
