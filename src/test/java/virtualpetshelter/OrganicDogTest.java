package virtualpetshelter;

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
	
	private OrganicDog underTest; 
	
	
	@Before
	public void setup() {
		
		underTest = new OrganicDog(name, hunger, boredome, waste, thirst);

		
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
		
		
	}
	
	
	
}
