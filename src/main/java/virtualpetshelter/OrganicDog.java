package virtualpetshelter;

import java.util.Random;

public class OrganicDog extends Dog implements Walkable {
	protected int hunger;
	protected int waste;
	protected int thirst;
	
	protected Random stathunger = new Random();
	protected Random statthirst = new Random();
	protected Random statboredom = new Random();
	protected Random statwaste = new Random();
	protected Random stathealth = new Random();
	protected Random stathappiness = new Random();

	protected int cageWasteLevel = 0;
	protected int statmin = 30;
	protected int statmax = 35;
	protected int statMaxHealth = 100;
	protected int statMinHealth = 80;
	
	
	public OrganicDog(String name, int hunger, int boredom, int waste, int thirst, int health, int happiness) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.hunger = hunger;
		this.boredom = boredom;
		this.waste = waste;
		this.thirst = thirst;
		this.health = health;
		this.happiness = happiness;
	}

	public OrganicDog(String name, String description) {
		this.name = name;
		this.description = description;
		this.hunger = stathunger.nextInt(statmax - statmin) + statmin;
		this.thirst = statthirst.nextInt(statmax - statmin) + statmin;
		this.waste = statwaste.nextInt(statmax - statmin) + statmin;
		this.boredom = statboredom.nextInt(statmax - statmin) + statmin;
		this.health = stathealth.nextInt(statMaxHealth - statMinHealth) + statMinHealth;
		this.happiness = stathealth.nextInt(statMaxHealth - statMinHealth) + statMinHealth;
	}
	@Override
	public int getHunger() {
		// TODO Auto-generated method stub
		return hunger;
	}
	
	@Override
	public int getThirst() {
		// TODO Auto-generated method stub
		return thirst;
	}

	@Override
	public void wasteRemoval(int wasteAmount) {
		// TODO Auto-generated method stub
		waste -= wasteAmount;
		cageWasteLevel += wasteAmount;
	}
	
	@Override
	public int getWaste() {
		// TODO Auto-generated method stub
		return waste;
	}

	@Override
	public void feedOrganicPet(int amountToFeed) {
		// TODO Auto-generated method stub
		hunger -= amountToFeed;
	}

	@Override
	public void waterPet(int amountToDrink) {
		// TODO Auto-generated method stub
		thirst -= amountToDrink;
	}

	@Override
	public void happinessEffect() {
		// TODO Auto-generated method stub
		if ((50 >= hunger && hunger >= 45) || (50 >= thirst && thirst >= 45)) {
			happiness -= 5;
		}

		if ((50 >= boredom && boredom >= 45) || (50 >= waste && waste >= 45)) {
			happiness -= 2;
		}

		if ((40 >= hunger && hunger >= 35) || (40 >= thirst && thirst >= 35)) {
			happiness += 5;
		}

		if ((40 >= boredom && boredom >= 35) || (40 >= thirst && thirst >= 35)) {
			happiness += 2;
		}

		if (health < 50) {
			happiness -= 10;
		}

	}

	@Override
	public void walkPet() {
		// TODO Auto-generated method stub
		happiness += 5;
		waste -= 6;
		isWalking = true;
	}

	@Override
	public void healthEffect() {
		// TODO Auto-generated method stub
		if (hunger >= 45) {
			health -= 2;
		}

		if (thirst >= 45) {
			health -= 2;
		}

		if (boredom >= 45) {
			health -= 2;
		}

		if (waste >= 45) {
			health -= 5;
		}
	}

	@Override
	public boolean isWalking() {
		// TODO Auto-generated method stub
		return isWalking;
	}

	

	
	@Override
	public void tickEffect() {
		// TODO Auto-generated method stub
		healthEffect();
		happinessEffect();
		cageEffect();
		hunger += 5;
		thirst += 5;
		boredom += 5;
		waste += 5;
		System.out.println(getName() + " waste level is " + getWaste());
		
	}

	@Override
	public int getCageLevel() {
		return cageWasteLevel;
	}

	@Override
	public void cageEffect() {
		// TODO Auto-generated method stub
		if(waste >= 30) {
			cageWasteLevel += 10; 
		} else if (waste > 60) {
			cageWasteLevel +=20;
		} else {
			System.out.println("Cage is relatively clean...");
		}
	}
	
	@Override 
	public void cleanCage() {
		// TODO Auto-generated method stub
		cageWasteLevel -= 5; 
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() + "\tDescription: " + getDescription() + "\tHealth: " +
	getHealth() + "\tWalked: " + isWalking + "\tHunger: " + getHunger() + "\tThirst: " + getThirst() + "\tWaste: " + getWaste() 
	+ "\tBordom: " + getBoredom() + "\tHappiness: " + getHappiness();
	
	}
	
}
