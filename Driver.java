import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)

    public static void main(String[] args) {


        initializeDogList();
        initializeMonkeyList();
        String selection = " ";
    	Scanner scanner = new Scanner(System.in);
        // Add a loop that displays the menu, accepts the users input
        
    	while (selection != "q"){
        	displayMenu();
        	selection = scanner.nextLine();
       
        	switch (selection) {
        	case "1": intakeNewDog(scanner);
        	break;
        	case "2": intakeNewMonkey(scanner);
        	break;
        	case "3": reserveAnimal(scanner);
        	break;
        	case "4": printAnimals("dog");
        	break;
        	case "5":printAnimals("monkey");
        	break;
        	case "6":printAnimals("available");
        	break;
        	case "q":
        		System.out.println("Exiting System...");
        		System.exit(0);
        	default: System.out.println("Invalid input, please try again?");
        	break;
        	}
    	}
   
        // and takes the appropriate action.
	// For the project submission you must also include input validation
        // and appropriate feedback to the user.
        // Hint: create a Scanner and pass it to the necessary
        // methods 
	// Hint: Menu options 4, 5, and 6 should all connect to the printAnimals() method.

    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	 Monkey monkey1 = new Monkey("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
      
         monkeyList.add(monkey1);
        
    }


    // Complete the intakeNewDog method

    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\nThis dog is already in our system.\n");
                return; //returns to menu
            }
            }
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        
        System.out.print("Age: ");
        String age = scanner.nextLine();
        
        System.out.print("Weight: ");
        String weight = scanner.nextLine();
        
        System.out.print("Acquisition date: ");
        String acquisionDate = scanner.nextLine();
        
        System.out.print("Acquisition country: ");
        String acquisionCountry = scanner.nextLine();
        
        System.out.print("Training status: ");
        String status = scanner.nextLine();
        
        System.out.print("Reserved (type y for yes, n for no ");
        String choice = scanner.nextLine();
        boolean reserved;
        if(choice.equals("y"))
            reserved = true;
        else
            reserved = false;
        
        System.out.print("In service country: ");
        String inServiceCountry = scanner.nextLine();
        
        Dog newDog = new Dog(name, breed, gender, age, weight, acquisionDate, acquisionCountry, status, reserved, inServiceCountry);
        dogList.add(newDog);
        
        System.out.print("Dog added succesfully to the list!");
    }




        // Complete intakeNewMonkey
	//Instantiate and add the new monkey to the appropriate list
        // For the project submission you must also  validate the input
	// to make sure the monkey doesn't already exist and the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
        	 System.out.println("What is the monkey's name?");
             String name = scanner.nextLine();
             for(Monkey monkey : monkeyList) {
                 if(monkey.getName().equalsIgnoreCase(name)) {
                     System.out.println("\n\nThis monkey is already in our system\n\n");
                     return;
                 }
        }
             System.out.print("Breed: ");
             String breed = scanner.nextLine();
             
             System.out.print("Gender: ");
             String gender = scanner.nextLine();
             
             System.out.print("Age: ");
             String age = scanner.nextLine();
             
             System.out.print("Weight: ");
             String weight = scanner.nextLine();
             
             System.out.print("Acquisition date: ");
             String acquisionDate = scanner.nextLine();
             
             System.out.print("Acquisition country: ");
             String acquisionCountry = scanner.nextLine();
             
             System.out.print("Training status: ");
             String status = scanner.nextLine();
             
             System.out.print("Reserved (type y for yes, n for no ");
             String choice = scanner.nextLine();
             boolean reserved;
             if(choice.equals("y"))
                 reserved = true;
             else
                 reserved = false;
             
             System.out.print("In service country: ");
             String inServiceCountry = scanner.nextLine();
             
             Monkey newMonkey = new Monkey(name, breed, gender, age, weight, acquisionDate, acquisionCountry, status, reserved, inServiceCountry);
             monkeyList.add(newMonkey);
             
             System.out.print("Monkey added succesfully to the list!");
        }
        // Complete reserveAnimal
        // You will need to find the animal by animal type and in service country
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("Type of Animal: ");
            String type = scanner.nextLine();
            System.out.println("in-service country: ");
            String service_country = scanner.nextLine();
            
            if (type.equalsIgnoreCase("dog")) {
            	int check = 0;
            	for (Dog dog: dogList) {
            		if(dog.getInServiceLocation().equalsIgnoreCase(service_country)) {
            			if(! dog.getReserved()) {
            				dog.setReserved(true);
            				System.out.println("Dog is now reserved!");
            				check = 1;
            			}
            		}
            	}
            	if (check == 0) {
            		System.out.println("Dog couldn't be found.");
            	}
            }
            
            if (type.equalsIgnoreCase("monkey")) {
            	int check = 0;
            	for (Monkey monkey: monkeyList) {
            		if(monkey.getInServiceLocation().equalsIgnoreCase(service_country)) {
            			if(! monkey.getReserved()) {
            				monkey.setReserved(true);
            				System.out.println("monkey is now reserved!");
            				check = 1;
            			}
            		}
            	}
            	if (check == 0) {
            		System.out.println("monkey couldn't be found.");
            	}
            }

        }

        // Complete printAnimals
        // Include the animal name, status, acquisition country and if the animal is reserved.
	// Remember that this method connects to three different menu items.
        // The printAnimals() method has three different outputs
        // based on the listType parameter
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
	// Remember that you only have to fully implement ONE of these lists. 
	// The other lists can have a print statement saying "This option needs to be implemented".
	// To score "exemplary" you must correctly implement the "available" list.
        public static void printAnimals(String listSelect) {
            
            
            if (listSelect.equals("dog")) {
            	for (Dog dog : dogList) {
            	System.out.println("Dog: " + dog.getName());
            	System.out.println("Age:  " + dog.getAge());
            	System.out.println("Weight(lbs): " + dog.getWeight());
            	System.out.println("Date: " + dog. getAcquisitionDate());
            	System.out.println("Location: " + dog.getAcquisitionLocation());
            	System.out.println("Training: " + dog.getTrainingStatus());
            	System.out.println("Reserved: " + dog.getReserved());
            	System.out.println("*******************");
            	
            	}
            }
            if (listSelect.equals("monkey")) {
            	for (Monkey monkey : monkeyList) {
            	System.out.println("Monkey: " + monkey.getName());
            	System.out.println("Age:  " + monkey.getAge());
            	System.out.println("Weight: " + monkey.getWeight());
            	System.out.println("Date: " + monkey. getAcquisitionDate());
            	System.out.println("Location: " + monkey.getAcquisitionLocation());
            	System.out.println("Training: " + monkey.getTrainingStatus());
            	System.out.println("Reserved: " + monkey.getReserved());
            	System.out.println("*******************");
            	}
            }
            
            if (listSelect.equals("available")) {
            	
            	 if (listSelect.equals("dog")) {
                 	for (Dog dog : dogList) {
                 		if(dog.getReserved()== false) {
                 	System.out.println("Dog: " + dog.getName());
                 	System.out.println("Age:  " + dog.getAge());
                 	System.out.println("Weight: " + dog.getWeight());
                 	System.out.println("Date: " + dog. getAcquisitionDate());
                 	System.out.println("Location: " + dog.getAcquisitionLocation());
                 	System.out.println("Training: " + dog.getTrainingStatus());
                 	System.out.println("Reserved: " + dog.getReserved());
                 	System.out.println("*******************");
                 		}
                 	}
                 }
            	for (Monkey monkey : monkeyList) {
            		if (monkey.getReserved() == false) {
            	System.out.println("Monkey: " + monkey.getName());
            	System.out.println("Age:  " + monkey.getAge());
            	System.out.println("Weight: " + monkey.getWeight());
            	System.out.println("Date: " + monkey. getAcquisitionDate());
            	System.out.println("Location: " + monkey.getAcquisitionLocation());
            	System.out.println("Training: " + monkey.getTrainingStatus());
            	System.out.println("Reserved: " + monkey.getReserved());
            	System.out.println("*******************");
            	}
            }

        }
       }
}

