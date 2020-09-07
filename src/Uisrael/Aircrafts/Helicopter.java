package Aircrafts;

import Interface.Flyable;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

        if (weather.equalsIgnoreCase("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 10, coordinates.getLatitude() + 0, coordinates.getHeight() + 2);
        }
        else if (weather.equalsIgnoreCase("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 5, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
           
        }
        else if (weather.equalsIgnoreCase("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 1, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
            System.out.println("Hello  helloe hellfsvla vskj vfkv");
        }
        else if (weather.equalsIgnoreCase("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() + 12);
        }
        if (this.coordinates.getHeight() < 1)
        {
           
        }

    }
    
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
       // System.out.println("Registered hello");
    }

   // @Override

}