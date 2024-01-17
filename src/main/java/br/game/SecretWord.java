package main.java.br.game;

import main.java.br.game.exceptions.WordInvalidatesExceptions;

public class SecretWord {
    private String actualWord;
    private StringBuilder currentState;

    public SecretWord(String actualWord) throws WordInvalidatesExceptions {
        if (actualWord == null || actualWord.trim().isEmpty()) {
            throw new WordInvalidatesExceptions("Palava inválida.");
        }
        this.actualWord = actualWord.toLowerCase();
        initializeCurrentState();
    }

    private void initializeCurrentState() {
        currentState = new StringBuilder();
        for (int i = 0; i < actualWord.length(); i++) {
            if (Character.isLetter(actualWord.charAt(i))) {
                currentState.append('_');
            } else {
                currentState.append(actualWord.charAt(i));
            }
        }
    }

    public boolean checkLetter(char guessedLetter) {
        boolean isCorrect = false;
        for (int i = 0; i < actualWord.length(); i++) {
            if (Character.toLowerCase(actualWord.charAt(i)) == guessedLetter) {
                currentState.setCharAt(i, actualWord.charAt(i));
                isCorrect = true;
            }
        }
        return isCorrect;
    }

    public boolean isWordGuessed() {
        return currentState.indexOf("_") == -1;
    }

    public String getActualWord() {
        return actualWord;
    }

    public String getCurrentState() {
        return currentState.toString();
    }
}
