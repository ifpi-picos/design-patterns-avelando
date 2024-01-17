package main.java.br.game.strategy;

import main.java.br.game.exceptions.WordInvalidatesExceptions;
import main.java.br.game.util.ReaderListWord;

import java.util.List;

public class ChooseListWord implements WordChooseStrategy {
    private List<String> wordList;

    public ChooseListWord(String filePath) throws WordInvalidatesExceptions {
        try {
            this.wordList = ReaderListWord.readWordsFromFile(filePath);
        } catch (Exception e) {
            throw new WordInvalidatesExceptions("Erro ao ler a lista de palavras do arquivo: " + e.getMessage());
        }
    }

    @Override
    public String chooseWord() throws WordInvalidatesExceptions {
        if (wordList.isEmpty()) {
            throw new WordInvalidatesExceptions("A lista de palavras está vazia.");
        }

        int randomIndex = (int) (Math.random() * wordList.size());
        return wordList.get(randomIndex);
    }
}
