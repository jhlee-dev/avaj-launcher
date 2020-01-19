package org.us._42.avaj;

import org.us._42.avaj.*;
import org.us._42.avaj.aircraft.*;
import org.us._42.avaj.exceptions.*;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Simulator {
	private static void createFile() {
		File f = new File("simulation.txt");
		if(f.exists() && !f.isDirectory()) {
    		if (f.delete()) {
				System.out.println("File successfully delted: " + f.getName());
				f = new File("simulation.txt");
			}
		}
		System.out.println("File created: " + f.getName());	
	}
	public static void main(String[] args) {
	try	{
		if (args.length == 1) {
			createFile();
			WeatherTower wt = new WeatherTower();
			File myObj = new File(args[0]);
			Scanner myReader = new Scanner(myObj);
			boolean first = true;
			int numOfSimul = 0;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] arrOfStr = data.split(" ", 0);
				if (arrOfStr.length == 1 && first) {
					numOfSimul = Integer.parseInt(arrOfStr[0]);
					first = false;
				}
				else if (arrOfStr.length == 5 && !first) {
					String type = arrOfStr[0];
					String name = arrOfStr[1];
					int	longitude = Integer.parseInt(arrOfStr[2]);
					int latitude = Integer.parseInt(arrOfStr[3]);
					int height = Integer.parseInt(arrOfStr[4]);
					Flyable aircraft = AircraftFactory.newAircraft(type, name, longitude, latitude, height);	
					if (aircraft != null) {
						aircraft.registerTower(wt);
						wt.register(aircraft);
					}
				}
				else {
					throw new WrongFormatException("File format is invalid");
				}
				System.out.println(data);
			}
			myReader.close();
			for (int i = 0; i < numOfSimul; i++) {
				wt.changeWeather();
			}

		} else {
			throw new NumOfArgsException("Number of arguments is not 1");
		}
	} catch (FileNotFoundException e) {
		System.out.println("An error occurred.");
		e.printStackTrace();
	} catch (WrongFormatException e) {
		System.out.println("An error occurred.");
		System.out.println(e.getMessage());
	} catch (NumOfArgsException e) {
		System.out.println("An error occurred.");
		System.out.println(e.getMessage());
	}
}
}
