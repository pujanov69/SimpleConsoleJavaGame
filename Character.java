
public abstract class Character {

	protected String name;
	protected int health;
	protected int accuracy;
	protected Weapon weapon;
	
	
	public boolean isDead() {
		return health <= 0;
	}
	
    public void takeDamage(int damage) {
        health -= damage;
    }

    public void displayHealth() {
        System.out.println(name + "'s health = " + health);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Character(String name, int health, int accuracy, Weapon weapon) {
		this.name = name;
		this.health = health;
		this.accuracy = accuracy;
		this.weapon = weapon;
	}

	public Character(Character character) {
		this.name = character.getName();
		this.health = character.getHealth();
		this.accuracy = character.getAccuracy();
		this.weapon = character.getWeapon();
	}
	
}
