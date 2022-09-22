import java.text.MessageFormat;
//The MessageFormat class provides a means to produce concatenated messages or string interpolation using format method

public class Hotel {
	
	//Atributs
	
	private String name; 
	private int roomsAmount, floors, totalSurface;
	
	//Methods
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoomsAmount() {
		return roomsAmount;
	}

	public void setRoomsAmount(int roomsAmount) {
		this.roomsAmount = roomsAmount;
	}

	public int getFloors() {
		return floors;
	}

	public void setFloors(int floors) {
		this.floors = floors;
	}

	public int getTotalSurface() {
		return totalSurface;
	}

	public void setTotalSurface(int totalSurface) {
		this.totalSurface = totalSurface;
	}
	
	public void calculateMaintenance(int rooms) {
		
		final int SALARY = 1500, RANGE = 20;
		int totalExpenses, staffNeeded;
		String string;
		
		staffNeeded = (rooms <= 20)? 1 : rooms / RANGE;
		totalExpenses = staffNeeded * SALARY;
		
		string = MessageFormat.format("Total amoung of employers needed {0}, total salary expenses {1}", staffNeeded, totalExpenses);
		
		System.out.println(string);
		
	}
	
	public void showInfo() {
		String string;
		string = MessageFormat.format("Hotel info\nName:{0}\nTotal Amount of rooms: {1}\nAmount of floors: {2}\nTotal surface: {3}", this.name, this.roomsAmount, this.floors, this.totalSurface);
		System.out.println(string);
	}

	
	//Constructor
	public Hotel (String name, int roomsAmount, int floors, int totalSurface) {
		
		this.name = name;
		this.roomsAmount = roomsAmount;
		this.floors = floors;
		this.totalSurface = totalSurface;
	}
	
	
}
