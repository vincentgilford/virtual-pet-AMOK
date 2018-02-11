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
		if(petObject instanceof OrganicCat) {
			petObject.feedOrganicPet(amountToFeed);
		}
		if(petObject instanceof OrganicDog) {
			petObject.feedOrganicPet(amountToFeed);
		}
	}

	public void waterPetShelter(String name, int amountToDrink) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		if(petObject instanceof OrganicCat) {
			petObject.waterPet(amountToDrink);
		}
		if(petObject instanceof OrganicDog) {
			petObject.waterPet(amountToDrink);
		}
	}
//check may delete
	public String petShelterStatus(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		return petObject.getPetStatus();
	}

	public void petShelterPlay(String name, int amountPlay) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		petObject.petPlayBoredom(amountPlay);
	}

	public int petShelterHunger(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		if(!(petObject instanceof OrganicCat)) {
			System.out.println("Robotic Pets do not have hunger");
			return 0;
		}
		if(petObject instanceof OrganicDog) {
			System.out.println("Robotic Pets do not have hunger");
			return 0;
		}
		return petObject.getHunger();
	}

	public int petShelterThirst(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		return petObject.getThirst();

	}

	public int petShelterBoredom(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		return petObject.getBoredom();

	}

	public int petShelterWaste(String name) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		return petObject.getWaste();

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
	
	//needs modification
	public void cleanPetShelter(String name, int wasteAmount) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		if(petObject instanceof OrganicCat || petObject instanceof OrganicDog) {
			petObject.wasteRemoval(wasteAmount);
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
		for(VirtualPet pet : virtualPets.values()) {
			if(pet instanceof OrganicDog || pet instanceof OrganicCat) {
				pet.feedOrganicPet(10);
			} else {
				System.out.println("Robotic Pets cannot be fed");
			}
		}
	}

	public void waterAllPets() {
		// TODO Auto-generated method stub
		for(VirtualPet pet : virtualPets.values()) {
			if(pet instanceof OrganicDog || pet instanceof OrganicCat) {
				pet.waterPet(10);
			} else {
				System.out.println("Robotic Pets cannot be fed");
			}
		}
	}

	public void organicWasteRemove() {
		// TODO Auto-generated method stub
		for(VirtualPet pet : virtualPets.values()) {
			if(pet instanceof OrganicCat) {
				pet.wasteRemoval(10);
				poop += 10;  
				litterBox = poop;
			} else if(pet instanceof OrganicDog) {
					pet.wasteRemoval(10);//dog cages
			}else {
				System.out.println("Robotic Pets do not have waste");
			}
		}
		
		
	
		
		
		
	}
	
	public int getLitterBox() {
		return litterBox;
		
	}

	public void playAll() {
		// TODO Auto-generated method stub
		for(VirtualPet pet : virtualPets.values()){
			pet.petPlayBoredom(10);
		}
	}

	public void walkAllPets() {
		// TODO Auto-generated method stub
		for(VirtualPet pet : virtualPets.values()){
			if(pet instanceof Walkable) {
			pet.walkPet();
			}
		} 
	}
	
	

	
	

	
	
	
	

		
}
