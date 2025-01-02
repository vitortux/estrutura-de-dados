package data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vitor.dev.data_structures.MySet;

class MySetTest {

    private MySet<Integer> mySet;

    @BeforeEach
    void setUp() {
        mySet = new MySet<>();

        for (int i = 0; i < 10; i++) {
            mySet.add(i);
        }
    }

    @Test
    void deveriaCrescerAoAlcançarCapacidadeDefault() {
        mySet.add(11);
        assertEquals(11, mySet.size());
    }

    @Test
    void naoDeveriaCrescerAoAlcancarCapacidadeDefault() {
        mySet.add(1);
        assertEquals(10, mySet.size());
    }

    @Test
    void listaAtualNaoDeveriaEstarVazia() {
        assertFalse(mySet.isEmpty());
    }

    @Test
    void deveriaLimparLista() {
        mySet.clear();
        assertEquals(0, mySet.size());
        assertTrue(mySet.isEmpty());
    }

    @Test
    void deveriaRemoverObjeto() {
        assertTrue(mySet.remove(6));

        mySet.add(11);
        assertTrue(mySet.remove(11));
    }

    @Test
    void naoDeveriaRemoverEmConjuntoVazio() {
        mySet.clear();
        assertFalse(mySet.remove(1));
    }

    @Test
    void deveriaRetornarVerdadeiroQuandoTodosElementosEstiveremPresentes() {
        MySet<Integer> collection = new MySet<>();
        collection.add(1);
        collection.add(2);

        assertTrue(mySet.containsAll(collection));
    }

    @Test
    void deveriaRetornarFalsoQuandoNemTodosElementosEstiveremPresentes() {
        MySet<Integer> collection = new MySet<>();
        collection.add(11);
        collection.add(22);

        assertFalse(mySet.containsAll(collection));
    }

    @Test
    void deveriaAdicionarTodosElementosAoMeuConjunto() {
        MySet<Integer> collection = new MySet<>();
        collection.add(12);
        collection.add(22);
        collection.add(23);

        assertTrue(mySet.addAll(collection));
        assertTrue(mySet.containsAll(collection));
        assertEquals(13, mySet.size());
    }

    @Test
    void naoDeveriaAdicionarElementosDuplicadosAoMeuConjunto() {
        MySet<Integer> collection = new MySet<>();
        collection.add(1);
        collection.add(22);
        collection.add(23);

        assertTrue(mySet.addAll(collection));
        assertTrue(mySet.containsAll(collection));
        assertEquals(12, mySet.size());
    }

    @Test
    void deveriaRemoverTodosItensPresentesNaLista() {
        MySet<Integer> collection = new MySet<>();
        collection.add(1);
        collection.add(3);

        assertTrue(mySet.removeAll(collection));
        assertEquals(8, mySet.size());
    }

    @Test
    void naoDeveriaRemoverItensNaoPresentesNaLista() {
        MySet<Integer> collection = new MySet<>();
        collection.add(100);

        assertFalse(mySet.removeAll(collection));
        assertEquals(10, mySet.size());
    }

    @Test
    void deveriaReterTodaInterseccaoNaoVazia() {
        MySet<Integer> toRetain = new MySet<>();
        toRetain.add(1);
        toRetain.add(3);
        toRetain.add(5);

        assertTrue(mySet.retainAll(toRetain));
        assertEquals(3, mySet.size());
    }

    @Test
    void deveriaReterTodoConjuntoVazio() {
        MySet<Integer> emptySet = new MySet<>();

        assertTrue(mySet.retainAll(emptySet));
        assertEquals(0, mySet.size());
    }

    @Test
    void deveriaConverterParaArrayCorretamente() {
        Object[] array = mySet.toArray();

        assertEquals(mySet.size(), array.length);

        for (int i = 0; i < mySet.size(); i++) {
            assertEquals(i, array[i]);
        }
    }

    @Test
    void deveriaConverterParaArrayCorretamenteComTamanhoInsuficiente() {
        Object[] array = new Object[2];
        array = mySet.toArray(array);

        assertEquals(mySet.size(), array.length);

        for (int i = 0; i < mySet.size(); i++) {
            assertEquals(i, array[i]);
        }
    }

    @Test
    void deveriaConverterParaArrayCorretamenteComTamanhoMaiorQueSuficiente() {
        Object[] array = new Object[20];
        array = mySet.toArray(array);

        assertEquals(20, array.length);

        for (int i = 0; i < mySet.size(); i++) {
            assertEquals(i, array[i]);
        }
    }

    @Test
    void deveriaRetornarArrayVazioParaConjuntoVazio() {
        mySet.clear();
        Object[] array = mySet.toArray();

        assertEquals(0, array.length);
    }
}
