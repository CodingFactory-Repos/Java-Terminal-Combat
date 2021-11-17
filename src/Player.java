class Player {
    private String name;
    private double health;
    private double attack;
    private double initiative;


    public Player(String name, double attack, double health, double initiative) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.initiative = initiative;
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

    public double getInitiative() {
        return initiative;
    }

    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }
}
