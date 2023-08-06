package com.skilldistillery.jets.app;
import com.skilldistillery.jets.entities.*;
import java.util.Scanner;
public class JetsApp {
	Scanner kb = new Scanner(System.in);
	AirField af = new AirField();

	
	public static void main(String[] args) {
		JetsApp japp = new JetsApp();
		japp.run();
		

	}
	public void run() {
		af.readJets();		
		int choice = 0;
		
		while (choice != 9) {
			appMenu();
			choice = kb.nextInt();
			switch (choice) {
			case 1:
				af.listAllJets();				
				break;
			case 2:
				af.flyAllJets();
				break;
			case 3:
				af.viewFastestJet();
				break;
			case 4:
				af.viewLongestRange();
				break;
			case 5:
				af.loadAllCargo();
				break;
			case 6:
				af.dogFight();
				break;
			case 7:
				af.addJet(kb);
				break;
			case 8:
				af.removeJet(kb);
				break;
			case 9:
				System.out.println("Thank you for using the Jets App! GoodBye.");
				break;
			default:
				System.err.println("Error! Please choose again.");
				break;
			}
			kb.hashCode();
		}		
	}
		
		public void appMenu() {
			
		System.out.println("|======================================|");
		System.out.println("| Choose one of the following options: |");
		System.out.println("| 1. List Fleet                        |");
		System.out.println("| 2. Fly all jets                      |");
		System.out.println("| 3. View fastest jet                  |");
		System.out.println("| 4. View jet with longest range       |");
		System.out.println("| 5. Load all Cargo Jets               |");
		System.out.println("| 6. Dogfight!                         |");
		System.out.println("| 7. Add a jet to the Fleet            |");
		System.out.println("| 8. Remove a jet from the Fleet       |");
		System.out.println("| 9. Quit                              |");
		System.out.println("|======================================|");
		
		
	}
}
