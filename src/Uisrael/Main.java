import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import Aircrafts.AircraftFactory;
import Aircrafts.WeatherTower;
//import Interface.Flyable;

import java.io.FileWriter;
import java.io.PrintWriter;

//import Aircrafts.Aircraft;
// import Aircrafts.AircraftFactory;

public class Main {
    // private static final String weatherTower = null;

   // private static final Object WeatherTower = null;

    public static void main(String[] args) throws IOException {

        if (args.length == 1) {
            try {
                File myfile = new File(args[0]);
                Scanner arg = new Scanner(myfile);
                ArrayList<String> data = new ArrayList<String>();
                int i = 0;
                while (arg.hasNextLine()) {
                    data.add(arg.nextLine());
                    // System.out.println(data.get(i++));

                }
                arg.close();

                try {
                    PrintWriter information = new PrintWriter(new FileWriter("simulation.txt", true), true);
                    String Message = " Baloon B2 1 8 77 ";
                    information.println(Message);
                    information.close();
                } catch (NumberFormatException ex) {
                    System.err.println("Invalid string in argumment");
                }

                if (data.get(0) != null) {
                    int index = Integer.parseInt(data.get(0));
                    if (index < 0) {
                        System.err.println("incorrect number " + index + " number cant be a Negetive");
                        System.exit(1);
                    }

                    // try {
                    // data.get(0);
                    // index = Integer.parseInt(data.get(0));

                    // } catch (NumberFormatException e) {

                }
                {
                    i = 1;
                    WeatherTower weatherTower = new WeatherTower();
                    while (i < data.size()) {

                        String line[] = data.get(i).split("\\s+");
                        try {
                            //System.out.println(line[0]);

                            AircraftFactory.newAircraft(line[0], line[1], Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])).registerTower(weatherTower);
                  
                            // Flyable flyable = AircraftFactory.newAircraft((line[0]), (line[1]),
                            //          Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])))
                            //          weatherTower.registerTower(WeatherTower);
                        } catch (Exception e) {
                            System.out.println("couldn't get the coordinates");
                            System.exit(1);
                        }

                        if (line.length != 5) {
                            System.err.println("Params must be 5 ");
                            System.exit(1);
                        }
                        
                        //System.out.println(line[2]);
                        i++;
                           
                    } 
                    weatherTower.changeWeather();
                    weatherTower.changeWeather();
                }
                
            
            } catch (FileNotFoundException e) {
                System.err.println("Invalid File");
                e.printStackTrace();
            }

        } else
            System.err.println("No Param");
    }
}