package vitor.dev.bidimensional;

import vitor.dev.exception.DataStructureException;
import vitor.dev.utils.LoggerApi;

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
			LoggerApi.info(String.format("Valor %s inserido no array de char, posição %d.", value, position));
		} catch (Exception e) {
			LoggerApi.error(String.format("Erro ao inserir valor %s no array de char, posição %d: %s", value, position,
					e.getMessage()));
			throw new DataStructureException("Falha ao inserir char no array: " + e.getMessage());
		}
	}

	public void insertNumber(int position, Object value) {
		try {
			numbers[position] = (int) value;
			LoggerApi.info(String.format("Valor %s inserido no array de int, posição %d.", value, position));
		} catch (Exception e) {
			LoggerApi.error(String.format("Erro ao inserir valor %s no array de char, posição %d: %s", value, position,
					e.getMessage()));
			throw new DataStructureException("Falha ao inserir inteiro no array: " + e.getMessage());
		}
	}

	public void removeChar(int position) {
		try {
			characters[position] = '\u0000';
			LoggerApi.info(String.format("Posição %d removida do array de char.", position));
		} catch (Exception e) {
			LoggerApi.info(String.format("Erro ao remover posição %d do array de char: %s", position, e.getMessage()));
			throw new DataStructureException("Falha ao remover char no array: " + e.getMessage());
		}
	}

	public void removeNumber(int position) {
		try {
			numbers[position] = 0;
			LoggerApi.info(String.format("Posição %d removida do array de int.", position));
		} catch (Exception e) {
			LoggerApi.info(String.format("Erro ao remover posição %d do array de int: %s", position, e.getMessage()));
			throw new DataStructureException("Falha ao remover inteiro no array: " + e.getMessage());
		}
	}
}
