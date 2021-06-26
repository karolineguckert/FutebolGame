package br.univali.eng.karoline.src.game;

import br.univali.eng.karoline.src.enums.Position;
import br.univali.eng.karoline.src.validator.GameException;
import br.univali.eng.karoline.src.validator.Validator;

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
                  String positionName,
                  int firstAttribute,
                  int secondAttribute,
                  int shirtNumber,
                  int age) throws GameException {
        Validator validator = new Validator();
        validator.validatePositionName(positionName);
        firstAttributeValidator(positionName, firstAttribute);
        validator.validateAttributeValue(secondAttribute);
        this.name = name;
        this.position = Position.valueOf(positionName.toUpperCase());
        this.shirtNumber = shirtNumber;
        this.goals = 0;
        this.age = age;
        this.attributes = new ArrayList<>();
        addFirstAttribute(positionName,firstAttribute);
        attributes.add(secondAttribute);
        this.skillPoints = position.calculateSkill(attributes.get(0),attributes.get(1));
    }

    private void firstAttributeValidator(String positionName, int firstAttribute) throws GameException {
        Validator validator = new Validator();
        if(positionName.toUpperCase().equals("GOLEIRO")) {
            validator.validateHeightBound(firstAttribute);
        }else {
            validator.validateAttributeValue(firstAttribute);
        }
    }

    private void addFirstAttribute(String positionName, int firstAttribute){
        if (positionName.toUpperCase().equals("GOLEIRO")) {
            attributes.add(calculateHeight(firstAttribute, position.name()));
        }else{
            attributes.add(firstAttribute);
        }
    }

    private int calculateHeight(int firstAttribute, String positionName){
        return firstAttribute - 110;
    }

    public void makeScore(){
        this.goals++;
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
