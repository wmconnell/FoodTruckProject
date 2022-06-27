package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import java.util.InputMismatchException;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

//	private final int MAX_TRUCKS = 5;
	private static Scanner scanner = new Scanner(System.in);
	private FoodTruck[] fleetOfFoodTrucks = new FoodTruck[5];
	FoodTruck ft = new FoodTruck();
	private static int nextTruckID = 0;

	private int numTrucks = 0;
//	fleetOfFoodTrucks[0] = FoodTruck ft2;
//	FoodTruck ft3;
//	FoodTruck ft4;
//	FoodTruck ft5;

	public static void main(String[] args) {

		FoodTruckApp fta = new FoodTruckApp();

		System.out.println("Welcome to the Food Truck App!");
		System.out.println("Type \"I love food trucks\" to get started!");
		System.out.println(
				"Type \"quit\" when entering the name of the food truck to stop and move on to the next step.");
	boolean correctAnswer = false;
		while (!correctAnswer) {
			
			
			String input1 = scanner.nextLine();
			if (input1.equals("I love food trucks")) {
				correctAnswer = true;
				boolean keepGoing = true;
				while (keepGoing) {
					for (int i = 0; i < fta.fleetOfFoodTrucks.length; i++) {
					nextTruckID++;
					keepGoing = fta.enterFoodTruckInfo(input1, nextTruckID, i);
					if (keepGoing == false) {
						break;
					}
					}
				}
			}else {
				System.out.println("Please enter a valid option.");
			}
		} 
		


		fta.foodTruckMenu(scanner);

	}

	public void addTruck(FoodTruck truck) {
		fleetOfFoodTrucks[numTrucks] = truck;
		numTrucks++;
	}

	public FoodTruck[] getTrucks() {

		FoodTruck[] reviewedFoodTrucks;
		reviewedFoodTrucks = new FoodTruck[numTrucks];
		int reviewedFoodTrucksNumber = 0;

		for (int i = 0; i < numTrucks; i++) {
			if (fleetOfFoodTrucks[i] != null) {
				reviewedFoodTrucks[reviewedFoodTrucksNumber] = fleetOfFoodTrucks[i];
				reviewedFoodTrucksNumber++;
			} else {
				System.out.println("food truck" + i + " is null");
			}
		}
		return reviewedFoodTrucks;
	}

	private boolean enterFoodTruckInfo(String input1, int truckID, int index) {

//			for (int i = 0; i < fleetOfFoodTrucks.length; i++) {
				
					System.out.println("Please enter the name of the food truck: ");
					String truckName = scanner.nextLine();
					if (truckName.equals("quit")) {
						return false;
					} else {
						fleetOfFoodTrucks[index] = new FoodTruck(truckID);
						fleetOfFoodTrucks[index].setTruckName(truckName);
						System.out.println("Please enter the type of food " + truckName + " serves: ");
						String truckFoodType = scanner.nextLine();
						fleetOfFoodTrucks[index].setTruckFoodType(truckFoodType);
						fleetOfFoodTrucks[index].setTruckRating(getTruckRating(truckName));
//						scanner.nextLine();
						addTruck(fleetOfFoodTrucks[index]);
//						System.out.println(" i: " + i); // for testing
						if (index == fleetOfFoodTrucks.length - 1) {
							return false;
						}
					}
//				}
			return true;

		
	}
	
	public int getTruckRating(String truckName) {
		boolean noMismatch = false;
		int truckRating = 0;

		System.out.println("Please enter your rating for " + truckName + " (1 - 5): ");
		while (noMismatch == false)
		{
			noMismatch = true;
			try {
		
			truckRating = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter a number between 1 and 5");
			noMismatch = false;
		}
			scanner.nextLine();
		}	
		return truckRating;
	}

	public void foodTruckMenu(Scanner scanner) {
		
		
		fleetOfFoodTrucks = getTrucks();
		

		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("Please select from the following list of options.");
			System.out.println("--------------------");
			System.out.println("-----          -----");
			System.out.println("-1. List all food trucks");
			System.out.println("-2. Display average rating of food trucks");
			System.out.println("-3. Display the highest rated food truck");
			System.out.println("-4. Exit the program");
			System.out.println("-----          -----");
			System.out.println("--------------------");
			int selection = scanner.nextInt();
			switch (selection) {
			case 1:
				for (int i = 0; i < fleetOfFoodTrucks.length; i++) {
					System.out.println(fleetOfFoodTrucks[i].toString());
				}
				break;
			case 2:
				int totalTruckRating = 0;
				for (int i = 0; i < fleetOfFoodTrucks.length; i++) {
					totalTruckRating += fleetOfFoodTrucks[i].getTruckRating();
				}
				System.out.printf("The average rating is: %1.2f", (double)totalTruckRating / (double)fleetOfFoodTrucks.length);
				System.out.println();
				break;
			case 3:
				FoodTruck highestRatedTruck = new FoodTruck(0, "0", "0", 0);
				for (int i = 0; i < fleetOfFoodTrucks.length; i++) {
					if (fleetOfFoodTrucks[i].getTruckRating() > highestRatedTruck.getTruckRating()) {
					highestRatedTruck = fleetOfFoodTrucks[i];
					}
				}
				System.out.println("Highest rated food truck: ");
				System.out.println(highestRatedTruck.toString());
				break;
			case 4:
				keepGoing = false;
				System.out.println("Thank you, come again!");
				break;
			default:
				System.out.println("Please enter a valid input.");
				break;
			}
		}

	}

}
