class Wizard {
    private String name;
    private double health;
    private double attack;
    private double initiative;
    private double magic;

    public Wizard(String name, double attack, double health, double initiative, double magic) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.initiative = initiative;
        this.magic = magic * 2;
    }

    public void damage(double damage) {
        this.health -= damage;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getAttack() {
        this.magic = this.magic / 2;
        return attack + this.magic;
    }

    public double getInitiative() {
        return initiative;
    }
}
