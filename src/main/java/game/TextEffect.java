package game;

public class TextEffect {

    public static void type(String text) {

        for (char c : text.toCharArray()) {

            System.out.print(c);

            try {
                Thread.sleep(50);
            } catch (Exception ignored) {
            }

        }

        System.out.println();

    }

}
