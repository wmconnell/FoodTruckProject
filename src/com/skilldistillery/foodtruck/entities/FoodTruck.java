package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private int truckID;
	private String truckName;
	private String truckFoodType;
	private int truckRating;

	public FoodTruck() {
	}

	public FoodTruck(int truckID) {
		this.truckID = truckID;
	}

	public FoodTruck(int truckID, String truckName, String truckFoodType, int truckRating) {
		this(truckID);
		this.truckName = truckName;
		this.truckFoodType = truckFoodType;
		this.truckRating = truckRating;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getTruckFoodType() {
		return truckFoodType;
	}

	public void setTruckFoodType(String truckFoodType) {
		this.truckFoodType = truckFoodType;
	}

	public double getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(int truckRating) {
		this.truckRating = truckRating;
	}

	@Override
	public String toString() {
		return "[truck ID = " + truckID + ", Name = " + truckName + ", Food type = " + truckFoodType
				+ ", Rating = " + truckRating + "]";
	}

}
