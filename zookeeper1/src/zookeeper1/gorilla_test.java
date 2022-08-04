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
		
		
		Giantbat shrimpflap = new Giantbat("Shrimpflap");
		System.out.println(shrimpflap.name);
		shrimpflap.displayEnergy(); //default should be 300
		
		shrimpflap.attackTown(); // - 100
		shrimpflap.displayEnergy(); // 200
		shrimpflap.attackTown(); // - 100
		shrimpflap.displayEnergy(); // 100
		shrimpflap.attackTown(); // -100
		shrimpflap.displayEnergy(); // 0
		
		shrimpflap.eatHumie(); // +25
		shrimpflap.displayEnergy(); // 25
		shrimpflap.eatHumie(); // +25
		shrimpflap.displayEnergy(); // 50
		
		shrimpflap.fly(); // - 50
		shrimpflap.displayEnergy(); // 0
		shrimpflap.fly(); // - 50
		shrimpflap.displayEnergy(); // -50
	}
}
