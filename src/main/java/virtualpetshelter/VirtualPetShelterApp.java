package virtualpetshelter;

import java.util.Scanner;

public class VirtualPetShelterApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to WeCanCodIt Pet Shleter");
		System.out.println("We are in need of adopted pets, we just opened up");
		System.out.println("Please allow us to adopt one of your Pets");
		System.out.println("We need about 4 pets at least to open up for business!");

		// adoption
		VirtualPetShelter weCanCodePets = new VirtualPetShelter();
		// start do-while
		do {
			System.out.println("Pet Intake, please enter the pet you would like to adopt:");
			String userPetName = input.nextLine();
			System.out.println("Please also provide a brief description!");
			String userPetDescription = input.nextLine();
			System.out.println("We will asses the pets Status report back to you");
			VirtualPet petObject = new VirtualPet(userPetName, userPetDescription);
			weCanCodePets.addPet(petObject);
			System.out.println(weCanCodePets.findPet(petObject).getPetStatus());
		} while (weCanCodePets.shelterSize() < 4);

		System.out.println("Thank you for all of the pets here is a list of them and their individual stats");
		for (VirtualPet pet : weCanCodePets.virtualPets.values()) {
			System.out.println("Pet Name: " + pet.getName() + "\tHunger: " + pet.getHunger() + "\tThirst: "
					+ pet.getThirst() + "\tWaste: " + pet.getWaste() + "\tBoredome: " + pet.getBoredom());
		}

		System.out.println("Welcome back! what would you like to do with the pets");
		System.out.println("______________________________________________________");
		// usermenu
		String userChoice = "";
		do {
			System.out.println("Please choose:");
			System.out.println("1. Adopt Pet");
			System.out.println("2. Give up a Pet");
			System.out.println("3. Feed Pet");
			System.out.println("4. Water Pet");
			System.out.println("5. Clean Waste for Pet");
			System.out.println("6. Play with Pet");
			System.out.println("7. Overall status of Pet");
			System.out.println("8. Check on levels of Pet");
			System.out.println("9. List of pets");
			System.out.println("10. Exit....");
			userChoice = input.nextLine().trim();

			if (userChoice.equals("1")) {
				System.out.println("Please enter name you would like to adopt");
				String userRemove = input.nextLine();
				weCanCodePets.virtualPets.remove(userRemove);
				System.out.println("Enjoy your pet!!!");

			}

			if (userChoice.equals("2")) {
				System.out.println("Please enter name:");
				String userAddPet = input.nextLine().trim();
				System.out.println("Enter Description:");
				String userAddDescription = input.nextLine();
				VirtualPet petAdd = new VirtualPet(userAddPet, userAddDescription);
				weCanCodePets.addPet(petAdd);
			}

			if (userChoice.equals("3")) {
				System.out.println("Which pet would you like to feed?");
				String userFeed = input.nextLine().trim();
				System.out.println("How much you would like to feed? 1-10 pellets?");
				int feedamount = input.nextInt();
				weCanCodePets.feedPetShelter(userFeed, feedamount);
			}

			if (userChoice.equals("4")) {
				System.out.println("Which pet would you like to water?");
				String userDrink = input.nextLine().trim();
				System.out.println("How much you would like to water? 1-10 pellets?");
				int drinkAmount = input.nextInt();
				weCanCodePets.waterPetShelter(userDrink, drinkAmount);
			}

			if (userChoice.equals("5")) {
				System.out.println("Which pet would you like to clean?");
				String userWaste = input.nextLine();
				System.out.println("How much would you like to clean? 1-10?");
				int wasteAmount = input.nextInt();
				weCanCodePets.cleanPetShelter(userWaste, wasteAmount);
			}

			if (userChoice.equals("6")) {
				System.out.println("Which pet would you like to play with?");
				String userPlay = input.nextLine().trim();
				System.out.println("How long would you like to play? 1-10?");
				int playAmount = input.nextInt();
				weCanCodePets.petShelterPlay(userPlay, playAmount);
			}

			if (userChoice.equals("7")) {
				System.out.println("Which pet would you like to know about?");
				String userStatus = input.nextLine().trim();
				System.out.println(weCanCodePets.petShelterStatus(userStatus));
			}

			if (userChoice.equals("8")) {
				System.out.println("Which pet would you like to know about:");
				String userStat = input.nextLine().trim();
				System.out.println("Hunger: " + weCanCodePets.petShelterHunger(userStat) + "\tThirst: "
						+ weCanCodePets.petShelterThirst(userStat) + "\tWaste: "
						+ weCanCodePets.petShelterWaste(userStat) + "\tBoredome: "
						+ weCanCodePets.petShelterBoredom(userStat));
			}

			if (userChoice.equals("9")) {
				for (VirtualPet pet : weCanCodePets.virtualPets.values()) {
					System.out.println("Pet Name: " + pet.getName() + "\tHunger: " + pet.getHunger() + "\tThirst: "
							+ pet.getThirst() + "\tWaste: " + pet.getWaste() + "\tBoredome: " + pet.getBoredom());
				}
			}

			weCanCodePets.tickCycle();
		} while (!userChoice.equals("10"));
		System.exit(0);

	}

}
