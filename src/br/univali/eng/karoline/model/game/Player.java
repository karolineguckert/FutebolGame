package br.univali.eng.karoline.model.game;

import br.univali.eng.karoline.model.enums.Position;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Position position;
    private List<Integer> attributes;
    private int skillPoints;
    private int shirtNumber;
    private int goals;
    private int age;

    public Player(String name,
                  String namePosition,
                  int firstAttribute,
                  int secondAttribute,
                  int shirtNumber,
                  int age){
        this.name = name;
        this.position = Position.valueOf(namePosition.toUpperCase());
        this.shirtNumber = shirtNumber;
        this.goals = 0;
        this.age = age;
        this.attributes = new ArrayList<>();
        attributes.add(firstAttribute);
        attributes.add(secondAttribute);
        this.skillPoints = position.calculateSkill(attributes.get(0),attributes.get(1));
    }

    public int getAge() {
        return age;
    }

    public int getGoals() {
        return goals;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getFirstAttribute() {
        return attributes.get(0);
    }

    public int getSecondAttribute() {
        return attributes.get(1);
    }
}
