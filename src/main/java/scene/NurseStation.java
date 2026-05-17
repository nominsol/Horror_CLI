package scene;

import entity.PatientGhost;
import entity.Player;
import game.InputHandler;
import game.TextEffect;

public class NurseStation extends Place {

    private PatientGhost ghost;

    public NurseStation() {
        super("간호사실", "버려진 간호사실");
        ghost = new PatientGhost("302호 환자", 302);
    }

    @Override
    public Place enter(Player player) {

        System.out.println("=====================");
        System.out.println(getName() + " : " + getDescription());
        System.out.println("=====================");

        TextEffect.type("""
                
                컴퓨터 화면이 켜진다.
                
                """ +
                ghost.getPatientID() + "호를 비추는 CCTV화면인 것 같다." +
                """
                
                어쩐지 소름이 끼치는 장소이다.
                무엇을 할지 생각해보자.
                
                """);

        while (true) {
            System.out.println("1. 서랍 열기");
            System.out.println("2. CCTV 확인");
            System.out.println("3. 나가기");

            int choice = InputHandler.getChoice(1, 3);

            switch (choice) {

                case 1:

                    if(player.hasKey()){
                        TextEffect.type("""
                            
                            텅 비어있다.
                            """);
                        break;
                    }
                    player.setHasKey(true);

                    TextEffect.type("""
                            
                            녹슨 열쇠를 발견했다.
                            """);

                    break;

                case 2:

                    ghost.scare();
                    player.setDie(true);
                    return null;

                case 3:
                    return new Corridor();

            }
        }
    }

}