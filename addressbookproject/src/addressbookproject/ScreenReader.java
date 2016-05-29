package addressbookproject;


import java.util.Scanner;

public class ScreenReader {
	
	int answer = 0;
	int counter = 0;
	String countr;
	int value;
	int namekey = 0;
	String namein;
	int max_count = 0;
	
	MenuDisplay menu = new MenuDisplay();
	Contact contact = new Contact();
	Scanner sc = new Scanner(System.in);
	
	public void readOptions(String fileName){
		while (answer != 6){
			menu.displayMenu();
			
			
			answer = sc.nextInt();
			Contact contact = new Contact();
			Addresses adr = new Addresses(fileName);


			switch (answer){
			case 1: 
				max_count = adr.getMaxKey();
				counter = max_count;
				counter = counter + 1;
				countr = Integer.toString(counter);
				contact = getAddress(countr);
				namekey = contact.hashCode();
				adr.saveAddress(namekey,contact);
				adr.saveUpdates(fileName);
				
				break;
			case 2:  adr.listAll();
			break;
			case 3: System.out.println("Please enter number of name you wish to delete. ");
			value = sc.nextInt();
			namein = Integer.toString(value);
			adr.deleteAddress(namein);
			System.out.println("Address is deleted from address book.");
			menu.displayMenu();
			break;
			case 4:  
				System.out.println("Change Address Details");
				break;	
			case 5:
				System.out.println("Writing csv file:");
				adr.saveUpdates(fileName);
				break;
			case 6: System.exit(0);
			sc.close();
			default: System.out.println("Please enter a number between 1 and 5.");
			menu.displayMenu();
			
			}

		}


	}
	
	
	public Contact getAddress(String contact_id){
		
		String screen_word;
        contact.setContact_id(contact_id);
		System.out.println("Enter firstname: ");
		screen_word=sc.next();
		contact.setFirstname(screen_word);
		System.out.println("Enter surname: ");
		screen_word=sc.next();
		contact.setSurname(screen_word);
		sc.nextLine();
		System.out.println("Enter address 1: ");
		screen_word=sc.nextLine();
		contact.setAddress_line_1(screen_word);
		System.out.println();
		System.out.println("Enter address 2: ");
		screen_word=sc.nextLine();
		contact.setAddress_line_2(screen_word);
		System.out.println();
		System.out.println("Enter address 3");
		screen_word=sc.nextLine();
		contact.setAddress_line_3(screen_word);
		System.out.println("Enter mobile");
		screen_word=sc.nextLine();
		contact.setMobile(screen_word);
		
		return contact;
	}

}
