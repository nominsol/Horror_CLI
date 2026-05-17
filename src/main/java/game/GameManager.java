package game;

import entity.Player;
import scene.HospitalRoom;
import scene.Place;

public class GameManager {

    private Player player;

    public GameManager() {
        player = new Player();
    }

    //게임 시작 메서드
    public void start() {

        TextEffect.type("""
                
                ~~~~~~~~~~~~~~~~~~~~~
                  복도 끝의 병실
                ~~~~~~~~~~~~~~~~~~~~~
                """);

        Place currentPlace = new HospitalRoom();

        while (currentPlace != null) {
            currentPlace = currentPlace.enter(player);
        }

        if(player.isDie()) {
            TextEffect.type("""
                    
                    GAME OVER
                    
                    """);

        } else {
            TextEffect.type("""
                    
                    GAME END
                    
                    """);
        }
    }
}