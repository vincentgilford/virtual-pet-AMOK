package virtualpetshelter;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.hamcrest.Matchers.is;
import org.junit.Test;



public class OrganicDogTest {
	private static final int hunger = 50;
	private static final int thirst = 50;
	private static final int boredome = 30;
	private static final int waste = 30;
	private static final String name = "Fido";
	private static final int health = 100;
	private static final int happiness = 60;
	private OrganicDog underTest; 
	
	
	@Before
	public void setup() {
		
		underTest = new OrganicDog(name, hunger, boredome, waste, thirst, health, happiness);

		
	}
	
	
	@Test
	public void isOrganicDog() {
		
		
		assertTrue(underTest instanceof OrganicDog);
		
	}
	
	@Test
	public void isDog() {
		
		
		assertTrue(underTest instanceof Dog);	
	}
	
	@Test
	public void assertThatDogHasStats() {
		
		underTest.getHunger();
		
		assertTrue(underTest.getHunger() > 0);
	}
	
	@Test
	public void assertThatgetHunger() {
		
		int beforeHunger = underTest.getHunger();
		underTest.feedPet(5);
		int afterHunger = underTest.getHunger(); 
		int check = afterHunger-beforeHunger;
		assertThat(check, is(afterHunger-beforeHunger));
	}
	
	@Test
	public void waterOrganicDog() {
		
		int beforeThirst = underTest.getThirst();
		underTest.waterPet(10);
		int afterThirst = underTest.getThirst();
		int check = 10; 
		
		assertThat(check, is(beforeThirst-afterThirst));	
	}
	
	@Test
	public void wasteRemovalOfWaster() {
		int wasteBefore = underTest.getWaste();
		underTest.wasteRemoval(10);
		int wasteAfter = underTest.getWaste();
		int check = 10;
		
		assertThat(check, is(wasteBefore-wasteAfter));
	}
	
	@Test
	public void bordomChangedDog() {
		int boredomBefore = underTest.getBoredom();
		underTest.petPlayBoredom(10);
		int boredomAfter = underTest.getBoredom();
		int check = 10;
		
		assertThat(check, is(boredomBefore-boredomAfter));
	}
	
	@Test
	public void dogHealthEffect() {
		int healthBefore = underTest.getHealth(); 
		underTest.healthEffect();
		int healthAfter = underTest.getHealth();
		
		
		assertThat(4, is(healthBefore-healthAfter));
		 
	}
	
	@Test
	public void organicDogHappiness() {
		int happinessBefore = underTest.getHappiness();
		underTest.happinessEffect();
		int happinessAfter = underTest.getHappiness();
		
		assertNotEquals(happinessBefore, happinessAfter);
		
	}
	
	@Test
	public void organicDogWalk() {
		int happinessBefore = underTest.getHappiness();
		underTest.walkPet();
		int happinessAFter = underTest.getHappiness();
		assertNotEquals(happinessAFter, happinessBefore);
	}
	
	@Test
	public void playWithPet() {
		int beforeBoredom = underTest.getBoredom();
		underTest.petPlayBoredom(10);
		int afterBoredom = underTest.getBoredom();
		
		int check = 10;
		
		
		assertThat(check, is(beforeBoredom-afterBoredom));
		
	}
	
	
	
	
}
