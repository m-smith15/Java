package zookeeper1;

public class Giantbat extends Mammal {
	//constructor
		public Giantbat(String mammalName) {
			super(mammalName);
			this.energyLevel = 300;
		}
		
		//methods
		public void eatHumie() {
			this.energyLevel += 25;
			System.out.println("Well I didn't like them anyway..");
		}
		public void fly() {
			this.energyLevel -= 50;
			System.out.println("Was that a helicopter taking off or the giant bat?? \n Well we don't have a helicopter so...");
		}
		public void attackTown() {
			this.energyLevel -= 100;
			System.out.println("Mind turning the music up? I can hear screams from the town over still...");
		}
}
