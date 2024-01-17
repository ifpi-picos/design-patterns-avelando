package main.java.br.game.util;

import main.java.br.game.exceptions.WordInvalidatesExceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderListWord {
    public static List<String> readWordsFromFile(String filePath) throws WordInvalidatesExceptions {
        List<String> wordList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordList.add(word.trim());
                }
            }
        } catch (IOException e) {
            throw new WordInvalidatesExceptions("Erro ao ler arquivo de palavras: " + e.getMessage());
        }

        return wordList;
    }
}
