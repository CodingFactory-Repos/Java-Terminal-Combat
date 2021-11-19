import java.util.Random;

class Player {
    private String name;
    private String classes;
    private double health;
    private double attack;
    private double initiative;
    private double power;
    private boolean thiefSettings = true;

    public Player(String name, String classes, double attack, double health, double initiative, double power) {
        this.name = name;
        this.classes = classes;
        this.attack = attack;
        this.health = health;
        this.initiative = initiative;
        this.power = power;
    }

    public void damage(double damage) {
        if (getClassName().equals("Guerrier")) {
            this.health -= (damage - this.power);
        } else if (getClassName().equals("Voleurs")) {
            if ((new Random().nextInt((int) this.power) + 1) == 1) {
                this.health = (this.health - 0);
            } else {
                this.health -= damage;
            }
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
        if (getClassName().equals("Magicien")) {
            this.power = this.power / 2;
            return attack + this.power;
        } else if (getClassName().equals("Voleurs")) {
            if ((new Random().nextInt((int) this.power) + 1) == 1 && thiefSettings) {
                this.thiefSettings = false;
                return (attack * 2);
            } else {
                this.thiefSettings = true;
                return attack;
            }
        } else {
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
