
public class WeaponTrader implements Trader{

	Inventory inventory;
	
	WeaponTrader(){
		inventory = new Inventory(3);
		 Weapon weapon1 = new Weapon("Sword", 5, 10);
		 Weapon weapon2 = new Weapon("FireBall", 5, 10);
		 Weapon weapon3 = new Weapon("Dagger", 5, 10);
		
		inventory.addItem(weapon1, 20);
		inventory.addItem(weapon2, 15);
		inventory.addItem(weapon3, 10);
	}
	
	@Override
	public int buy(Weapon item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Weapon sell(int itemNumber) {
		// TODO Auto-generated method stub
		
		
		return inventory.removeItem(itemNumber);
	}

	@Override
	public int getPrice(int itemNumber) {
		// TODO Auto-generated method stub
		return inventory.getItemPrice(itemNumber);
	}

	@Override
	public void listAllItems() {
		// TODO Auto-generated method stub
		
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	

	
	
}
