import java.util.List;

public class main {
 
	public static void main(String[] args) throws Exception {
		
		// loads text paths
		String vehiclePath = "C:/Users/Kyle/Desktop/vehicles.txt";
		String peoplePath = "C:/Users/Kyle/Desktop/people.txt";
		String matchPath = "C:/Users/Kyle/Desktop/people_vehicles.txt";
		
		// creates objects for each path
		TextReader VR = new TextReader();
		TextReader PR = new TextReader();
		MatchTasks match = new MatchTasks();
		
		// adds each line in the text file to a list element
		List<String> vList = VR.readTextFile(vehiclePath);
		List<String> pList = PR.readTextFile(peoplePath);
		List<String> matchList = match.readTextFile(matchPath);
		
		// creates variables for printing information below
		String currentMatchup = "";
		int numPeople = PR.numberPeople(peoplePath);
		String currentPerson = "";
		
		// loops through each line in the people_vehicle.txt file and prints the person with their cars
		for (int i = 0; i < numPeople; i++) {
			currentMatchup = match.findMatchElement(matchList, i);
			currentPerson = match.findPersonKey(currentMatchup);
			String[] currentVehicle = match.findVehicleKeys(currentMatchup);
			System.out.print(VR.findElement(pList, Integer.parseInt(currentPerson)-1) + " owns: ");
			for (int j = 0; j < match.numVehicles(currentMatchup); j++) {
				if (match.numVehicles(currentMatchup) - 1 == j) {
					System.out.print(VR.findElement(vList, Integer.parseInt(currentVehicle[j])-1) + ".\n");
				} else System.out.print(VR.findElement(vList, Integer.parseInt(currentVehicle[j])-1) + " & ");
			}
		}
		
		
		/* ****** UNCOMMENT TO APPEND TO A TEXT FILE *******
		// Appends text file with user input
		TextWriter TW = new TextWriter(); // creates TextWriter object
		TW.appendText(matchPath, "Hello"); // adds the inputted "text" to whichever file "path" is given
		 */	
	
	}
}
