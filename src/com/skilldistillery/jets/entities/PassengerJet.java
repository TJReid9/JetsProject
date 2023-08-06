package com.skilldistillery.jets.entities;

public class PassengerJet extends Jet {
	

	public PassengerJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public void fly() {
		double flightTime = getRange() / getSpeed();
		System.out.println("PassengerJet Flight Time:  " + flightTime);

	}

}
