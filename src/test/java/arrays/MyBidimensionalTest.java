package arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import vitor.dev.bidimensional.MyBidimensional;
import vitor.dev.exception.DataStructureException;

class MyBidimensionalTest {

    private MyBidimensional myBidimensional = new MyBidimensional(3, 3);

    @Test
    void deveriaInserirLetraNoArrayDeLetras() {
        assertDoesNotThrow(() -> myBidimensional.insertChar(0, 'c'));
        assertEquals('c', myBidimensional.getCharacters()[0]);
    }

    @Test
    void naoDeveriaInserirTipoInvalidoNoArrayDeLetras() {
        assertThrows(DataStructureException.class, () -> myBidimensional.insertChar(0, "c"));
        assertThrows(DataStructureException.class, () -> myBidimensional.insertChar(10, 'c'));
        assertThrows(DataStructureException.class, () -> myBidimensional.insertChar(-1, 'c'));

        assertNotEquals('c', myBidimensional.getCharacters()[0]);
    }

    @Test
    void deveriaInserirLetraNoArrayDeNumeros() {
        assertDoesNotThrow(() -> myBidimensional.insertNumber(0, 10));
        assertEquals(10, myBidimensional.getNumbers()[0]);
    }

    @Test
    void naoDeveriaInserirTipoInvalidoNoArrayDeNumeros() {
        assertThrows(DataStructureException.class, () -> myBidimensional.insertNumber(0, 10f));
        assertThrows(DataStructureException.class, () -> myBidimensional.insertChar(10, 10));
        assertThrows(DataStructureException.class, () -> myBidimensional.insertChar(-1, 10));

        assertNotEquals(10, myBidimensional.getCharacters()[0]);
    }

    @Test
    void deveriaRemoverDoArrayDeLetras() {
        myBidimensional.insertChar(0, 'c');
        assertDoesNotThrow(() -> myBidimensional.removeChar(0));
        assertEquals('\u0000', myBidimensional.getCharacters()[0]);
    }

    @Test
    void deveriaRemoverIndiceNaoPreenchidoDoArrayDeLetras() {
        assertDoesNotThrow(() -> myBidimensional.removeChar(0));
        assertEquals('\u0000', myBidimensional.getCharacters()[0]);
    }

    @Test
    void naoDeveriaRemoverDoArrayDeLetras() {
        myBidimensional.insertChar(0, 'c');
        assertThrows(DataStructureException.class, () -> myBidimensional.insertChar(0, "c"));
        assertThrows(DataStructureException.class, () -> myBidimensional.removeChar(-1));
        assertThrows(DataStructureException.class, () -> myBidimensional.removeChar(10));

        assertEquals('c', myBidimensional.getCharacters()[0]);
    }

    @Test
    void deveriaRemoverDoArrayDeNumeros() {
        myBidimensional.insertNumber(0, 10);
        assertDoesNotThrow(() -> myBidimensional.removeNumber(0));
        assertEquals(0, myBidimensional.getNumbers()[0]);
    }

    @Test
    void deveriaRemoverIndiceNaoPreenchidoDoArrayDeNumeros() {
        assertDoesNotThrow(() -> myBidimensional.removeNumber(0));
        assertEquals(0, myBidimensional.getNumbers()[0]);
    }

    @Test
    void naoDeveriaRemoverDoArrayDeNumeros() {
        myBidimensional.insertNumber(0, 10);
        assertThrows(DataStructureException.class, () -> myBidimensional.insertNumber(0, 10f));
        assertThrows(DataStructureException.class, () -> myBidimensional.removeNumber(-1));
        assertThrows(DataStructureException.class, () -> myBidimensional.removeNumber(10));

        assertEquals(10, myBidimensional.getNumbers()[0]);
    }
}
