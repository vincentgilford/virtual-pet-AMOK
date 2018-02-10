package virtualpetshelter;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class RoboticCatTest {
	private static final int boredom = 30;
	private static final String name = "Kitty";
	private static final String description = "Guardian of underworld robots";
	private static final int health = 80;
	private static final int happiness = 60;
	private static final int oilLevel = 50;
	
	private RoboticCat underTest;
	private RoboticCat underTestName; 
	
	
	@Before
	public void setup() {
		underTest = new RoboticCat (name, boredom, health, happiness, oilLevel);
		underTestName = new RoboticCat (name,description);
	}
	
	@Test
	public void oilRoboticCat() {
		int happinessBefore = underTest.getHappiness();
		underTest.oilRobot(); 
		int happinessAfter = underTest.getHappiness();
		int check = 5; 
		assertThat(check, is(happinessAfter-happinessBefore));
	}
	
	
	@Test
	public void oilEffectONOilLevels() {
		int oilBefore = underTest.getOilLevel();
		underTest.oilRobot();
		int oilAFter = underTest.getOilLevel();
		int check = 5; 
		
		assertThat(check, is(oilBefore-oilAFter));		
	}
	
	@Test
	public void robotHealthEffect() {
		int beforeHealth = underTest.getHealth();
		underTest.healthEffect();
		int afterHealth =underTest.getHealth();
		
		int check = 10; 
		assertThat(check, is(beforeHealth-afterHealth));
	}
	
	@Test
	public void robotHappinessEffect() {
		int happinessBefore = underTest.getHappiness(); 
		underTest.happinessEffect();
		int happinessAfter = underTest.getHappiness();
		
		int check = 10; 
		assertThat(check, is(happinessBefore-happinessAfter));
	}
	
}
