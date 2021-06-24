package br.univali.eng.karoline.src.game;

import br.univali.eng.karoline.src.enums.Position;
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
        attributes.add(calculateHeight(firstAttribute,position.name()));
        attributes.add(secondAttribute);
        this.skillPoints = position.calculateSkill(attributes.get(0),attributes.get(1));
    }

    private int calculateHeight(int firstAttribute, String positionName){
        if (positionName.toUpperCase().equals("GOLEIRO")){
            return firstAttribute - 110;
        } else{
            return firstAttribute;
        }
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position +
                ", attributes=" + attributes +
                ", skillPoints=" + skillPoints +
                ", shirtNumber=" + shirtNumber +
                ", goals=" + goals +
                ", age=" + age +
                '}';
    }
}
