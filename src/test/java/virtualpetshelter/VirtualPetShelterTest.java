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
	private static final int health = 90;
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
		organicDog = new OrganicDog(dogName, hunger, boredome, waste, thirst, health, happiness);
		roboticCat = new RoboticCat(catName, boredome, health, happiness, oilLevel);
		roboticDog = new RoboticDog(dogRobotName, boredome, health, happiness, oilLevel);
		organicCat = new OrganicCat(orgCatName, hunger, boredome, waste, thirst, health, happiness);
	}

	@Test
	public void addVirtualPetToShelter() {

		underTest.addPet(organicDog);
		Collection<VirtualPet> check = underTest.getAllPets();

		assertThat(check, contains(organicDog));
	}

	@Test
	public void addTwoVirtualPetToShelter() {
		OrganicDog organicDog = new OrganicDog(dogName, hunger, boredome, waste, thirst, health, happiness);
		RoboticCat roboticCat = new RoboticCat(catName, boredome, health, happiness, oilLevel);

		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);

		Collection<VirtualPet> check = underTest.getAllPets();

		assertThat(check, containsInAnyOrder(roboticCat, organicDog));
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

		assertThat(20, is(pet.getBoredom()));
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

		assertThat(40, is(oDog.getHunger()));
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

		assertThat(40, is(oDog.getThirst()));
		assertThat(40, is(oCat.getThirst()));
	}

	@Test
	public void removeOrganicWaste() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);

		underTest.organicWasteRemove();
		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);

		assertThat(20, is(oDog.getWaste()));
		assertThat(20, is(oCat.getWaste()));
	}

	@Test
	public void cleanLitterBox() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);

		underTest.organicWasteRemove();
		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);

		int check = underTest.getLitterBox();

		assertThat(10, is(check));
	}

	@Test
	public void checkDogCageLevel() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);
		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);
		int levelBefore = oDog.getCageLevel();
		underTest.organicWasteRemove();
		int levelAfter = oDog.getCageLevel();
		int check = 10;

		assertThat(check, is(levelAfter - levelBefore));
	}

	@Test
	public void assertThatAllPetsArePlayed() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);
		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);

		int checkOcatbefore = oCat.getBoredom();
		int checkOdogbefore = oDog.getBoredom();
		underTest.playAll();
		int checkOcatAfter = oCat.getBoredom();
		int checkOdogAfter = oDog.getBoredom();

		assertThat(10, is(checkOcatbefore - checkOcatAfter));
		assertThat(10, is(checkOcatbefore - checkOdogAfter));
	}

	@Test
	public void assertThatDogsAreWalked() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);
		RoboticDog rDog = (RoboticDog) underTest.findPet(dogRobotName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);

		int robotCheckBefore = rDog.getHappiness();
		int organicCheckBefore = oDog.getHappiness();
		underTest.walkAllPets();
		int robotCheckAfter = rDog.getHappiness();
		int organicCheckAFter = oDog.getHappiness();

		assertThat(10, is(robotCheckAfter - robotCheckBefore));
		assertThat(5, is(organicCheckAFter - organicCheckBefore));
	}

	@Test
	public void assertTickMethodEffect() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);
		RoboticDog rDog = (RoboticDog) underTest.findPet(dogRobotName);
		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);
		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		RoboticCat rCat = (RoboticCat) underTest.findPet(catName);
		int checkrDogBefore = rDog.getHappiness();
		int checkrCatBefore = rCat.getHappiness();
		int checkoDogBefore = oDog.getHappiness();
		int checkoCatBefore = oCat.getHappiness();

		underTest.tickCycle();

		int checkrDogAfter = rDog.getHappiness();
		int checkrCatAfter = rCat.getHappiness();
		int checkoDogAfter = rDog.getHappiness();
		int checkoCatAfter = rDog.getHappiness();

		assertNotEquals(checkrDogBefore, checkrDogAfter);
		assertNotEquals(checkrCatBefore, checkrCatAfter);
		assertNotEquals(checkoDogBefore, checkoDogAfter);
		assertNotEquals(checkoCatBefore, checkoCatAfter);
	}

	@Test
	public void assertThatLitterBoxIsEmptied() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);

		OrganicCat oCat = (OrganicCat) underTest.findPet(orgCatName);
		underTest.organicWasteRemove();
		int checkBefore = underTest.getLitterBox();
		underTest.cleanLitterBox();
		int checkAFter = underTest.getLitterBox();
		int check = 10;
		assertThat(check, is(checkBefore - checkAFter));
	}

	@Test // robot test
	public void oilRoboticPet() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);

		RoboticDog rDog = (RoboticDog) underTest.findPet(dogRobotName);
		RoboticCat rCat = (RoboticCat) underTest.findPet(catName);

		int rDogOilCheckbefore = rDog.getOilLevel();
		int rCatOilCheckbefore = rCat.getOilLevel();
		underTest.oilAllPet();
		int rDogOilCheckafter = rDog.getOilLevel();
		int rCatOilCheckafter = rCat.getOilLevel();
		int checkRDog = 5;
		int checkRCat = 5;
		assertThat(checkRDog, is(rDogOilCheckbefore - rDogOilCheckafter));
		assertThat(checkRCat, is(rCatOilCheckbefore - rCatOilCheckafter));
	}

	@Test
	public void cleanDogCages() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);

		OrganicDog oDog = (OrganicDog) underTest.findPet(dogName);

		underTest.organicWasteRemove();
		int cageLevelBefore = oDog.getCageLevel();
		underTest.cleanCages();
		int cageLevelAFter = oDog.getCageLevel();
		int check = 5;
		assertThat(check, is(cageLevelBefore - cageLevelAFter));
	}

	@Test
	public void chargeAllRoboticPets() {
		underTest.addPet(organicDog);
		underTest.addPet(roboticCat);
		underTest.addPet(roboticDog);
		underTest.addPet(organicCat);

		RoboticDog rDog = (RoboticDog) underTest.findPet(dogRobotName);
		RoboticCat rCat = (RoboticCat) underTest.findPet(catName);
		int dogBattCheckBefore = rDog.getHealth();
		int catBattCheckBefore = rCat.getHealth();
		underTest.chargeRobots();
		int dogBattCheckAfter = rDog.getHealth();
		int catBattCheckAfter = rCat.getHealth();

		int check = 10;

		assertThat(check, is(dogBattCheckAfter - dogBattCheckBefore));
		assertThat(check, is(catBattCheckAfter - catBattCheckBefore));

	}

}
// private static final int hunger = 50;
// private static final int thirst = 50;
// private static final int boredome = 30;
// private static final int waste = 30;
// private static final String petName = "Scrappy";
//
// private VirtualPetShelter underTest;
//
// private VirtualPet puppy;
//
// @Before
// public void setup() {
// // arrange
// underTest = new VirtualPetShelter();
//
// puppy = new VirtualPet(petName, hunger, boredome, waste, thirst);
//
// }
//
// @Test
// public void virtualPetShelterShouldAddPet() {
// // arrange
//
// // act
// underTest.addPet(puppy);
//
// // assert
// VirtualPet retrieved = underTest.findPet(puppy);
// assertThat(retrieved, is(underTest.findPet(puppy)));
//
// }
//
// @Test
// public void isAbleToAdoptPet() {
// // act
// underTest.adoptPet(puppy);
//
// // assert
// int retrieved = 0;
// assertEquals(retrieved, underTest.shelterSize());
// // **better way to check numbers using ham?**
// }
//
// @Test
// public void isAbleToFeedPet() {
// underTest.addPet(puppy);
//
// // act
// underTest.feedPetShelter(puppy.getName(), 10);
// // assert
// int check = 40;
// assertThat(check, is(puppy.getHunger()));
//
// }
//
// @Test
// public void isAbleToWater() {
// underTest.addPet(puppy);
//
// // act
// underTest.waterPetShelter(puppy.getName(), 10);
//
// // assert
// int check = 40;
// assertThat(check, is(puppy.getThirst()));
//
// }
//
// @Test
// public void isAssertStatusOfPet() {
// underTest.addPet(puppy);
//
// // act
// underTest.petShelterStatus(puppy.getName());
//
// // assert
// VirtualPet retrieved = underTest.findPet(puppy);
// retrieved.getPetStatus();
//
// // assertThat(check , is(underTest.petShelterStatus(puppy.getName()));
// assertEquals(retrieved.getPetStatus(),
// underTest.petShelterStatus(puppy.getName()));
// }
//
// @Test
// public void isAssertStatusOfPetMatchStringMessageUseBooleanAssertTrue() {
// underTest.addPet(puppy);
//
// // act
// underTest.petShelterStatus(puppy.getName());
//
// // assert
// VirtualPet retrieved = underTest.findPet(puppy);
// retrieved.getPetStatus();
// String check = retrieved.getPetStatus();
// // assertEquals(retrieved.getPetStatus(),
// // underTest.petShelterStatus(puppy.getName()));
// assertTrue(check.equalsIgnoreCase(underTest.petShelterStatus(puppy.getName())));
//
// } // which way is better?
//
// @Test
// public void assertThatPetPlayReducesBoredom() {
// // assert
// underTest.addPet(puppy);
// // act
// underTest.petShelterPlay(puppy.getName(), 10);
//
// // assert
// VirtualPet retrieved = underTest.findPet(puppy);
// retrieved.getBoredom();
// int check = 20;
// assertEquals(check, retrieved.getBoredom());
//
// }
//
// @Test
// public void getIndividualHungerStatusFromShelter() {
// // assert
// underTest.addPet(puppy);
// // act
// underTest.petShelterHunger(puppy.getName());
// underTest.petShelterThirst(puppy.getName());
// underTest.petShelterBoredom(puppy.getName());
// underTest.petShelterThirst(puppy.getName());
// underTest.petShelterWaste(puppy.getName());
//
// // act
// VirtualPet retrieved = underTest.findPet(puppy);
// retrieved.getBoredom();
// retrieved.getHunger();
// retrieved.getThirst();
// retrieved.getWaste();
//
// // assert
// assertEquals(retrieved.getBoredom(),
// underTest.petShelterBoredom(puppy.getName()));
// assertEquals(retrieved.getHunger(),
// underTest.petShelterHunger(puppy.getName()));
// assertEquals(retrieved.getThirst(),
// underTest.petShelterThirst(puppy.getName()));
// assertEquals(retrieved.getWaste(),
// underTest.petShelterWaste(puppy.getName()));
// }
//
// @Test
// public void assertdescriptionPetStatus() {
// // assert
// underTest.addPet(puppy);
//
// // act
// underTest.petShelterDescription(puppy.getName());
//
// // assert
// VirtualPet retrieved = underTest.findPet(puppy);
// retrieved.getDescription();
//
// assertEquals(retrieved.getDescription(),
// underTest.petShelterDescription(puppy.getName()));
// }
//
// @Test
// public void assertAcollectionIsReturned() {
// underTest.addPet(puppy);
//
// // act
// underTest.petShelterCollection();
//
// // assert
// Collection<VirtualPet> retrieved = underTest.petShelterCollection();
// assertEquals(retrieved, underTest.petShelterCollection());
//
// }
//
// @Test
// public void assertFucntionOfTickMethod() {
// underTest.addPet(puppy);
//
// // act
// underTest.tickCycle();
// VirtualPet retrieved = underTest.findPet(puppy);
// retrieved.getHunger();
// int check = 52;
//
// // assert
// assertEquals(check, retrieved.getHunger());
// }
//
// @Test
// public void assertFunctionOFTickMethodTwoObjects() {
// underTest.addPet(puppy);
// VirtualPet retrieved = new VirtualPet("Scooby-Doo", 48, boredome, waste,
// thirst);
// underTest.addPet(retrieved);
//
// // act
// underTest.tickCycle();
// VirtualPet petTest = underTest.findPet(puppy);
// VirtualPet petRetrieved = underTest.findPet(retrieved);
//
// // assert
// int check = 52;
// int checkRetrieved = 50;
//
// assertEquals(check, petTest.getHunger());
// assertEquals(checkRetrieved, petRetrieved.getHunger());
//
// }
//
// @Test
// public void assertRandomStatFucntion() {
// VirtualPet retrieved = new VirtualPet("Scooby", "Always hungry");
// VirtualPet petObjectCheck = new VirtualPet("Toto", "Portal Access");
//
// System.out.println(retrieved.getHunger());
// System.out.println(petObjectCheck.getHunger());
//
// }
//
// @Test
// public void assertThatWasteRemovedFromPet() {
// underTest.addPet(puppy);
//
// // act
// underTest.cleanPetShelter(puppy.getName(), 5);
// VirtualPet retrieved = underTest.findPet(puppy);
// int check = 25;
// // assert
// assertEquals(check, retrieved.getWaste());
//
// }
//
// }
