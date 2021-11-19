class Warrior {
    private String name;
    private double health;
    private double attack;
    private double initiative;
    private double shield;

    public Warrior(String name, double attack, double health, double initiative, double shield) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.initiative = initiative;
        this.shield = shield;
    }

    public void damage(double damage) {
        this.health -= (damage - this.shield);
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        return attack;
    }

    public double getInitiative() {
        return initiative;
    }
}
