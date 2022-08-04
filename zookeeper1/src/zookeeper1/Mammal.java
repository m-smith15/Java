package zookeeper1;

public class Mammal {
	//public member variable energy
	public int energyLevel;
	public String name;
	
	//constructor
	public Mammal(String mammalName) {
		this.name = mammalName;
		this.energyLevel = 100;
	}
	
	//display method
	public void displayEnergy() {
		System.out.println("Mammal is called " + name + ". Life could be dream. It has an energy level of " + energyLevel);
	}

}
