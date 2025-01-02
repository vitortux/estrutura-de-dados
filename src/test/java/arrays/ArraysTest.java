package arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ArraysTest {
    private char[] letras;
    private int[] numeros;

    private Object[][] array;

    @BeforeEach
    void setUp() {
        letras = new char[] { 'a', 'b', 'c' };
        numeros = new int[] { 1, 2, 3 };

        array = new Object[1][2];

        array[0][0] = letras;
        array[0][1] = numeros;
    }

    @Test
    void deveriaArmazenarConteudoCorretamenteNoArray2D() {
        assertArrayEquals(letras, (char[]) array[0][0]);
        assertArrayEquals(numeros, (int[]) array[0][1]);
    }

    @Test
    void deveriaRefletirMudançasNosArraysArmazenados() {
        letras[0] = 'z';
        assertEquals('z', ((char[]) array[0][0])[0]);

        numeros[1] = 5;
        assertEquals(5, ((int[]) array[0][1])[1]);
    }

    @Test
    void deveriaAceitarArraysDeTamanhosDiferentes() {
        char[] newLetras = new char[] { 'x', 'y' };
        int[] newNumeros = new int[] { 10, 20, 30, 40 };

        array[0][0] = newLetras;
        array[0][1] = newNumeros;

        assertArrayEquals(newLetras, (char[]) array[0][0]);
        assertArrayEquals(newNumeros, (int[]) array[0][1]);
    }

    @Test
    void deveriaVerificarIgualdadeDeArraysComConteudoIgual() {
        char[] sameLetras = new char[] { 'a', 'b', 'c' };
        int[] sameNumeros = new int[] { 1, 2, 3 };

        array[0][0] = sameLetras;
        array[0][1] = sameNumeros;

        assertNotSame(letras, sameLetras);
        assertNotSame(numeros, sameNumeros);
    }

    @Test
    void deveriaArmazenarTiposDiferentesCorretamente() {
        assertTrue(array[0][0] instanceof char[]);
        assertTrue(array[0][1] instanceof int[]);
    }

    @Test
    void deveriaPermitirAlterarTipoDeArray() {
        array[0][0] = new String[] { "a", "b", "c" };

        assertFalse(array[0][0] instanceof char[]);
        assertNotSame(letras, array[0][0]);
    }

    @Test
    void deveriaPermitirArraysNulos() {
        array[0][0] = null;
        array[0][1] = null;

        assertNull(array[0][0]);
        assertNull(array[0][1]);
    }

    @Test
    void deveriaPermitirArraysNulosDeFormaCorreta() {
        array[0][0] = null;
        assertNull(array[0][0]);
        assertNotNull(array[0][1]);
    }
}
