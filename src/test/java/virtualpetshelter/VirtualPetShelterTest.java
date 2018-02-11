package virtualpetshelter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.contains;

import org.junit.Before;

import static org.hamcrest.Matchers.is;
import org.junit.Test;


public class VirtualPetShelterTest {
	private static final int hunger = 50;
	private static final int thirst = 50;
	private static final int boredome = 30;
	private static final int waste = 30;
	private static final String dogName = "Fido";
	private static final String catName = "Kitty";
	private static final String orgCatName = "RobotKitty";
	private static final int health = 100;
	private static final int happiness = 60;
	private static final int oilLevel = 50;
	private static final String dogRobotName = "Astro";
	private VirtualPetShelter underTest; 
	private OrganicDog organicDog;
	private RoboticCat roboticCat;
	private RoboticDog roboticDog;
	private OrganicCat organicCat;
	
	
	@Before
	public void setup() {
		
		underTest = new VirtualPetShelter();
		organicDog = new OrganicDog (dogName, hunger, boredome, waste, thirst, health, happiness);
		roboticCat = new RoboticCat (catName, boredome, health, happiness, oilLevel);  
		roboticDog = new RoboticDog (dogRobotName, boredome, health, happiness, oilLevel);
		organicCat = new OrganicCat (orgCatName, hunger, boredome, waste, thirst, health, happiness);
	}
	
	@Test
	public void addVirtualPetToShelter() {
		
		
		underTest.addPet(organicDog);
		Collection<VirtualPet> check = underTest.getAllPets();
		
		assertThat(check, contains(organicDog));
	}

	@Test
	public void addTwoVirtualPetToShelter() {  
		OrganicDog  organicDog = new OrganicDog (dogName, hunger, boredome, waste, thirst, health, happiness);
		RoboticCat roboticCat = new RoboticCat (catName, boredome, health, happiness, oilLevel);
		
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);

		Collection<VirtualPet> check = underTest.getAllPets();
		
		assertThat(check, containsInAnyOrder(roboticCat,organicDog));
	}
	
	@Test
	public void isAbleToFeedPet() {
		underTest.addPet(organicDog);
		underTest.feedPetShelter(dogName, 10);
		OrganicDog pet = (OrganicDog) underTest.findPet(dogName);
		int check = pet.getHunger();
		
		assertThat(40, is(check));
	}
	
	
	@Test
	public void isAbledAdoptPet() {
		underTest.addPet(organicDog);

		
		underTest.adoptPet(organicDog);
		int retrieved = 0; 
		assertEquals(retrieved, underTest.shelterSize());
	}
	
	@Test
	public void isAbleToWater() {
		underTest.addPet(organicDog);
		
		underTest.waterPetShelter(dogName, 10);
		OrganicDog pet = (OrganicDog) underTest.findPet(dogName);
		
		assertThat(40, is(pet.getThirst()));
	}
	
	@Test
	public void isAbleToRemoveWaste() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		
		underTest.cleanPetShelter(dogName, 10);
		OrganicDog pet = (OrganicDog) underTest.findPet(dogName);
		assertThat(20, is(pet.getWaste()));
	}
	
	@Test
	public void isAbleToPlay() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		
		underTest.petShelterPlay(dogRobotName, 10);
		RoboticDog pet = (RoboticDog) underTest.findPet(dogRobotName);
		
		assertThat(20,is(pet.getBoredom()));
	}
	
	@Test
	public void isAbleToFeedAllOrganic() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);
	
		underTest.feedAllPets();
		
		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);
		
		assertThat(40 , is(oDog.getHunger()));
		assertThat(40, is(oCat.getHunger()));
		
	}
	
	@Test
	public void waterAllOrganicPets() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);
	
		underTest.waterAllPets();
		
		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);
		
		assertThat(40 , is(oDog.getThirst()));
		assertThat(40, is(oCat.getThirst()));
	}
	
	@Test
	public void removeOrganicWaste() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);
	
		underTest.organicWasteRemove()
		
		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);
		
		assertThat(40 , is(oDog.getWaste()));
		assertThat(40, is(oCat.getWaste()));
		
		
		
	}
	
	
	
	
	
