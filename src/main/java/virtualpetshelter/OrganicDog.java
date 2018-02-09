package virtualpetshelter;

import java.util.Random;

public class OrganicDog extends Dog {
	protected Random stathunger = new Random();
	protected Random statthirst = new Random();
	protected Random statboredom = new Random();
	protected Random statwaste = new Random();
	protected int statmin = 30;
	protected int statmax = 35;
	
//	public OrganicDog (String name, String description) {
//		this.name = name;
//		this.description = description;
//		this.hunger = stathunger.nextInt(statmax - statmin) + statmin;
//		this.thirst = statthirst.nextInt(statmax - statmin) + statmin;
//		this.waste = statwaste.nextInt(statmax - statmin) + statmin;
//		this.boredom = statboredom.nextInt(statmax - statmin) + statmin;
//	}
	
	
	public OrganicDog(String name, int hunger, int boredom, int waste, int thirst) {
	// TODO Auto-generated constructor stub
	this.name = name;
	this.hunger = hunger;
	this.boredom = boredom;
	this.waste = waste;
	this.thirst = thirst;
	}
	
	public void feedPet(int amountToFeed) {
		// TODO Auto-generated method stub
		hunger -= amountToFeed;
	}
	
	public void waterPet(int amountToDrink) {
		// TODO Auto-generated method stub
		thirst -= amountToDrink;
	}
}