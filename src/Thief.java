class Thief {
    private String name;
    private double health;
    private double attack;
    private double critical;
    private double dodge;

    public Thief(String name, double attack, double health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.critical = critical;
        this.dodge = dodge;
    }

    @Override
    public String toString() {
        return "Thief{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", critical=" + critical +
                ", dodge=" + dodge +
                '}';
    }

    public String toString(int toStringV2) {
        return "Thief{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", critical=" + critical +
                ", dodge=" + dodge +
                '}';
    }

    public String getName() {
        return name;
    }

    public void damage(double damage){
        this.health -= damage;
    }

    public void setName(String name){
        this.name =name;
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

    public double getCritical() {
        return critical;
    }

    public void setCritical(double critical) {
        this.critical = critical;
    }

    public double getDodge() {
        return dodge;
    }

    public void setDodge(double dodge) {
        this.dodge = dodge;
    }
}


