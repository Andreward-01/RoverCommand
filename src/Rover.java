import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

public class Rover{

    private static int roverCount;
    private static ArrayList<ArrayList<Integer>> roverLocations = new ArrayList<ArrayList<Integer>>();
    private Location location = new Location();
    private int[] worldBoundary;
    private int roverNumber;
    private static Hashtable<String, Integer> compass = new Hashtable<String, Integer>();

    public Rover(String[] initialLocation, String[] gridSize) {
        compass.put("N", 0);
        compass.put("E", 1);
        compass.put("S", 2);
        compass.put("W", 3);
        int Orientation = compass.get(initialLocation[2]);
        ArrayList<Integer> roverCheck = new ArrayList<Integer>();
        roverCheck.add(Integer.parseInt(initialLocation[0]));
        roverCheck.add(Integer.parseInt(initialLocation[1]));
        int[] gridCheck = {Integer.parseInt(gridSize[0]), Integer.parseInt(gridSize[1])};
        if (roverCheck.get(0) <= gridCheck[0] && roverCheck.get(1) <= gridCheck[1] && !roverLocations.contains(roverCheck)) {
            roverLocations.add(roverCheck);
            location.setx(roverCheck.get(0));
            location.sety(roverCheck.get(1));
            location.setOrientation(Orientation);
            worldBoundary = gridCheck;
            roverCount += 1;
            roverNumber = roverCount;
        }
        else {
            roverCount +=1;
            System.out.println("Rover " + roverCount + " cannot be placed here, there is already another rover here");
            roverCount -=1;
        }
    }

    public void Move(String[] Directions) {
        String[] directionsCheck = {"R", "L", "M"};
        for (String str : Directions) {
            str = str.toUpperCase();
            if (Arrays.asList(directionsCheck).contains(str)) {
                if (str.equals("R")) {
                    location.setOrientation(((location.getOrientation() + 1) % 4+4)%4);}
                else if (str.equals("L")) {
                    location.setOrientation(((location.getOrientation() - 1) % 4+4)%4);}
                else if (str.equals("M")) {
                    if (location.getOrientation() == 0 && location.gety()<worldBoundary[1]){
                        location.sety(location.gety() + 1);}
                    else  if (location.getOrientation() == 1 && location.getx()<worldBoundary[0]){
                        location.setx(location.getx()+1);}
                    else if (location.getOrientation() == 2 && location.gety()>0){
                        location.sety(location.gety() - 1);}
                    else if (location.getOrientation() == 3 && location.getx()>0){
                        location.setx(location.getx() - 1);}
                    else{
                        System.out.println("Rover " +roverNumber+ " cannot Move off grid");}
                    }
                }
            else {
                System.out.println("Incorrect Character error, please check instructions for " + roverNumber );
            }
        }
    }

    public String[] getLocation(){
        Hashtable<Integer, String> reverseCompass = new Hashtable<Integer, String>();
        reverseCompass.put(0, "N");
        reverseCompass.put(1, "E");
        reverseCompass.put(2, "S");
        reverseCompass.put(3, "W");
        String[] locationString = new String[3];
        locationString[0]=Integer.toString(location.getx());
        locationString[1]=Integer.toString(location.gety());
        locationString[2]=reverseCompass.get(location.getOrientation());
        return locationString;
    }
}