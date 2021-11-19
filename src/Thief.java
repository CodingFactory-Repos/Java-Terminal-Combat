import java.util.Random;

class Thief {
    private String name;
    private double health;
    private double attack;
    private double initiative;

    public Thief(String name, double attack, double health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.initiative = initiative;
    }

    @Override
    public String toString() {
        return "Thief{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", initiative=" + initiative +
                '}';
    }

    public String toString(int tosString2) {
        return "Thief{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", initiative=" + initiative +
                '}';
    }

    public String getName() {
        return name;
    }

    public void damage(double damage){
        int min = 1;
        int max = 10;

        Random random = new Random();

        int a = random.nextInt(max + min) + min;
        if (a < 5) {
            this.health -= damage;
        }
        else{
            this.health = 0;
        }
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
        int min = 1;
        int max = 10;

        Random random = new Random();

        int a = random.nextInt(max + min) + min;
        if (a > 5){
            return attack * 2;
        }
        else {
            return attack;
        }
    }

    public double getInitiative() {
        return initiative;
    }

    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }

    public void Random_dodge() {
        int min = 1;
        int max = 10;

        Random random = new Random();

        int a = random.nextInt(max + min) + min;
        if (a > 5){

        }
    }
}



