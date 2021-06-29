package br.univali.kob.eng.enums;

public enum Position {
    GOLEIRO(4,6,1),
    DEFENSOR(6,4, 2),
    ATACANTE(4,6, 2);

    private final int firstMultiplier;
    private final int secondMultiplier;
    private final int maximumPlayerPosition;


    Position(int firstMultiplier, int secondMultiplier, int maximumPlayerPosition) {
        this.firstMultiplier = firstMultiplier;
        this.secondMultiplier = secondMultiplier;
        this.maximumPlayerPosition = maximumPlayerPosition;
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

    public int getMaximumPlayerPosition() {
        return maximumPlayerPosition;
    }
}
