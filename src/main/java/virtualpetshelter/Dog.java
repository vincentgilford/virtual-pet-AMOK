package virtualpetshelter;

import java.util.Random;


public abstract class Dog extends VirtualPet{
	
	protected boolean isWalking = false;
	protected Random statboredom = new Random();
	protected Random stathealth = new Random();
	protected Random stathappiness = new Random();
	
	protected int statmin = 30;
	protected int statmax = 35;
	protected int statMaxHealth = 100;
	protected int statMinHealth = 80;

	public int getBoredom() {
		// TODO Auto-generated method stub
		return boredom;
	}

	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	public abstract void healthEffect();

	public abstract void happinessEffect();
		

	public int getHappiness() {
		// TODO Auto-generated method stub
		return happiness;
	}

	public abstract void walkPet();

	 
	

}
