package virtualpetshelter;

public abstract class Dog extends VirtualPet{

	protected boolean isWalking = false;

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
