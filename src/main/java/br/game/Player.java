package main.java.br.game;

import java.util.Scanner;

public class Player {
    private int attemptsLeft;
    private Scanner scanner;

    public Player(int maxAttempts) {
        this.attemptsLeft = maxAttempts;
        this.scanner = new Scanner(System.in);
    }

    public char guessLetter() {
        System.out.print("Digite a letra: ");
        String input = scanner.nextLine().toLowerCase();

        while (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            System.out.println("Entrada inválida. Insira apenas uma letra.");
            System.out.print("Digite a letra: ");
            input = scanner.nextLine().toLowerCase();
        }

        return input.charAt(0);
    }

    public void decreaseAttempts() {
        attemptsLeft--;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public boolean isOutOfAttempts() {
        return attemptsLeft <= 0;
    }
}