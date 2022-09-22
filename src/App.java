import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Scanner; 

public class App {
	
	public static void main (String[]args) {
		
		mainProgram();
	}
	
	static void mainProgram() {
		
		//Main program that loops throw the multiple choices depending of a boolean value that you can switch it pressing 5.  
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Hotel> hotelsList = new ArrayList<Hotel>();
		boolean AppRunning = true;
		String mainChoise;
		
		while(AppRunning) {
			
			System.out.println("HOTEL ADMIN\n");
			System.out.println("Select an option using numeric values [ 1 - 2 - 3 - 4]\n\n1-> Add a Hotel\n2-> Remove an hotel\n3-> Find hotel\n4-> Hotel modify\n5-> Close");
			
			mainChoise = sc.nextLine();
			
			switch (mainChoise) {
				case "1":
					createHotel(sc, hotelsList);
					break;
				case "2":
					deleteHotel(sc, hotelsList);
					break;
				case "3":
					showHotel(sc, hotelsList);
					break;
				case "4":
					hotelModify(sc, hotelsList);
					break;
				case "5":
					AppRunning = false;
					break;
				default:
					System.out.println("Choise out of range");
					break;
				}	
		}
	}
	
	static void createHotel( Scanner sc, ArrayList<Hotel> array) {
		
		String name;
		int roomsAmount, floors, totalSurface;
		
		System.out.println("Enter the name of the hotel. ");
		name = sc.nextLine();
		
		System.out.println("Enter the total amount of rooms.");
		roomsAmount = sc.nextInt();
		
		System.out.println("Enter the total amount of floors. ");
		floors = sc.nextInt();
		
		System.out.println("Enter the total surface.");
		totalSurface = sc.nextInt();
		
		Hotel newHotel = new Hotel(name, roomsAmount, floors, totalSurface);
		
		//Calling to another method that add items to array tiring to simplify the methods tasks.
		addToArray(newHotel, array);
		
	}
	
	static void addToArray(Hotel hotel, ArrayList<Hotel> array ) {
		
		array.add(hotel);
		
		// the commented code is just in order to check if the hotels were correctly added to the array. 
		/*
		for (Hotel hotel2 : array) {
			System.out.println("Array");
			hotel2.showInfo();
		}*/
	}
	
	static void deleteHotel(Scanner sc, ArrayList<Hotel> hotelArray) {
		
		boolean exist;
		String string;
		int hotelIndex;
		Hotel hotel;
		
		// This code is repeated in more than one methods so i decided to implement another method thats check's if the hotel exist returning the hotel or a null value 
		hotel = checkIfExists(sc, hotelArray);
		
		if( hotel!=null ) {
			
			//Whit the returned hotel and it index is removed 
			
			hotelIndex = hotelArray.indexOf(hotel);
			hotelArray.remove(hotelIndex);
			string =  "Hotel deleted successfully ";
			
		} else
			string =  "This hotel doesn't exist in or database ";
		
		System.out.println(string);
	}
	
	static Hotel checkIfExists(Scanner sc, ArrayList<Hotel> hotelArray) {
		
		String hotelName;
		boolean hotelExists = false;
		int index, arraySize;
		Hotel hotel;
		
		arraySize = hotelArray.size();
		index = 0;
		
		System.err.println("Enter the name of the hotel:");
		hotelName = sc.nextLine();
		
		//Doing a while to iterate throw the array list stooping the loop when the condition is done to avoid iterate unnecessary once the data is found 
		while(index < arraySize && !hotelExists) {
			
			hotelExists = ( hotelName.equals(hotelArray.get(index).getName() ) ) ? true : false;

			index++;
		}
		
		hotel = (hotelExists) ?  hotelArray.get(index-1) : null; 
		
		return hotel; 
		
	}
	
	static void showHotel(Scanner sc, ArrayList<Hotel> hotelArray) {
		
		int hotelIndex;
		Hotel hotel;
		
		hotel = checkIfExists(sc, hotelArray);
		
		if( hotel!=null ) {
			hotelIndex = hotelArray.indexOf(hotel);
			hotel.showInfo();
			hotel.calculateMaintenance(hotel.getRoomsAmount());
			
		} else
			System.out.println("This hotel doesn't exist in or database ");
		
	}
	
	static void hotelModify(Scanner sc, ArrayList<Hotel> hotelArray) {
		
		Hotel hotel;
		int hotelIndex;
		
		
		hotel = checkIfExists(sc, hotelArray);
		
		if( hotel!=null ) {
			hotelIndex = hotelArray.indexOf(hotel);
			setHotel(sc, hotel, hotelIndex);
			
			
		} else
			System.out.println("This hotel doesn't exist in or database ");
	}
	
	static void setHotel(Scanner sc, Hotel hotel, int index) {
		
		String choise, newName;
		int newRoomsAmount, newAmountFloors, newSurface;
		
		System.out.println("Whic field would you like to change?\nSelect an option using numeric values [ 1 - 2 - 3 - 4]\n\n1->Enter new name:\n2->Enter new amuont of rooms\n3->Enter new amount of floors\n4->Enter new name amount of surface");
		choise = sc.nextLine();
		
		//I have tried to write methods as in the other switch instead of loose code, but I have not been able to simplify it.
		switch (choise) {
		case "1":
			System.out.println("Enter the new value:");
			newName = sc.nextLine();
			hotel.setName(newName);
			break;
		case "2":
			System.out.println("Enter the new value:");
			newRoomsAmount = sc.nextInt();
			hotel.setRoomsAmount(newRoomsAmount);
			break;
		case "3":
			System.out.println("Enter the new value:");
			newAmountFloors = sc.nextInt();
			hotel.setFloors(newAmountFloors);
			break;
		case "4":
			System.out.println("Enter the new value:");
			newSurface = sc.nextInt();
			hotel.setTotalSurface(newSurface);
			break;
		default:
			System.out.println("Choise out of range");
			break;
		}
	}
	
	
}

