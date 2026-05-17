package scene;

import entity.Player;
import game.TextEffect;

public class FinalDoor extends Place {

    public FinalDoor() {
        super("철문", "출구");
    }

    @Override
    public Place enter(Player player) {

        System.out.println("=====================");
        System.out.println(getName() + " : " + getDescription());
        System.out.println("=====================");

        TextEffect.type("""
                
                드디어 출구를 발견했다.
                철문 옆에 환자 명단이 쓰여있다.
                
                [302번 환자]
                상태: 사망
                
                온몸에 소름이 돋는다.
                얼른 철문을 열고 밖으로 나가야 한다..
                
                
                """);

        if (player.hasKey() && player.hasHint()) {
            secretEnding();
        } else if (player.hasKey()) {
            trueEnding();
        } else {
            badEnding();
            player.setDie(true);
        }

        return null;

    }

    private void trueEnding() {

        TextEffect.type("""
                
                아까 가져온 열쇠로 철문을 열었다.
                
                문이 열린다.
                
                살아남았다.
                
                """);

    }

    private void badEnding() {

        TextEffect.type("""
                
                "철컥철컥"
                
                문이 잠겨있다.
        
                불이 꺼진다.
                
                웃음소리가 들린다.
                
                """);

    }

    private void secretEnding() {

        TextEffect.type("""
                
                302호는 왜 나를 도와준 것일까..
                죽은 채로 이곳을 영원히 방황하는 것일까
                
                
                그를 위해 짧게 기도를 하고 열쇠로 철문을 열었다.
                
                문이 열린다.
                
                뒤를 돌아보니 소름끼쳤던 느낌은 온데간데 없고, 
                평범한 폐병원의 모습만 보였다.
                
                """);

    }

}