import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MatchTasks {

	// MatchTasks constructor used for the people_vehicles.txt file
	public MatchTasks() {

	}

	// reads the text file from a given file path and returns as a list (same as used in TextReader)
	public List<String> readTextFile(String filepath) throws Exception {
		// creates required objects for reading the file
		FileReader vehiclesFile = new FileReader(filepath);
		BufferedReader fileReader = new BufferedReader(vehiclesFile);

		// create list to add each vehicle
		List<String> newList = new ArrayList<String>();

		// reads the text within the vehicles.txt file and adds to the vehicleList
		String currentLine = fileReader.readLine();
		while (currentLine != null) {
			newList.add(currentLine);
			currentLine = fileReader.readLine();
		}
		// closes fileReader and returns list
		fileReader.close();
		return newList;
	}

	// loads each line in the match file but keeps info from BOTH sides of the equals sign - used for gathering a single line
	public String findMatchElement(List<String> list, int element) {
		String textLine = (String) list.get(element);
		return textLine;
	}

	// determines the number of vehicles owned by a person
	public int numVehicles(String matchElement) {

		int vehicleIndex = 0;
		
		// counts the number of vehicles a person owns
		for (int i = 0; i < matchElement.length(); i++) {
			if (matchElement.charAt(i) == ',') {
				vehicleIndex++;
			}
			if (i == (matchElement.length() - 1)) {
				vehicleIndex++;
			}
		}
		return vehicleIndex;
	}

	// finds the persons' ID
	public String findPersonKey(String matchElement) {

		String personKey = "";

		for (int i = 0; i < matchElement.length(); i++) {
			if (matchElement.charAt(i) == '=') {
				for (int j = 0; j < i; j++) {
					personKey += matchElement.charAt(j);
				}
			}

		}
		return personKey;
	}

	// finds the vehicle IDs
	public String[] findVehicleKeys(String matchElement) {

		String[] vehicleKey = { "", "", "", "", "", "", "", "", "", ""}; // allows a person to own up to 10 cars
		int vehicleIndex = 0;
		boolean personOrVehicle = true;
		int count = 0;

		
		for (int i = 0; i < matchElement.length(); i++) {
			// starts at the equal sign
			if (matchElement.charAt(i) == '=' && personOrVehicle) {
				personOrVehicle = false;
				i++;
				count = i;
			}
			// adds each number housed before a comma to vehicleKey
			if (matchElement.charAt(i) == ',' && !personOrVehicle) {
				for (int j = count; j < i; j++) {
					vehicleKey[vehicleIndex] += matchElement.charAt(j);
					personOrVehicle = false;
				}
				vehicleIndex++;
				i++;
				count = i;
			}
			// adds each number housed after a comma (the last number) to vehicleKey
			if (i == (matchElement.length() - 1) && !personOrVehicle) {
				for (int j = count; j < i + 1; j++) {
					vehicleKey[vehicleIndex] += matchElement.charAt(j);
					personOrVehicle = false;
				}
				vehicleIndex++;
				i++;
				count = i;
			}

		}
		return vehicleKey;
	}
	
}
