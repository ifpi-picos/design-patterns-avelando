package main.java.br.game.strategy;

import main.java.br.game.exceptions.WordInvalidatesExceptions;

import java.util.Random;

public class ChooseRandomWord implements WordChooseStrategy {
    private String[] wordArray;

    public ChooseRandomWord(String[] wordArray) throws WordInvalidatesExceptions {
        if (wordArray == null || wordArray.length == 0) {
            throw new WordInvalidatesExceptions("O array de palavras está vazio ou nulo.");
        }
        this.wordArray = wordArray;
    }

    @Override
    public String chooseWord() throws WordInvalidatesExceptions {
        if (wordArray.length == 0) {
            throw new WordInvalidatesExceptions("A lista de palavras está vazia.");
        }

        Random random = new Random();
        return wordArray[random.nextInt(wordArray.length)];
    }
}
