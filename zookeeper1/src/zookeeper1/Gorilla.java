package zookeeper1;

public class Gorilla extends Mammal {

	public Gorilla(String mammalName) {
		super(mammalName);
		//this.energyLevel = 100;
		// TODO Auto-generated constructor stub
	}
	
	public void flingThing() {
		this.energyLevel -= 5;
		System.out.println(name + " flings a thing. Best not to think about what that thing could be.");
	}
	public void eatBanana() {
		this.energyLevel += 10;
		System.out.println("ohhhh Ba-na-na!");
	}
	public void climbStuff() {
		this.energyLevel -= 10;
		System.out.println("Watch out, a gorilla is climbing for a better fling angle!");
	}

}
