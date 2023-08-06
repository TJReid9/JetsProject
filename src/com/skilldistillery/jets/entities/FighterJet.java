package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements FighterClass {

	public FighterJet(String model, double speed, int range, double price) {
		super(model, speed, range, price);
		
	}

	@Override
	public void dogFight() {
		System.out.println("Engaging targets!");
		System.out.println("Taking evasive menuvers!");
		System.out.println("I'm hit! I'm hit! Waahhh!");
	}

	@Override
	public void fly() {
		double flightTime = getRange() / getSpeed();
		System.out.println("FighterJet Flight Time: " + flightTime);

		
	}

	

	

}
