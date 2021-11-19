class Player {
    private String name;
    private String classes;
    private double health;
    private double attack;
    private double initiative;
    private double power;

    public Player(String name, String classes, double attack, double health, double initiative, double power) {
        this.name = name;
        this.classes = classes;
        this.attack = attack;
        this.health = health;
        this.initiative = initiative;
        this.power = power;
    }

    public void damage(double damage) {
        if(getClassName().equals("Warrior")){
            this.health -= (damage - this.power);
        } else {
            this.health -= damage;
        }
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttack() {
        System.out.println(getClassName());

        if(getClassName().equals("Magicien")){
            System.out.println("Magicien Selected");
            this.power = this.power / 2;
            return attack + this.power;
        } else {
            System.out.println("Personne normale");
            return attack;
        }
    }

    public double getInitiative() {
        return initiative;
    }

    public String getClassName() {
        return classes;
    }
}
