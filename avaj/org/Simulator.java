import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Simulator {
	private void createFile() {
		File myObj = new File("simulation.txt");
		System.out.println("File created: " + myObj.getName());	
	}
	public static void main(String[] args) {
	try	{
		if (args.length == 1) {
			this.createFile();
			WeatherTower wt = new WeatherTower();
			File myObj = new File(args[0]);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] arrOfStr = data.split(" ", 0);
				if (arrOfStr.length == 1) {
					int numOfSimul = Integer.parseInt(arrOfStr[0]);
				}
				else if (arrOfStr.length == 5) {
					String type = arrOfStr[0];
					String name = arrOfStr[1];
					int	longitude = Integer.parseInt(arrOfStr[2]);
					int latitude = Integer.parseInt(arrOfStr[3]);
					int height = Integer.parseInt(arrOfStr[4]);
					Flyable aircraft = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
					
					wt.register(aircraft);
				}
				else {
					throw new WrongFormatException("File format is invalid");
				}
				System.out.println(data);
			}
			myReader.close();
			WeatherProvider wp = WeatherProvider.getProvider();
			wt.conditionChanged();

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
