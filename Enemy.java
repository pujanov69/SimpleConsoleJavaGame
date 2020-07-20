public class Enemy {
    private String name;
    private int health;
    private int accuracy;
    private int experienceReward;
    private Weapon weapon;

    public Enemy(String name, int health, int accuracy, int experienceReward, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.accuracy = accuracy;
        this.experienceReward = experienceReward;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void attack(Player player) {
        System.out.println("A " + this.name + " attacks you with a " + this.weapon.getName());
        if (Utility.random(0, 20) < accuracy) {
            int damage = Utility.random(weapon.getDamageRange());
            System.out.println("You are hit for " + damage + " damage!");
            player.takeDamage(damage);
        } else {
            System.out.println("The " + name + " missed!");
        }
        System.out.println();
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void displayHealth() {
        System.out.println(name + "'s health = " + health);
    }

}
