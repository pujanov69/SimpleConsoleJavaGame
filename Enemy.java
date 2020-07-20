public class Enemy extends Character {
    private int experienceReward;
    private Shield shield;
    private int shieldResistance;

    public Enemy(String name, int health, int accuracy, int experienceReward, Weapon weapon, Shield shield) {
    	super(name, health, accuracy, weapon);
        this.experienceReward = experienceReward;
        this.shield = shield;
        shieldResistance = shield.getResistance();
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


	@Override
	public void takeDamage(int damage) {
	
		if(shieldResistance > 0) {
			shieldResistance -= damage;
			if(shieldResistance <= 0) {
				System.out.println("The " + shield.getType() + " shield is broken");
			}
		} else {
			health -= damage;
		}
	}

}
