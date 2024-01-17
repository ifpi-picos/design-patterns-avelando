package main.java.br.game.renderer;

public class ConsoleRenderer {
    public void renderWelcomeMessage() {
        System.out.println("Bem-vindo ao Jogo da Forca!");
    }

    public void renderCurrentState(String currentState) {
        System.out.println("Estado Atual: " + currentState);
    }

    public void renderCorrectGuess(String currentState) {
        System.out.println("Palpite correto! Estado Atual: " + currentState);
    }

    public void renderIncorrectGuess(int attemptsLeft, String currentState) {
        System.out.println("Palpite incorreto! Tentativas restantes: " + attemptsLeft + " | Estado Atual: " + currentState);
    }

    public void renderGameWon() {
        System.out.println("Parabéns! Você venceu!");
    }

    public void renderGameLost(String actualWord) {
        System.out.println("Fim de jogo! Você esgotou as tentativas. A palavra correta era: " + actualWord);
    }

    public void renderGameResult(String actualWord) {
        System.out.println("Resultado do jogo: A palavra correta era: " + actualWord);
    }
}
