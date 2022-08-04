package zookeeper1;

public class gorilla_test {

	public static void main(String[] args){
		Gorilla shrimpbo = new Gorilla("Shrimpbo");
		System.out.println(shrimpbo.name);
		shrimpbo.displayEnergy();
		
		shrimpbo.flingThing(); // - 5
		shrimpbo.flingThing(); // - 5
		shrimpbo.flingThing(); // - 5 
		shrimpbo.displayEnergy(); // expect 85
		
		shrimpbo.eatBanana(); // + 10
		shrimpbo.eatBanana(); // + 10
		shrimpbo.displayEnergy(); // expect 105
		
		shrimpbo.climbStuff(); // - 10
		shrimpbo.displayEnergy(); // expect 95
	}
}
