package main.java.br.game.strategy;

import main.java.br.game.exceptions.WordInvalidatesExceptions;

public interface WordChooseStrategy {
    String chooseWord() throws WordInvalidatesExceptions;
}
