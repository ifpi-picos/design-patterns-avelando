package main.java.br.game;

import main.java.br.game.exceptions.WordInvalidatesExceptions;
import main.java.br.game.renderer.ConsoleRenderer;
import main.java.br.game.strategy.ChooseListWord;
import main.java.br.game.strategy.ChooseRandomWord;
import main.java.br.game.strategy.WordChooseStrategy;

import java.util.Scanner;

public class HangmanGame {
    private SecretWord secretWord;
    private Player player;
    private ConsoleRenderer renderer;
    private WordChooseStrategy wordChooseStrategy;

    public HangmanGame(Player player, ConsoleRenderer renderer, WordChooseStrategy wordChooseStrategy) {
        this.player = player;
        this.renderer = renderer;
        this.wordChooseStrategy = wordChooseStrategy;
    }

    public void startGame() {
        try {
            initializeGame();
            while (!isGameOver()) {
                playTurn();
            }
            displayGameResult();
        } catch (WordInvalidatesExceptions e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void initializeGame() throws WordInvalidatesExceptions {
        secretWord = new SecretWord(wordChooseStrategy.chooseWord());
        renderer.renderWelcomeMessage();
        renderer.renderCurrentState(secretWord.getCurrentState());
    }

    private void playTurn() {
        char guessedLetter = player.guessLetter();
        boolean isCorrect = secretWord.checkLetter(guessedLetter);

        if (isCorrect) {
            renderer.renderCorrectGuess(secretWord.getCurrentState());
        } else {
            player.decreaseAttempts();
            renderer.renderIncorrectGuess(player.getAttemptsLeft(), secretWord.getCurrentState());
        }
    }

    private boolean isGameOver() {
        if (secretWord.isWordGuessed()) {
            renderer.renderGameWon();
            return true;
        } else if (player.isOutOfAttempts()) {
            renderer.renderGameLost(secretWord.getActualWord());
            return true;
        }
        return false;
    }

    private void displayGameResult() {
        renderer.renderGameResult(secretWord.getActualWord());
    }

    public static void main(String[] args) throws WordInvalidatesExceptions {
        Player player = new Player(6);
        ConsoleRenderer renderer = new ConsoleRenderer();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escolha a estratégia para escolher palavras:");
            System.out.println("1. Escolher aleatoriamente (Random)");
            System.out.println("2. Escolher de uma lista (List)");

            int choice = scanner.nextInt();
            WordChooseStrategy wordChooseStrategy;

            if (choice == 1) {
                wordChooseStrategy = new ChooseRandomWord(new String[]{"apple", "banana", "orange"});
            } else if (choice == 2) {
                System.out.print("Digite o caminho do arquivo de palavras: ");
                String filePath = scanner.next();
                wordChooseStrategy = new ChooseListWord(filePath);
            } else {
                System.out.println("Escolha inválida. Saindo do jogo.");
                return;
            }

            HangmanGame game = new HangmanGame(player, renderer, wordChooseStrategy);
            game.startGame();
        }
    }
}
