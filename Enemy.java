public class Enemy extends Character {
    private int experienceReward;

    public Enemy(int experienceReward, String name, int health, int accuracy, Weapon weapon) {
    	super(name, health, accuracy, weapon);
        this.experienceReward = experienceReward;
    }


    public int getExperienceReward() {
        return experienceReward;
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

}
