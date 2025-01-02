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
    void deveriaAdicionarElemento() {
        Model model = new Model(123);
        myList.add(model);
        assertTrue(myList.contains(model));
    }

    @Test
    void deveriaCrescerAoAlcançarCapacidadePadrao() {
        myList.add(new Model(123));
        assertEquals(11, myList.size());
    }

    @Test
    void aListaNaoDeveriaEstarVazia() {
        assertFalse(myList.isEmpty());
    }

    @Test
    void deveriaLimparLista() {
        myList.clear();
        assertEquals(0, myList.size());
        assertTrue(myList.isEmpty());
    }

    @Test
    void deveriaRemoverObjetoNulo() {
        myList.add(null);
        assertTrue(myList.remove(null));
    }

    @Test
    void deveriaRemoverObjeto() {
        Model model = new Model(123);
        myList.add(model);
        assertTrue(myList.remove(model));
    }

    @Test
    void naoDeveriaRemoverObjetoNaoPresenteNaLista() {
        assertFalse(myList.remove(null));
        assertFalse(myList.remove(new Model(123)));
    }

    @Test
    void deveriaDefinirNovoValorParaIndice() {
        Model newModel = new Model(123);
        Model oldModel = (Model) myList.set(0, newModel);
        assertNotEquals(myList.get(0), oldModel);
    }

    @Test
    void deveriaRetornarVerdadeiroQuandoTodosElementosEstiveremPresentes() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(1));
        collection.add(new Model(2));

        assertTrue(myList.containsAll(collection));
    }

    @Test
    void deveriaRetornarFalsoQuandoNemTodosElementosEstiveremPresentes() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(11));
        collection.add(new Model(22));

        assertFalse(myList.containsAll(collection));
    }

    @Test
    void deveriaAdicionarTodosElementosNaLista() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(12));
        collection.add(new Model(22));
        collection.add(new Model(23));

        assertTrue(myList.addAll(collection));
        assertTrue(myList.containsAll(collection));
        assertEquals(13, myList.size());
    }

    @Test
    void deveriaAdicionarElementosDuplicados() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(1));
        collection.add(new Model(22));

        assertTrue(myList.addAll(collection));
        assertEquals(12, myList.size());
    }

    @Test
    void deveriaRemoverTodosItensPresentesNaLista() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(1));
        collection.add(new Model(3));

        assertTrue(myList.removeAll(collection));
        assertEquals(8, myList.size());
    }

    @Test
    void naoDeveriaRemoverItensNaoPresentesNaLista() {
        MyList<Model> collection = new MyList<>();
        collection.add(new Model(100));

        assertFalse(myList.removeAll(collection));
        assertEquals(10, myList.size());
    }

    @Test
    void deveriaGerarSubListaComIntervaloValido() {
        MyList<Model> subList = myList.subList(2, 5);
        assertTrue(myList.containsAll(subList));
    }

    @Test
    void deveriaAdicionarNoIndice() {
        Model newModel = new Model(100);
        myList.add(5, newModel);

        assertEquals(11, myList.size());

        assertEquals(newModel, myList.get(5));

        assertEquals(new Model(5), myList.get(6));
    }

    @Test
    void deveriaInserirNoIndiceEmListaVazia() {
        myList.clear();
        Model newModel = new Model(100);
        myList.add(5, newModel);

        assertNull(myList.get(4));
        assertEquals(1, myList.size());
        assertEquals(newModel, myList.get(5));
    }

    @Test
    void deveriaConverterParaArrayCorretamente() {
        Object[] array = myList.toArray();

        assertEquals(myList.size(), array.length);

        for (int i = 0; i < myList.size(); i++) {
            assertEquals(myList.get(i), array[i]);
        }
    }

    @Test
    void deveriaAdicionarColecaoEmListaVazia() {
        MyList<Model> toAdd = new MyList<>();
        toAdd.add(new Model(100));
        toAdd.add(new Model(101));

        myList.clear();

        boolean result = myList.addAll(5, toAdd);

        assertTrue(result);
        assertEquals(2, myList.size());
    }

    @Test
    void deveriaAdicionarElementosNoMeio() {
        MyList<Model> toAdd = new MyList<>();
        toAdd.add(new Model(100));
        toAdd.add(new Model(101));

        boolean result = myList.addAll(5, toAdd);

        assertTrue(result);
        assertEquals(12, myList.size());
    }

    @Test
    void deveriaRetornarFalsoAoAdicionarListaVazia() {
        MyList<Model> emptyList = new MyList<>();

        boolean result = myList.addAll(3, emptyList);

        assertFalse(result);
        assertEquals(10, myList.size());
    }

    @Test
    void deveriaRetornarFalsoAoAdicionarListaNula() {
        boolean result = myList.addAll(3, null);

        assertFalse(result);
        assertEquals(10, myList.size());
    }

    @Test
    void deveriaRetornarIndiceDoElementoNuloPresente() {
        myList.add(null);

        int index = myList.indexOf(null);
        assertEquals(10, index);
    }

    @Test
    void deveriaRetornarIndiceDoElementoNuloAusente() {
        int index = myList.indexOf(null);
        assertEquals(-1, index);
    }

    @Test
    void deveriaManterTodaInterseccaoNaoVazia() {
        MyList<Model> toRetain = new MyList<>();
        toRetain.add(new Model(1));
        toRetain.add(new Model(3));
        toRetain.add(new Model(5));

        assertTrue(myList.retainAll(toRetain));
        assertEquals(3, myList.size());
    }

    @Test
    void deveriaManterTodaListaVazia() {
        MyList<Model> emptyList = new MyList<>();

        assertTrue(myList.retainAll(emptyList));
        assertEquals(0, myList.size());
    }

    @Test
    void deveriaRetornarUltimoIndiceDoElementoPresenteMultiplaVezes() {
        Model modelToFind = new Model(2);
        myList.add(modelToFind);
        assertEquals(10, myList.lastIndexOf(modelToFind));
        assertEquals(2, myList.indexOf(modelToFind));
    }

    @Test
    void deveriaRetornarMenosUmParaUltimoIndiceDeElementoNaoPresente() {
        assertEquals(-1, myList.lastIndexOf(null));
    }

    @Test
    void deveriaRetornarUltimoIndiceDeElementoNulo() {
        myList.add(null);
        assertEquals(10, myList.lastIndexOf(null));
    }

    @Test
    void deveriaRetornarMenosUmParaUltimoIndiceEmListaVazia() {
        myList.clear();
        assertEquals(-1, myList.lastIndexOf(new Model(1)));
    }

    @Test
    void deveriaRetornarMenosUmParaElementoNaoPresente() {
        assertEquals(-1, myList.lastIndexOf(new Model(100)));
    }
}
