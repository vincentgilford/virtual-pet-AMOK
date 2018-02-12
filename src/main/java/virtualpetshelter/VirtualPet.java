package virtualpetshelter;

import java.util.Random;

public abstract class VirtualPet {
	
	//VirtualPet only
	protected String name;
	protected String description;
	protected int boredom;
	protected int health;//batt life for Robotic Animals
	protected int happiness;
	

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	// may delete


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
		return 0;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	public int getHunger() {
		return 0;
	}

	public int getWaste() {
		return 0;

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