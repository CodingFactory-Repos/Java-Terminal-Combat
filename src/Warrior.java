class Warrior {
    private String name;
    private double health;
    private double attack;
    private double shield;
    private double initiative;

    public Warrior(String name, double attack, double health, double initiative, double shield) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.shield = shield;
        this.initiative = initiative;
    }

    public void damage_receive(int nbDamage){
        this.setHealth(this.getHealth() - (nbDamage - getShield()));
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", shield=" + shield +
                '}';
    }

    public String toString(int toStringV2) {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", shield=" + shield +
                '}';
    }

    public String getName() {
        return name;
    }

    public void damage(double damage){
        this.health -= damage;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getHealth(){
        return health;
    }

    public void setHealth (double health){
        this.health = health;
    }

    public double getAttack () {
        return attack;
    }

    public void setAttack (double attack) {
        this.attack = attack;
    }

    public double getShield() {
        return shield;
    }

    public void setShield(double shield) {
        this.shield = shield;
    }

    public double getInitiative() {
        return initiative;
    }
    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }


}