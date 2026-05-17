package game;

import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    public static int getChoice(int min, int max) {

        while (true) {

            System.out.print(">> ");

            try {

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice >= min && choice <= max) {
                    return choice;
                }

            } catch (Exception ignored) {
            }

            System.out.println("잘못된 입력입니다.");

        }

    }

}