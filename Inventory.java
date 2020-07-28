import java.util.ArrayList;

public class Inventory {

	 class Item{
		private Weapon weapon;
		private int price;
		
		Item(Weapon weapon, int price){
			this.weapon = weapon;
			this.price = price;
		}

		public Weapon getWeapon() {
			return weapon;
		}

		public void setWeapon(Weapon weapon) {
			this.weapon = weapon;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			//return "Item [weapon=" + weapon + ", price=" + price + "]";
			//return "Weapon Name:" + item.getWeapon().getName() + ", Range:" + item.getWeapon().getDamageRange() + ", price=" + item.getPrice();
			return "Weapon Name:" + weapon.getName() + ", Range:" + weapon.getDamageRange() + ", price=" + price + "\n";
		}
		
		
		
		
		
		
	}
	
	ArrayList<Item> inventoryItems;
	
	
	Inventory(int capacity){
		inventoryItems = new ArrayList<Inventory.Item>(capacity);
	}
	
	void addItem(Weapon weapon, int price) {
		Item item = new Item(weapon, price);
		inventoryItems.add(item);
	}
	
	Weapon removeItem(int index) {
		Item item = inventoryItems.get(index);
		inventoryItems.remove(index);
		return item.getWeapon();
	}
	
	int getItemPrice(int index) {
		Item item = inventoryItems.get(index);
		return item.getPrice();
	}
	
	ArrayList<String> listAllItems(){
		ArrayList<String> itemDescs = new ArrayList<String>();
		int i=1;
		for(Item item: inventoryItems) {
			String itemDesc =  i + ". " + item.toString();
			itemDescs.add(itemDesc);
			i++;
		}
		
		return itemDescs;
	}

	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(ArrayList<Item> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}
	
	
	
	
}
