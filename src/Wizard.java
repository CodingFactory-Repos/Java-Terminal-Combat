class Wizard {

    private String name;
    private double health;
    private double attack;
    private double magic;
    private double attack_magic;
    private double initiative;

    public Wizard(String name, double attack, double health, double initiative, double magic, double attack_magic) {
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.magic = magic ;
        this.attack_magic = attack_magic;
        this.initiative = initiative;
    }

    public double getAttack_magic() {
        return attack_magic;
    }

    public void setAttack_magic(double attack_magic) {
        this.attack_magic = attack_magic;
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

    public double getMagic() {
        return magic;
    }

    public void setMagic(double magic) {
        this.magic = magic;
    }

    public void decreaseMagic() {
        magic = magic / 2;
    }

    public void AttackMagic(){
        attack_magic = magic + attack;
    }

    public double getInitiative() {
        return initiative;
    }


    public void setInitiative(double initiative) {
        this.initiative = initiative;
    }

}


