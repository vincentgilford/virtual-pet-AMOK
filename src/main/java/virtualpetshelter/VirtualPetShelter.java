package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> virtualPets = new HashMap<String, VirtualPet>();

	public int litterBox = 0;
	public int poop = 0;

	public void addPet(VirtualPet pet) {
		virtualPets.put(pet.getName(), pet);
	}

	public VirtualPet findPet(String petName) {
		// TODO Auto-generated method stub
		return virtualPets.get(petName);
	}

	public void adoptPet(VirtualPet pet) {
		// TODO Auto-generated method stub
		virtualPets.remove(pet.getName());
	}

	public int shelterSize() {
		// TODO Auto-generated method stub
		return virtualPets.size();
	}

	public void feedPetShelter(String name, int amountToFeed) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		
		if (virtualPets.get(name) instanceof OrganicCat) {
			((OrganicCat) petObject).feedOrganicPet(amountToFeed);
		}
		if (petObject instanceof OrganicDog) {
			((OrganicDog) petObject).feedOrganicPet(amountToFeed);
		}
	}

	public void waterPetShelter(String name, int amountToDrink) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		if (petObject instanceof OrganicCat) {
			((OrganicCat)petObject).waterPet(amountToDrink);
		}
		if (petObject instanceof OrganicDog) {
			((OrganicDog)petObject).waterPet(amountToDrink);
		}
	}

	public void petShelterPlay(String name, int amountPlay) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		petObject.petPlayBoredom(amountPlay);
	}

	public int petShelterHunger(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		int hungerLevel = 0; 
		if (petObject instanceof OrganicDog) {
			hungerLevel = ((OrganicDog) petObject).getThirst();
		} else if (petObject instanceof OrganicCat) {
			hungerLevel = ((OrganicCat) petObject).getThirst();
		} else {
			System.out.println("Robots do not require nourishment");
		}	
		return hungerLevel;
	}
	
	
	//not VP
	public int petShelterThirst(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		int thirstLevel = 0; 
		if (petObject instanceof OrganicDog) {
			thirstLevel = ((OrganicDog) petObject).getThirst();
		} else if (petObject instanceof OrganicCat) {
			thirstLevel = ((OrganicCat) petObject).getThirst();
		} else {
			System.out.println("Robots do not have thirst");
		}
		
		return thirstLevel;

	}

	public int petShelterBoredom(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		return petObject.getBoredom();

	}

	//not VP
	public int petShelterWaste(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		int wasteLevel = 0; 
		if (petObject instanceof OrganicDog) {
			wasteLevel = ((OrganicDog) petObject).getThirst();
		} else if (petObject instanceof OrganicCat) {
			wasteLevel = ((OrganicCat) petObject).getThirst();
		} else {
			System.out.println("Robots do not have waste");
		}
		return wasteLevel;
	}

	
	public String petShelterDescription(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		return petObject.getDescription();
	}

	public Collection petShelterCollection() {
		// TODO Auto-generated method stub
		return virtualPets.values();

	}

	public void tickCycle() {
		// TODO Auto-generated method stub
		for (VirtualPet petObject : virtualPets.values()) {
			petObject.tickEffect();
		}
		System.out.println("Cycle Complete");
	}

	//not VP
	public void cleanPetShelter(String name, int wasteAmount) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		if (petObject instanceof OrganicCat) {
			((OrganicCat)petObject).wasteRemoval(wasteAmount);
		} else if (petObject instanceof OrganicDog) {
			((OrganicDog)petObject).wasteRemoval(wasteAmount);
		} else {
			System.out.println("Robots do not have waste!");
		}

	}

	public Collection<VirtualPet> getAllPets() {
		// TODO Auto-generated method stub
		return virtualPets.values();
	}

	public void feedAllPets() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : virtualPets.values()) {
			if (pet instanceof OrganicDog ) {
				((OrganicDog) pet).feedOrganicPet(10);
			} else if(pet instanceof OrganicCat) {
				((OrganicCat) pet).feedOrganicPet(10);
			}
			else {
				System.out.println("Robotic Pets cannot be fed");
			}
		}
	}

	public void waterAllPets() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : virtualPets.values()) {
			if (pet instanceof OrganicDog) {
				((OrganicDog)pet).waterPet(10);
			} else if(pet instanceof OrganicCat) {
				((OrganicCat)pet).waterPet(10);
			}
			else {
				System.out.println("Robotic Pets cannot be fed");
			}
		}
	}

	public void organicWasteRemove() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : virtualPets.values()) {
			if (pet instanceof OrganicCat) {
				((OrganicCat)pet).wasteRemoval(10);
				poop += 10;
				litterBox = poop;
			} else if (pet instanceof OrganicDog) {
				((OrganicDog)pet).wasteRemoval(10);// dog cages
			} else {
				System.out.println("Robotic Pets do not have waste");
			}
		}

	}

	public int getLitterBox() {
		return litterBox;

	}

	public void playAll() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : virtualPets.values()) {
			pet.petPlayBoredom(10);
			System.out.println("Bordom: " + pet.getBoredom());
		}
	}

	public void walkAllPets() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : virtualPets.values()) {
			if (pet instanceof Walkable) {
				((Walkable)pet).walkPet();
				System.out.println(pet.getName() + " has been walked!");
			}

		}
	}

	public void cleanLitterBox() {
		// TODO Auto-generated method stub

		if (litterBox <= 0) {
			System.out.println("Litter Box is empty");
		} else {
			litterBox -= 10;
		}
	}

	public void oilAllPet() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : virtualPets.values()) {
			if (pet instanceof RoboticDog) {
				((RoboticDog)pet).oilRobot();
			} else if(pet instanceof RoboticCat) {
				((RoboticCat)pet).oilRobot();
			} else {
				System.out.println("Organic beings do not generate oil");
			}
		}
	}


	public void cleanCages() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : virtualPets.values()) {
			if (pet instanceof OrganicDog) {
				((OrganicDog)pet).cleanCage();
				System.out.println("Name: " + pet.getName() + "\tCage Level: " + ((OrganicDog)pet).getCageLevel());
			}
		}
	}

	public void chargeRobots() {
		// TODO Auto-generated method stub
		for (VirtualPet pet : virtualPets.values()) {
			if (pet instanceof RoboticCat) {
				((RoboticCat)pet).chargePet(10);
			} else if (pet instanceof RoboticDog) {
				((RoboticDog)pet).chargePet(10);
			} else {
				System.out.println("Organic Pets do not have outlets");
			}
		}

	}

}
