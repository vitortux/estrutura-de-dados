package data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
        assertEquals(12, myList.size());
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
    void shouldGenerateSubListValidRange() {
        MyList<Model> subList = myList.subList(2, 5);
        assertTrue(myList.containsAll(subList));
    }

    @Test
    void shouldAddAtIndex() {
        Model newModel = new Model(100);
        myList.add(5, newModel);

        assertEquals(11, myList.size());

        assertEquals(newModel, myList.get(5));

        assertEquals(new Model(5), myList.get(6));
    }

    @Test
    void shouldInsertAtIndexOnEmptyList() {
        myList.clear();
        Model newModel = new Model(100);
        myList.add(5, newModel);

        assertNull(myList.get(4));
        assertEquals(1, myList.size());
        assertEquals(newModel, myList.get(5));
    }

    @Test
    void shouldConvertToArrayCorrectly() {
        Object[] array = myList.toArray();

        assertEquals(myList.size(), array.length);

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(myList.get(i), array[i]);
        }
    }

    @Test
    void shouldAddCollectionOnEmptyList() {
        MyList<Model> toAdd = new MyList<>();
        toAdd.add(new Model(100));
        toAdd.add(new Model(101));

        myList.clear();

        boolean result = myList.addAll(5, toAdd);

        assertTrue(result);
        assertEquals(2, myList.size());
    }

    @Test
    void shouldAddElementsAtMiddle() {
        MyList<Model> toAdd = new MyList<>();
        toAdd.add(new Model(100));
        toAdd.add(new Model(101));

        boolean result = myList.addAll(5, toAdd);

        assertTrue(result);
        assertEquals(12, myList.size());
    }

    @Test
    void shouldReturnFalseWhenAddingEmptyList() {
        MyList<Model> emptyList = new MyList<>();

        boolean result = myList.addAll(3, emptyList);

        assertFalse(result);
        assertEquals(10, myList.size());
    }

    @Test
    void shouldReturnFalseWhenAddingNullList() {
        boolean result = myList.addAll(3, null);

        assertFalse(result);
        assertEquals(10, myList.size());
    }

    @Test
    void shouldReturnIndexOfNullElementPresent() {
        myList.add(null);

        int index = myList.indexOf(null);
        assertEquals(10, index);
    }

    @Test
    void shouldReturnIndexOfNullElementAbsent() {
        int index = myList.indexOf(null);
        assertEquals(-1, index);
    }

    @Test
    void shouldRetainAllIntersectionNonEmpty() {
        MyList<Model> toRetain = new MyList<>();
        toRetain.add(new Model(1));
        toRetain.add(new Model(3));
        toRetain.add(new Model(5));

        assertTrue(myList.retainAll(toRetain));
        assertEquals(3, myList.size());
    }

    @Test
    void shouldRetainAllEmptyList() {
        MyList<Model> emptyList = new MyList<>();

        assertTrue(myList.retainAll(emptyList));
        assertEquals(0, myList.size());
    }

    @Test
    void shouldReturnLastIndexOfElementPresentMultipleTimes() {
        Model modelToFind = new Model(2);
        myList.add(modelToFind);
        assertEquals(10, myList.lastIndexOf(modelToFind));
        assertEquals(2, myList.indexOf(modelToFind));
    }

    @Test
    void shouldReturnMinusOneForLastIndexOnNotPresentElement() {
        assertEquals(-1, myList.lastIndexOf(null));
    }

    @Test
    void testLastIndexOfNull() {
        myList.add(null);
        assertEquals(10, myList.lastIndexOf(null));
    }

    @Test
    void shoulReturnMinusOneForLastIndexOnEmptyList() {
        myList.clear();
        assertEquals(-1, myList.lastIndexOf(new Model(1)));
    }

    @Test
    void shouldReturnMinusOneForNotPresentElement() {
        assertEquals(-1, myList.lastIndexOf(new Model(100)));
    }
}
