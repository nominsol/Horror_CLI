package scene;

import entity.Player;
import game.InputHandler;
import game.TextEffect;

public class HospitalRoom extends Place {

    public HospitalRoom() {
        super("병실", "낡은 병실");
    }

    @Override
    public Place enter(Player player) {

        System.out.println("=====================");
        System.out.println(getName() + " : " + getDescription());
        System.out.println("=====================");

        TextEffect.type("""
                
                새벽 3시.
                
                정신병동에서 눈을 떴다.
                
                "내가 왜 이곳에 있는거지..?"
                
                아무것도 기억이 나지 않는다.
                일단 무엇을 할지 생각해보자.
                """);

        while(true) {
            System.out.println("1. 커튼 확인");
            System.out.println("2. 병실 탈출");
            System.out.println("3. 침대 밑 조사");

            int choice = InputHandler.getChoice(1, 3);

            switch (choice) {

                case 1:

                    TextEffect.type("""
                            
                            커튼 뒤에는 아무것도 없다.
                            하지만 이상하다. 
                            창문 밖이 어둠에 잠식된 듯 아무것도 보이지 않는다.
                            """);
                    break;

                case 2:
                    TextEffect.type("""
                            
                            "일단 병실을 탈출해야겠어.."
                            
                            심호흡을 한 뒤, 문을 열고 복도로 향한다.
                            """);
                    break;

                case 3:
                    player.setHasHint(true);

                    TextEffect.type("""
                            침대 밑에 작게 쓰여진 글씨가 보인다.
                            
                            "반드시 열쇠를 찾아. 그리고 나를 찾지마 -302-"
                      
                            """);
                    break;
            }

            if(choice == 2) break;
        }

        return new Corridor();

    }

}