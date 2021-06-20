package br.univali.eng.karoline.model.enums;

public enum Position {
    GOLEIRO(4,6),
    DEFENSOR(6,4),
    ATACANTE(4,6);

    private final int firstMultiplier;
    private final int secondMultiplier;


    Position(int firstMultiplier, int secondMultiplier) {
        this.firstMultiplier = firstMultiplier;
        this.secondMultiplier = secondMultiplier;
    }

    public int calculateSkill(int firstAttribute, int secondAttribute){
        return (firstAttribute * firstMultiplier) + (secondAttribute * secondMultiplier);
    }

    public int getFirstMultiplier() {
        return firstMultiplier;
    }

    public int getSecondMultiplier() {
        return secondMultiplier;
    }
}
