package virtualpetshelter;

public class RoboticCat extends Cat {
	private int oilLevel;
	private boolean isOiled = false;

	public RoboticCat(String name, int boredom, int health, int happiness, int oilLevel) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.boredom = boredom;
		this.health = health;
		this.happiness = happiness;
		this.oilLevel = oilLevel;
	}

	public RoboticCat(String name, String description) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.description = description;
		this.boredom = statboredom.nextInt(statmax - statmin) + statmin;
		this.health = stathealth.nextInt(statMaxHealth - statMinHealth) + statMinHealth;
		this.happiness = stathealth.nextInt(statMaxHealth - statMinHealth) + statMinHealth;
	}

	public int getHappiness() {
		// TODO Auto-generated method stub
		return happiness;
	}

	@Override
	public void oilRobot() {
		// TODO Auto-generated method stub
		happiness += 5;
		oilLevel -= 5;
		isOiled = true;
	}

	@Override
	public int getOilLevel() {
		// TODO Auto-generated method stub
		return oilLevel;
	}

	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	public void healthEffect() {
		// TODO Auto-generated method stub
		if (oilLevel <= 50) {
			health -= 10;
		}

		if (50 >= boredom && boredom >= 45) {
			health -= 5;
		}
	}

	@Override
	public void happinessEffect() {
		// TODO Auto-generated method stub
		if (health <= 80) {
			happiness -= 10;
		}
		if (50 >= boredom && boredom >= 45) {
			health -= 5;
		}
	}

	@Override
	public boolean isOiled() {
		return isOiled;
	}

	@Override
	public void chargePet(int amountToCharge) {
		health += amountToCharge;

	}

	@Override
	public void tickEffect() {
		// TODO Auto-generated method stub
		health -= 5;
		happiness -= 5;
		boredom += 2;
		healthEffect();
		happinessEffect();
	}
}
