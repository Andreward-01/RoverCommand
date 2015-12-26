
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class RoverCommand {

    public static void main(String[] args) {
        Instructions instruct1 = new Instructions("src/rover_instructions.txt");
        ArrayList<String[]> initialLocations = instruct1.readVehicleLocations();
        ArrayList<String[]> directionsArray = instruct1.readDirections();
        String[] grid = instruct1.getGrid();
        ArrayList<Rover> Rovers = new ArrayList<Rover>();
        int roverCount = initialLocations.size();

        for (int i=0; i<roverCount; i++) {
            Rovers.add(new Rover(initialLocations.get(i),grid));
        }


        for (int i = 0; i < roverCount; i++) {
            Rovers.get(i).Move(directionsArray.get(i));
            String[] location = Rovers.get(i).getLocation();
            System.out.println("Rover " + (i+1) + "'s location is [" + location [0] + " " + location[1] + " " + location[2] + "]") ;
        }
    }
}
