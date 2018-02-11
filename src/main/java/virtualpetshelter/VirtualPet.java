package virtualpetshelter;

import java.util.Random;

public abstract class VirtualPet {

	protected String name;
	protected String description;
	protected int health;
	protected int happiness;
	protected String overallStatus;
	protected int boredom;
	protected int hunger;
	protected int waste;
	protected int thirst;

	// public VirtualPet(String name, String description) {
	// this.name = name;
	// this.description = description;
	// this.hunger = stathunger.nextInt(statmax - statmin) + statmin;
	// this.thirst = statthirst.nextInt(statmax - statmin) + statmin;
	// this.waste = statwaste.nextInt(statmax - statmin) + statmin;
	// this.boredom = statboredom.nextInt(statmax - statmin) + statmin;
	// }

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	// may delete
	public String getPetStatus() {
		// // TODO Auto-generated method stub
		// if ((hunger <= 50 && hunger > 45) && (thirst <= 50 && thirst > 45) && (waste
		// <= 50 && waste > 45)
		// && (boredom <= 50 && boredom > 45)) {
		// overallStatus = getName() + " is not doing well!";
		// } else if ((hunger <= 45 && hunger > 40) && (thirst <= 45 && thirst > 40) &&
		// (waste <= 45 && waste > 40)
		// && (boredom <= 45 && boredom >= 40)) {
		// overallStatus = getName() + " is ok but needs more care. Please take notice
		// ";
		// } else if ((hunger <= 40 && hunger > 35) && (thirst <= 40 && thirst > 35) &&
		// (waste <= 40 && waste > 35)
		// && (boredom <= 40 && boredom >= 35)) {
		// overallStatus = getName() + " is doing well. Keep up the good work!";
		// } else if ((hunger <= 35) && (thirst <= 35) && (waste <= 35) && (boredom <=
		// 35)) {
		// overallStatus = getName() + " is doing amazing!!!";
		// } else {
		// overallStatus = getName() + " please take notice your pet is in grave
		// danger!";
		// }
		//
		return "";// overallStatus; // may put the logic of status in another method
	}

	public void petPlayBoredom(int amountPlay) {
		// TODO Auto-generated method stub
		boredom -= amountPlay;
	}

	abstract public void tickEffect();
	// TODO Auto-generated method stub

	public void feedOrganicPet(int amountToFeed) {

	}

	public void waterPet(int amountToDrink) {

	}

	public void walkPet() {

	}

	abstract public void healthEffect();

	abstract public void happinessEffect();

	public void wasteRemoval(int amountToRemove) {

	}

	public int getThirst() {
		return thirst;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public int getHunger() {
		return hunger;
	}

	public int getWaste() {
		return waste;

	}

	abstract public int getBoredom();

	abstract public int getHealth();

	public void oilRobot() {
	}

	public int getOilLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isOiled() {
		// TODO Auto-generated method stub
		return false;
	}

	public void chargePet(int amountToCharge) {

	}

	
	public int getCageLevel() {
		return 0;
	}
	
	public void cageEffect() {
	}
	public void cleanCage() {
		// TODO Auto-generated method stub
	 
	}

}