package scene;

import entity.Player;
import entity.StalkGhost;
import game.InputHandler;
import game.TextEffect;
import game.InputHandler;

public class Corridor extends Place {

    private StalkGhost ghost;

    public Corridor() {

        super("복도", "어두운 복도");
        ghost = new StalkGhost("추적자", 2);

    }

    @Override
    public Place enter(Player player) {

        System.out.println("=====================");
        System.out.println(getName() + " : " + getDescription());
        System.out.println("=====================");

        TextEffect.type("""
                
                복도가 어두워서 아무것도 보이지 않는다.
                벽을 짚으며 갈 수밖에 없나...
                
                저 멀리 어떤 형체가 보이는 것 같기도 하다.
                공포심이 만든 헛것인지 사람인지 모르겠다.
                
                """);

        while (true) {

            int distance = ghost.getDistance();

            // 귀신 조우
            if (distance <= 0) {

                ghost.scare();
                player.setDie(true);
                return null;
            }

            printCorridorText(distance);
            printChoices(distance);

            int choice;

            if (distance == 2) {
                choice = InputHandler.getChoice(1, 2);

                if (choice == 1) {
                    ghost.follow();
                } else {
                    return new NurseStation();
                }

            } else {

                choice = InputHandler.getChoice(1, 2);

                if (choice == 1) {
                    ghost.follow();
                } else {
                    return new BasementStairs();
                }

            }

        }

    }

    private void printCorridorText(int distance) {

        switch (distance) {

            case 2:
                TextEffect.type("""
                    
                    복도가 끝없이 이어진다.
                    
                    멀리서 휠체어 소리가 들린다.
                    """);
                break;

            case 1:
                TextEffect.type("""
                    
                    터벅...
                    터벅...
                    
                    발소리가 가까워진다.
                    """);
                break;

        }

    }

    private void printChoices(int distance) {

        System.out.println();
        System.out.println("1. 앞으로 이동한다");

        if (distance == 2) {
            System.out.println("2. 간호실로 들어간다");
        } else {
            System.out.println("2. 지하실로 내려간다");
        }

    }

}