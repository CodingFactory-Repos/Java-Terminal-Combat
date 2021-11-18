class Warrior {
    private String name;
    private double health;
    private double attack;
    private double shield;

    public Warrior(String name, double attack, double health, double shield) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.shield = shield;
    }

    public void damage_receive(int nbDamage){
        this.setHealth(this.getHealth() - (nbDamage - getShield()));
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


}