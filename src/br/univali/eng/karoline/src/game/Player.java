package br.univali.eng.karoline.src.game;

import br.univali.eng.karoline.src.enums.Position;
import br.univali.eng.karoline.src.exception.GameException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
                  String age) throws GameException {
        validatePositionName(positionName);
        firstAttributeValidator(positionName, firstAttribute);
        validateAttributeValue(secondAttribute);
        this.name = name;
        this.position = Position.valueOf(positionName.toUpperCase());
        this.shirtNumber = shirtNumber;
        this.goals = 0;
        this.age = calculateAge(age);
        this.attributes = new ArrayList<>();
        addFirstAttribute(positionName,firstAttribute);
        attributes.add(secondAttribute);
        this.skillPoints = position.calculateSkill(attributes.get(0),attributes.get(1));
    }

    private void validatePositionName(String positionName) throws GameException {
        try {
            Position.valueOf(positionName.toUpperCase());
        }catch(IllegalArgumentException e){
            throw new GameException("PositionNotFound","A posição que foi inserida não existe ou está escrita de forma equivocada");
        }
    }

    public void validateAttributeValue(int attribute) throws GameException {
        if (attribute < 0 || attribute > 100){
            throw new GameException("InvalidAttributeBound","O valor inserido para o atributo deve estar de 0 á 100");
        }
    }

    public void validateHeightBound (int height) throws GameException {
        if (height <110 || height > 210){
            throw new GameException("InvalidHeightBound", "Altura do Goleiro está fora do intervalo permitido. A altura deve ser Maior igual a 110cm, e Menor igual a 210cm");
        }
    }

    public void validateDate(LocalDate today, LocalDate date) throws GameException {
        if (date.isAfter(today) || today.isEqual(date)) throw new GameException("IllegalDate","Não é possível inserir uma data após o dia de hoje ou igual");
    }

    private int calculateAge(String birthDate) throws GameException {
        LocalDate date;
        try{
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date = LocalDate.parse(birthDate,format);
        }catch (DateTimeException e){
            throw new GameException("InvalidDateValue","Formato de data inserido sai do padrão dd/MM/yyyy");
        }

        LocalDate today = LocalDate.now();
        validateDate(today,date);
        return Period.between(date,today).getYears();
    }

    private void firstAttributeValidator(String positionName, int firstAttribute) throws GameException {
        if(positionName.toUpperCase().equals("GOLEIRO")) {
           validateHeightBound(firstAttribute);
        }else {
            validateAttributeValue(firstAttribute);
        }
    }

    private void addFirstAttribute(String positionName, int firstAttribute){
        if (positionName.toUpperCase().equals("GOLEIRO")) {
            attributes.add(calculateHeight(firstAttribute));
        }else{
            attributes.add(firstAttribute);
        }
    }

    private int calculateHeight(int firstAttribute){
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
