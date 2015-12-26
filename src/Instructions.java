
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Instructions {

   ArrayList<String> Instructions = new ArrayList<String>();
   String[] grid;
   ArrayList<String[]> initialLocations = new ArrayList<String[]>();
   ArrayList<String[]> Directions = new ArrayList<String[]>();


    public Instructions(String file) {
        try {

            BufferedReader input = new BufferedReader(new FileReader(file));
            String str = input.readLine();
            while (str != null) {
                Instructions.add(str);
                str = input.readLine();
            }
            input.close();
            grid = Instructions.get(0).split(" ");
            Instructions.remove(0);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public ArrayList<String[]> readVehicleLocations() {
        for (String str : Instructions) {
            int line = Instructions.indexOf(str);
            if (line % 2 == 0) {
                String[] splitString = str.split(" ");
                initialLocations.add(splitString);
            }
        }
        return initialLocations;
    }

    public ArrayList<String[]> readDirections() {
        for (String str : Instructions) {
            int line = Instructions.indexOf(str);
            if (line % 2 != 0) {
                String[] splitString = str.split("");
                Directions.add(splitString);
            }
        }
        return Directions;

    }

    public String[] getGrid(){
        return grid;
    }
}