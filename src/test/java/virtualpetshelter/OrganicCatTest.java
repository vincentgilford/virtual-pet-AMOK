package virtualpetshelter;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.hamcrest.Matchers.is;
import org.junit.Test;

public class OrganicCatTest {
	private static final int hunger = 50;
	private static final int thirst = 50;
	private static final int boredome = 30;
	private static final int waste = 30;
	private static final String name = "Kitty";
	private static final String description = "Guardian of underworld";
	private static final int health = 100;
	private static final int happiness = 60;
	private OrganicCat underTest; 
	private OrganicCat underTestName;
	
	@Before
	public void setup() {
		
		underTest = new OrganicCat(name, hunger, boredome, waste, thirst, health, happiness);
		underTestName = new OrganicCat(name, description); 
	}
	
	@Test
	public void isOragnicCat() {
		
		assertTrue(underTest instanceof OrganicCat);
	}
	
	@Test
	public void isCat() {
		
		assertTrue(underTest instanceof Cat);	
	}
	
	@Test
	public void assertThatIsFedCat() {
		int beforeHunger= underTest.getHunger(); 
		underTest.feedPet(10); 
		int afterHunger = underTest.getHunger(); 
		int check = 10;
		assertThat(check, is(beforeHunger-afterHunger));
	}
	
	@Test
	public void waterOrganicCat() {
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
	public void bordomChangedCat() {
		int boredomBefore = underTest.getBoredom();
		underTest.petPlayBoredom(10);
		int boredomAfter = underTest.getBoredom();
		int check = 10;
		
		assertThat(check, is(boredomBefore-boredomAfter));
	}
	
	@Test
	public void catHealthEffect() {
		int healthBefore = underTest.getHealth(); 
		underTest.healthEffect();
		int healthAfter = underTest.getHealth();
		int check =  healthBefore-healthAfter;
		assertThat(4, is(check));
	}
	
	@Test
	public void organicDogHappiness() {
		int happinessBefore = underTest.getHappiness();
		underTest.happinessEffect();
		int happinessAfter = underTest.getHappiness();
		
		assertNotEquals(happinessBefore, happinessAfter);
	}
	
}
