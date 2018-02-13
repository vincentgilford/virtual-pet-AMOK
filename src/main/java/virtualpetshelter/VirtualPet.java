package virtualpetshelter;

import java.util.Random;

public abstract class VirtualPet {

	// VirtualPet only
	protected String name;
	protected String description;
	protected int boredom;
	protected int health;// batt life for Robotic Animals
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

	abstract public void healthEffect();

	abstract public void happinessEffect();

	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}

	abstract public int getBoredom();

	abstract public int getHealth();

}