package data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

    @Test
    void shouldSetNewValueForIndex() {
        Model newModel = new Model(123);
        Model oldModel = (Model) myList.set(0, newModel);
        assertNotEquals(myList.get(0), oldModel);
    }

    @Test
    void shouldReturnTrueWhenAllElementsArePresent() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(1));
        collection.add(new Model(2));

        assertTrue(myList.containsAll(collection));
    }

    @Test
    void shouldReturnFalseWhenNotAllElementsArePresent() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(1));
        collection.add(new Model(22));

        assertFalse(myList.containsAll(collection));
    }

    @Test
    void shouldAddAllElementsToMyList() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(12));
        collection.add(new Model(22));
        collection.add(new Model(23));

        assertTrue(myList.addAll(collection));
        assertTrue(myList.containsAll(collection));
        assertEquals(13, myList.size());
    }

    @Test
    void shouldAddDuplicateElements() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(1));
        collection.add(new Model(22));

        assertTrue(myList.addAll(collection));
        assertEquals(13, myList.size());
    }

    @Test
    void testRemoveAllSomeItems() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(1));
        collection.add(new Model(3));

        assertTrue(myList.removeAll(collection));
        assertEquals(8, myList.size());
    }

    @Test
    void testRemoveAllNoItemsToRemove() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(100));

        assertFalse(myList.removeAll(collection));
        assertEquals(10, myList.size());
    }

    @Test
    void testSubListValidRange() {
        MyList<Model> subList = myList.subList(2, 5);
        assertTrue(myList.containsAll(subList));
    }
}
