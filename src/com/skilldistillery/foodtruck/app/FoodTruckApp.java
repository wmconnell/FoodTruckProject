package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
//	private final int MAX_TRUCKS = 5;
	private static Scanner scanner = new Scanner(System.in);
	private FoodTruck[] fleetOfFoodTrucks = new FoodTruck[5];
	FoodTruck ft = new FoodTruck();

	public static void main(String[] args) {
		FoodTruckApp fta = new FoodTruckApp();

		fta.enterFoodTruckInfo();

		fta.foodTruckMenu(scanner);

	}

	private void enterFoodTruckInfo() {

		boolean keepGoing = true;
		
		
		System.out.println("Welcome to the Food Truck App!");
		System.out.println("Type \"I love food trucks\" to get started!");
		System.out.println(
				"Type \"quit\" when entering the name of the food truck to stop and move on to the next step.");
		String input1 = scanner.nextLine();

		while (keepGoing) {
			if (input1.equals("I love food trucks")) {
				for (int i = 0; i < 4; i++) {

					System.out.println("Please enter the name of the food truck: ");
					String truckName = scanner.nextLine();
					if (truckName.equals("quit")) {
						keepGoing = false;
					} else {
						fleetOfFoodTrucks[i].setTruckID(i + 1);
						fleetOfFoodTrucks[i].setTruckName(truckName);
						System.out.println("Please enter the type of food " + truckName + " serves: ");
						String truckFoodType = scanner.nextLine();
						fleetOfFoodTrucks[i].setTruckFoodType(truckFoodType);
						System.out.println("Please enter your rating for " + truckName + " (1 - 5): ");
						int truckRating = scanner.nextInt();
						fleetOfFoodTrucks[i].setTruckRating(truckRating);
						scanner.nextLine();
						System.out.println(" i: " + i); // for testing
						if (i == 4) {
							keepGoing = false;
						}
					}
				}
			} else {
				System.out.println("Please enter a valid option.");
			}
		} // While
	}

	public void foodTruckMenu(Scanner scanner) {
		System.out.println("Please select from the following list of options.");
		System.out.println("--------------------");
		System.out.println("-----          -----");
		System.out.println("-1. List all food trucks");
		System.out.println("-2. Display average rating of food trucks");
		System.out.println("-3. DIsplay the highest rated food truck");
		System.out.println("-4. Exit the program");
		System.out.println("-----          -----");
		System.out.println("--------------------");
		int selection = scanner.nextInt();

		boolean keepGoing = true;
		while (keepGoing) {
			switch (selection) {
			case 1:
				System.out.println(fleetOfFoodTrucks.toString());

			}
		}

	}

}
