package scene;

import entity.Player;
import game.InputHandler;
import game.TextEffect;

public class BasementStairs extends Place {

    public BasementStairs() {
        super("지하 계단", "차가운 계단");
    }

    @Override
    public Place enter(Player player) {

        System.out.println("=====================");
        System.out.println(getName() + " : " + getDescription());
        System.out.println("=====================");

        TextEffect.type("""
                
                "...끼익...탁..타닥..."
                
                소름끼치는 소리가 들린다. 
                윗층에서 무언가가 내려오는 소리 같기도 하다.
                얼른 이곳을 탈출하고 싶다..
                
                """);

        System.out.println("1. 내려간다");
        System.out.println("2. 뒤를 본다");

        int choice = InputHandler.getChoice(1, 2);

        if (choice == 2) {

            TextEffect.type("""
                    
                        아무것도 없다.
                        "내 착각이었나..."
                        계속 아래로 내려가봐야겠다.
                    
                    """);

        }

        return new FinalDoor();

    }

}