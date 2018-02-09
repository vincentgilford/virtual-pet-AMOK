package virtualpetshelter;

import java.util.Random;

public class VirtualPet {

	private String name;
	private int hunger;
	private int boredom;
	private int waste;
	private int thirst;
	private String overallStatus;
	private String description;
	private Random stathunger = new Random();
	private Random statthirst = new Random();
	private Random statboredom = new Random();
	private Random statwaste = new Random();
	private int statmin = 30;
	private int statmax = 35;

	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		this.hunger = stathunger.nextInt(statmax - statmin) + statmin;
		this.thirst = statthirst.nextInt(statmax - statmin) + statmin;
		this.waste = statwaste.nextInt(statmax - statmin) + statmin;
		this.boredom = statboredom.nextInt(statmax - statmin) + statmin;
	}

	public VirtualPet(String name, int hunger, int boredom, int waste, int thirst) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.hunger = hunger;
		this.boredom = boredom;
		this.waste = waste;
		this.thirst = thirst;

	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public int getHunger() {
		// TODO Auto-generated method stub
		return hunger;
	}

	public void feedPet(int amountToFeed) {
		// TODO Auto-generated method stub
		hunger -= amountToFeed;
	}

	public void waterPet(int amountToDrink) {
		// TODO Auto-generated method stub
		thirst -= amountToDrink;
	}

	public String getPetStatus() {
		// TODO Auto-generated method stub
		if ((hunger <= 50 && hunger > 45) && (thirst <= 50 && thirst > 45) && (waste <= 50 && waste > 45)
				&& (boredom <= 50 && boredom > 45)) {
			overallStatus = getName() + " is not doing well!";
		} else if ((hunger <= 45 && hunger > 40) && (thirst <= 45 && thirst > 40) && (waste <= 45 && waste > 40)
				&& (boredom <= 45 && boredom >= 40)) {
			overallStatus = getName() + " is ok but needs more care. Please take notice ";
		} else if ((hunger <= 40 && hunger > 35) && (thirst <= 40 && thirst > 35) && (waste <= 40 && waste > 35)
				&& (boredom <= 40 && boredom >= 35)) {
			overallStatus = getName() + " is doing well. Keep up the good work!";
		} else if ((hunger <= 35) && (thirst <= 35) && (waste <= 35) && (boredom <= 35)) {
			overallStatus = getName() + " is doing amazing!!!";
		} else {
			overallStatus = getName() + " please take notice your pet is in grave danger!";
		}

		return overallStatus; // may put the logic of status in another method
	}

	public void petPlayBoredom(int amountPlay) {
		// TODO Auto-generated method stub
		boredom -= amountPlay;
	}

	public int getBoredom() {
		// TODO Auto-generated method stub
		return boredom;
	}

	public int getThirst() {
		// TODO Auto-generated method stub
		return thirst;
	}

	public int getWaste() {
		// TODO Auto-generated method stub
		return waste;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public void tickEffect() {
		// TODO Auto-generated method stub
		hunger += 2;
		thirst += 2;
		boredom += 2;
		waste += 2;

	}

	public void wasteRemoval(int wasteAmount) {
		// TODO Auto-generated method stub
		waste -= wasteAmount;
	}

}