//	@Test//robot test
//	public void oilRoboticPet() {
//		underTest.addPet(organicDog);
//		underTest.addPet(roboticCat);
//		underTest.addPet(roboticDog);
//		
//		
//	}
	
	
	
	
	
}
//	private static final int hunger = 50;
//	private static final int thirst = 50;
//	private static final int boredome = 30;
//	private static final int waste = 30;
//	private static final String petName = "Scrappy";
//
//	private VirtualPetShelter underTest;
//
//	private VirtualPet puppy;
//
//	@Before
//	public void setup() {
//		// arrange
//		underTest = new VirtualPetShelter();
//
//		puppy = new VirtualPet(petName, hunger, boredome, waste, thirst);
//
//	}
//
//	@Test
//	public void virtualPetShelterShouldAddPet() {
//		// arrange
//
//		// act
//		underTest.addPet(puppy);
//
//		// assert
//		VirtualPet retrieved = underTest.findPet(puppy);
//		assertThat(retrieved, is(underTest.findPet(puppy)));
//
//	}
//
//	@Test
//	public void isAbleToAdoptPet() {
//		// act
//		underTest.adoptPet(puppy);
//
//		// assert
//		int retrieved = 0;
//		assertEquals(retrieved, underTest.shelterSize());
//		// **better way to check numbers using ham?**
//	}
//
//	@Test
//	public void isAbleToFeedPet() {
//		underTest.addPet(puppy);
//
//		// act
//		underTest.feedPetShelter(puppy.getName(), 10);
//		// assert
//		int check = 40;
//		assertThat(check, is(puppy.getHunger()));
//
//	}
//
//	@Test
//	public void isAbleToWater() {
//		underTest.addPet(puppy);
//
//		// act
//		underTest.waterPetShelter(puppy.getName(), 10);
//
//		// assert
//		int check = 40;
//		assertThat(check, is(puppy.getThirst()));
//
//	}
//
//	@Test
//	public void isAssertStatusOfPet() {
//		underTest.addPet(puppy);
//
//		// act
//		underTest.petShelterStatus(puppy.getName());
//
//		// assert
//		VirtualPet retrieved = underTest.findPet(puppy);
//		retrieved.getPetStatus();
//
//		// assertThat(check , is(underTest.petShelterStatus(puppy.getName()));
//		assertEquals(retrieved.getPetStatus(), underTest.petShelterStatus(puppy.getName()));
//	}
//
//	@Test
//	public void isAssertStatusOfPetMatchStringMessageUseBooleanAssertTrue() {
//		underTest.addPet(puppy);
//
//		// act
//		underTest.petShelterStatus(puppy.getName());
//
//		// assert
//		VirtualPet retrieved = underTest.findPet(puppy);
//		retrieved.getPetStatus();
//		String check = retrieved.getPetStatus();
//		// assertEquals(retrieved.getPetStatus(),
//		// underTest.petShelterStatus(puppy.getName()));
//		assertTrue(check.equalsIgnoreCase(underTest.petShelterStatus(puppy.getName())));
//
//	} // which way is better?
//
//	@Test
//	public void assertThatPetPlayReducesBoredom() {
//		// assert
//		underTest.addPet(puppy);
//		// act
//		underTest.petShelterPlay(puppy.getName(), 10);
//
//		// assert
//		VirtualPet retrieved = underTest.findPet(puppy);
//		retrieved.getBoredom();
//		int check = 20;
//		assertEquals(check, retrieved.getBoredom());
//
//	}
//
//	@Test
//	public void getIndividualHungerStatusFromShelter() {
//		// assert
//		underTest.addPet(puppy);
//		// act
//		underTest.petShelterHunger(puppy.getName());
//		underTest.petShelterThirst(puppy.getName());
//		underTest.petShelterBoredom(puppy.getName());
//		underTest.petShelterThirst(puppy.getName());
//		underTest.petShelterWaste(puppy.getName());
//
//		// act
//		VirtualPet retrieved = underTest.findPet(puppy);
//		retrieved.getBoredom();
//		retrieved.getHunger();
//		retrieved.getThirst();
//		retrieved.getWaste();
//
//		// assert
//		assertEquals(retrieved.getBoredom(), underTest.petShelterBoredom(puppy.getName()));
//		assertEquals(retrieved.getHunger(), underTest.petShelterHunger(puppy.getName()));
//		assertEquals(retrieved.getThirst(), underTest.petShelterThirst(puppy.getName()));
//		assertEquals(retrieved.getWaste(), underTest.petShelterWaste(puppy.getName()));
//	}
//
//	@Test
//	public void assertdescriptionPetStatus() {
//		// assert
//		underTest.addPet(puppy);
//
//		// act
//		underTest.petShelterDescription(puppy.getName());
//
//		// assert
//		VirtualPet retrieved = underTest.findPet(puppy);
//		retrieved.getDescription();
//
//		assertEquals(retrieved.getDescription(), underTest.petShelterDescription(puppy.getName()));
//	}
//
//	@Test
//	public void assertAcollectionIsReturned() {
//		underTest.addPet(puppy);
//
//		// act
//		underTest.petShelterCollection();
//
//		// assert
//		Collection<VirtualPet> retrieved = underTest.petShelterCollection();
//		assertEquals(retrieved, underTest.petShelterCollection());
//
//	}
//
//	@Test
//	public void assertFucntionOfTickMethod() {
//		underTest.addPet(puppy);
//
//		// act
//		underTest.tickCycle();
//		VirtualPet retrieved = underTest.findPet(puppy);
//		retrieved.getHunger();
//		int check = 52;
//
//		// assert
//		assertEquals(check, retrieved.getHunger());
//	}
//
//	@Test
//	public void assertFunctionOFTickMethodTwoObjects() {
//		underTest.addPet(puppy);
//		VirtualPet retrieved = new VirtualPet("Scooby-Doo", 48, boredome, waste, thirst);
//		underTest.addPet(retrieved);
//
//		// act
//		underTest.tickCycle();
//		VirtualPet petTest = underTest.findPet(puppy);
//		VirtualPet petRetrieved = underTest.findPet(retrieved);
//
//		// assert
//		int check = 52;
//		int checkRetrieved = 50;
//
//		assertEquals(check, petTest.getHunger());
//		assertEquals(checkRetrieved, petRetrieved.getHunger());
//
//	}
//
//	@Test
//	public void assertRandomStatFucntion() {
//		VirtualPet retrieved = new VirtualPet("Scooby", "Always hungry");
//		VirtualPet petObjectCheck = new VirtualPet("Toto", "Portal Access");
//
//		System.out.println(retrieved.getHunger());
//		System.out.println(petObjectCheck.getHunger());
//
//	}
//
//	@Test
//	public void assertThatWasteRemovedFromPet() {
//		underTest.addPet(puppy);
//
//		// act
//		underTest.cleanPetShelter(puppy.getName(), 5);
//		VirtualPet retrieved = underTest.findPet(puppy);
//		int check = 25;
//		// assert
//		assertEquals(check, retrieved.getWaste());
//
//	}
//
//}
