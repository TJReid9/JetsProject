package com.skilldistillery.jets.entities;

public class CargoShip extends Jet implements CargoCarrier {

	public CargoShip(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		
	}
	@Override
	public void loadCargo() {
		System.out.println("Loading Cargo!");
		System.out.println("Ahh! My back!");
		System.out.println("I'm getting too old for this.");

	}

	@Override
	public void fly() {
		double flightTime = getRange() / getSpeed();
		System.out.println("CargoShip Flight Time: " + flightTime);

	}
	

}
