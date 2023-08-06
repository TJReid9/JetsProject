package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {

	private List<Jet> hangerBay = new ArrayList<>();

	public void readJets() {
		String readFile = "jets.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(readFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] jetList = line.split(",");
				String jetType = jetList[0];
				String model = jetList[1];
				double speed = Double.parseDouble(jetList[2]);
				int range = Integer.parseInt(jetList[3]);
				double price = Double.parseDouble(jetList[4]);

				if (jetType.equals("Passenger")) {
					Jet passengerJet = new PassengerJet(model, speed, range, price);
					hangerBay.add(passengerJet);
				} else if (jetType.equals("FighterClass")) {
					Jet fighterJet = new FighterJet(model, speed, range, price);
					hangerBay.add(fighterJet);
				} else if (jetType.equals("CargoCarrier")) {
					Jet cargoJet = new CargoShip(model, speed, range, price);
					hangerBay.add(cargoJet);
				}
			}

		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void listAllJets() {
		for (Jet jetList : hangerBay)
			System.out.println(jetList);
	}

	public void flyAllJets() {
		for (Jet jets : hangerBay) {
			jets.fly();
		}
	}

	public void viewFastestJet() {
		Jet fastest = hangerBay.get(0);
		for (Jet jet : hangerBay) {
			if (jet.getSpeed() > fastest.getSpeed()) {
				fastest = jet;
			}
		}
		System.out.println("The fastest Jet is: " + fastest);
	}

	public void viewLongestRange() {
		Jet longestRange = hangerBay.get(0);
		for (Jet jet : hangerBay) {
			if (jet.getRange() > longestRange.getRange()) {
				longestRange = jet;
			}
		}
		System.out.println("The Jet with the longest range is: " + longestRange);

	}

	public void loadAllCargo() {
		for (Jet load : hangerBay) {
			if (load instanceof CargoCarrier) {
				((CargoCarrier) load).loadCargo();
			}
		}
	}

	public void dogFight() {
		for (Jet fight : hangerBay) {
			if (fight instanceof FighterClass) {
				((FighterClass) fight).dogFight();
			}
		}
	}

	public void addJet(Scanner kb) {
		Jet newJet = null;
		int jetChoice = 0;
		String type = null;

		System.out.println("|==================|");
		System.out.println("| Choose Your Jet: |");
		System.out.println("| 1. Passenger Jet |");
		System.out.println("| 2. Cargo Carrier |");
		System.out.println("| 3. Fighter Class |");
		System.out.println("|==================|");

		jetChoice = kb.nextInt();
		kb.nextLine();

		switch (jetChoice) {
		case 1:
			type = "Passenger Jet";
			break;
		case 2:
			type = "Cargo Carrier";
			break;
		case 3:
			type = "Fighter Class";
			break;
		default:
			type = "Invalid Choice";
		}
		System.out.println("What model is your Jet?");
		String model = kb.nextLine();

		System.out.println("How fast is your Jet?");
		double speed = kb.nextDouble();

		System.out.println("What is the range of your Jet?");
		int range = kb.nextInt();

		System.out.println("How much does your Jet cost?");
		double price = kb.nextInt();

		if (type.equals("Passenger Jet")) {
			newJet = new PassengerJet(model, speed, range, price);
		}
		if (type.equals("Cargo Carrier")) {
			newJet = new CargoShip(model, speed, range, price);
		}
		if (type.equals("Fighter Class")) {
			newJet = new FighterJet(model, speed, range, price);
		}
		hangerBay.add(newJet);
		System.out.println("Jet Added");

	}
	public void removeJet(Scanner kb) {
		int count = 1;
		int modelToRemove = 0;
		System.out.println("What model of Jet do ypu wish to remove?");
		for (Jet jet : hangerBay) {
			System.out.println(" " + count + " " + jet.getModel());
			count++;
		}
		modelToRemove = kb.nextInt();
		kb.nextLine();
		hangerBay.remove(modelToRemove -1); 
		System.out.println("Jet Removed");
	}
}
