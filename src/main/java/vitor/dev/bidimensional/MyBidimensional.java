package vitor.dev.bidimensional;

import vitor.dev.exception.DataStructureException;

public class MyBidimensional {
    private char[] characters;
    private int[] numbers;

    public MyBidimensional(int charSize, int intSize) {
        this.characters = new char[charSize];
        this.numbers = new int[intSize];
    }

    public char[] getCharacters() {
        return characters;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void insertChar(int position, Object value) {
        try {
            characters[position] = (char) value;
        } catch (Exception e) {
            throw new DataStructureException("Falha ao inserir char no array: " + e.getMessage());
        }
    }

    public void insertNumber(int position, Object value) {
        try {
            numbers[position] = (int) value;
        } catch (Exception e) {
            throw new DataStructureException("Falha ao inserir inteiro no array: " + e.getMessage());
        }
    }

    public void removeChar(int position) {
        try {
            characters[position] = '\u0000';
        } catch (Exception e) {
            throw new DataStructureException("Falha ao remover char no array: " + e.getMessage());
        }
    }

    public void removeNumber(int position) {
        try {
            numbers[position] = 0;
        } catch (Exception e) {
            throw new DataStructureException("Falha ao remover inteiro no array: " + e.getMessage());
        }
    }
}
