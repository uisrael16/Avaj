import Uisrael;

import java.io.*;
import java.lang.String;

public class Main {
    public static int repeatSimulation;
    public static String lineReader;
    public static int lineArgs;
    private static BufferedReader target;

    static WeatherTower weatherTower = new WeatherTower();

    static void file_validation() throws IOException {
        try {
            lineArgs = 1;
            while ((lineReader = target.readLine()) != null) {
                if (lineArgs == 1)
                {
                    try {
                        repeatSimulation = Integer.parseInt(lineReader);
                        if (repeatSimulation < 0){
                            System.out.println("Error: first line of scenario file must be a POSITIVE integer.");
                            System.exit(0);
                        }
                    } catch (NumberFormatException nfe) {System.out.println("Error: first line of scenario file is expecting 1 parameter."); System.exit(0);}
                }else {
                    String[] array;
                    array = lineReader.split(" ");
                    if (array.length == 1 && array[0].isEmpty())
                        continue;
                    if (array.length != 5) {
                        System.out.println("Error: Each line after line 1 on scenario file requires 5 parameters");
                        System.exit(0);
                    }else {
                        try {
                            AircraftFactory aircraftFactory = new AircraftFactory();
                            aircraftFactory.newAircraft(array[0], array[1], Integer.parseInt(array[2]), Integer.parseInt(array[3]), Integer.parseInt(array[4])).registerTower(weatherTower);
                        } catch (NumberFormatException nfe) {
                            System.out.println("Error: Scenario file should follow this format <String> <String> <Int> <Int> <Int>");
                            System.exit(0);
                        }
                    }
                }
                lineArgs++;
            }
        }catch (NullPointerException npe){System.out.println("Error: Could not find and read file"); System.exit(0);}
        WeatherProvider weatherProvider = WeatherProvider.getProvider();
        while (repeatSimulation > 0)
        {
            weatherTower.changeWeather();
            repeatSimulation--;
        }
    }

    static void file_handler(String FileName) throws IOException {
        try {
            target = new BufferedReader(new FileReader(FileName));
        } catch (FileNotFoundException e) {System.out.println("Error: An error occurred trying to read a file."); System.exit(0);}
        file_validation();

    }

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            file_handler(args[0]);
        } else{
            System.out.println("Error: Only one argument expected");
            System.exit(0);}
        return;
    }
}