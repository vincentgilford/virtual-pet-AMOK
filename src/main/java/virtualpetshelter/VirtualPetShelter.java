package virtualpetshelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> virtualPets = new HashMap<String, VirtualPet>();

	public void addPet(VirtualPet pet) {
		virtualPets.put(pet.getName(), pet);

	}

	public VirtualPet findPet(VirtualPet pet) {
		// TODO Auto-generated method stub
		return virtualPets.get(pet.getName());
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
		petObject.feedPet(amountToFeed);
	}

	public void waterPetShelter(String name, int amountToDrink) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		petObject.waterPet(amountToDrink);

	}

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

	public void cleanPetShelter(String name, int wasteAmount) {
		// TODO Auto-generated method stub
		VirtualPet petObject = virtualPets.get(name);
		petObject.wasteRemoval(wasteAmount);
	}

}
