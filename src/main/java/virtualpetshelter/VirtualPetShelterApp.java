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
			System.out.println("What kind of Pet is your entry?");
			System.out.println("1. RobotDog");
			System.out.println("2. RobotCat");
			System.out.println("3. Live Dog");
			System.out.println("4. Live Cat");
			String userType = input.nextLine().trim();
			if(userType.equals("1")) {
				RoboticDog petObject= new RoboticDog(userPetName, userPetDescription);
				weCanCodePets.addPet(petObject);
			}
			if(userType.equals("2")) {
				RoboticCat petObject= new RoboticCat(userPetName, userPetDescription);
				weCanCodePets.addPet(petObject);
			}
			if(userType.equals("3")) {
				OrganicDog petObject= new OrganicDog(userPetName, userPetDescription);
				weCanCodePets.addPet(petObject);
			}
			if(userType.equals("4")) {
				OrganicCat petObject= new OrganicCat(userPetName, userPetDescription);
				weCanCodePets.addPet(petObject);
			}
//			System.out.println("We will asses the pets Status report back to you");			
//			System.out.println(weCanCodePets.findPet(petObject).getPetStatus());
		} while (weCanCodePets.shelterSize() < 4);

		System.out.println("Thank you for all of the pets here is a list of them and their individual stats");
		for (VirtualPet pet : weCanCodePets.virtualPets.values()) {
			if(pet instanceof OrganicCat) {
				System.out.println("Name: " + pet.getName() + "\tDescription: " + pet.getDescription() + "\tType: Live Cat");	
			}
			if(pet instanceof OrganicDog) {
				System.out.println("Name: " + pet.getName() + "\tDescription: " + pet.getDescription()+ "\tType: Live Dog");	
			}
			if(pet instanceof RoboticDog) {
				System.out.println("Name: " + pet.getName() + "\tDescription: " + pet.getDescription()+ "\tType: Robotic Dog");	
			}
			if(pet instanceof RoboticCat) {
				System.out.println("Name: " + pet.getName() + "\tDescription: " + pet.getDescription()+ "\tType: Robotic Cat");	
			}
			
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
			System.out.println("4. Feed ALL living Pets");
			System.out.println("5. Water Pet");
			System.out.println("6. Water ALL Pets");
			System.out.println("7. Clean Waste for Pet");
			System.out.println("8. Remove Waste for ALL living pets");
			System.out.println("9. Clean Litter Box");
			System.out.println("10. Clean Dog Cages");
			System.out.println("11. Oil Robotic ALL Pets");
			System.out.println("12. Charge Robotic Pets");
			System.out.println("13. Play with Pet");
			System.out.println("14. Play with ALL Pets");
			//new addition
			System.out.println("15. Walking Dogs");
			System.out.println("16. Check on levels of individual pet");
			System.out.println("17. List of pets");
			System.out.println("18. Exit....");
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
				String userAddDescription = input.nextLine().trim();
				System.out.println("What kind of Pet would you like to submit?");
				System.out.println("1. RobotDog");
				System.out.println("2. RobotCat");
				System.out.println("3. Live Dog");
				System.out.println("4. Live Cat");
				String userType = input.nextLine().trim();
				if(userType.equals("1")) {
					RoboticDog petObject= new RoboticDog(userAddPet, userAddDescription);
					weCanCodePets.addPet(petObject);
				}
				if(userType.equals("2")) {
					RoboticCat petObject= new RoboticCat(userAddPet, userAddDescription);
					weCanCodePets.addPet(petObject);
				}
				if(userType.equals("3")) {
					OrganicDog petObject= new OrganicDog(userAddPet, userAddDescription);
					weCanCodePets.addPet(petObject);
				}
				if(userType.equals("4")) {
					OrganicCat petObject= new OrganicCat(userAddPet, userAddDescription);
					weCanCodePets.addPet(petObject);
				}
			}

			if (userChoice.equals("3")) {
				System.out.println("Which pet would you like to feed?");
				String userFeed = input.nextLine().trim();
				System.out.println("How much you would like to feed? 1-10 pellets?");
				int feedamount = input.nextInt();
				weCanCodePets.feedPetShelter(userFeed, feedamount);
			}
			if (userChoice.equals("4")) {
				weCanCodePets.feedAllPets();
			}
			
			if (userChoice.equals("5")) {
				System.out.println("Which pet would you like to water?");
				String userDrink = input.nextLine().trim();
				System.out.println("How much you would like to water? 1-10 pellets?");
				int drinkAmount = input.nextInt();
				weCanCodePets.waterPetShelter(userDrink, drinkAmount);
			}
			
			if (userChoice.equals("6")) {
				weCanCodePets.waterAllPets();
			}

			if (userChoice.equals("7")) {
				System.out.println("Which pet would you like to clean?");
				String userWaste = input.nextLine();
				System.out.println("How much would you like to clean? 1-10?");
				int wasteAmount = input.nextInt();
				weCanCodePets.cleanPetShelter(userWaste, wasteAmount);
			}
			if (userChoice.equals("8")) {
				weCanCodePets.organicWasteRemove();
			}
			//litterbox
			if (userChoice.equals("9")) {
				weCanCodePets.cleanLitterBox();
				System.out.println(weCanCodePets.getLitterBox());
			}
			//clean Cages
			if (userChoice.equals("10")) {
				weCanCodePets.cleanCages();	
			}
			//oil All Robot Pets
			if (userChoice.equals("11")){
				weCanCodePets.oilAllPet();
			}
			
			//charge Pets
			if (userChoice.equals("12")){
				weCanCodePets.chargeRobots();
			}
			
			//play with pet
			if (userChoice.equals("13")) {
				System.out.println("Which pet would you like to play with?");
				String userPlay = input.nextLine().trim();
				System.out.println("How long would you like to play? 1-10?");
				int playAmount = input.nextInt();
				weCanCodePets.petShelterPlay(userPlay, playAmount);
			}
			
			//play with all pets
			if (userChoice.equals("14")) {
				weCanCodePets.playAll();
			}
			
			if (userChoice.equals("15")) {
				weCanCodePets.walkAllPets();
			}
			
			//individual pet levels need to modify toString
			if (userChoice.equals("16")) {
				System.out.println("Which pet would you like to know about:");
				String userStat = input.nextLine().trim();
				VirtualPet pet = weCanCodePets.findPet(userStat);
				System.out.println(pet);
			}
	
			//list of pets
			if (userChoice.equals("17")) {
				for (VirtualPet pet : weCanCodePets.virtualPets.values()) {
					System.out.println(pet);
				}
			}
			
			weCanCodePets.tickCycle();
		} while (!userChoice.equals("18"));
		System.exit(0);

	}

}
