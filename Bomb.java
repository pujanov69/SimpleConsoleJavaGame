
public class Bomb extends Weapon {
	


	private int numberOfEnemies;

	
	public Bomb(String name, int low, int high, int numberOfEnemies) {
		super(name, low, high);
		this.setNumberOfEnemies(numberOfEnemies);
	}

	public int getNumberOfEnemies() {
		return numberOfEnemies;
	}

	public void setNumberOfEnemies(int numberOfEnemies) {
		this.numberOfEnemies = numberOfEnemies;
	}


}
