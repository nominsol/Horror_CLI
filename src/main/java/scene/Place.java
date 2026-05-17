package scene;

import entity.Player;

public class Place {
    private String name;
    private String description;

    public Place(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Place enter(Player player){
        System.out.println(name);
        System.out.println(description);
        return new HospitalRoom();
    }
}
