package Aircrafts;

import Interface.Flyable;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        //String weather = weatherTower.getWeather(this.coordinates);
        String weather = this.weatherTower.getWeather(coordinates);
        System.out.println("Tower say: Helicopter# " + this.name + "(" + id +") registered to weather tower.");

        if (weather.equalsIgnoreCase("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 10, coordinates.getLatitude() + 0, coordinates.getHeight() + 2);
            System.out.println("Helicopter# " + this.name +"("+ id +") : its a bright day out side there... its super hot!!!");
        } 
        else if (weather.equalsIgnoreCase("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 5, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
            System.out.println("Baloon# " + this.name +"("+ id +") : I don't really like rain..... ");
        }
        else if (weather.equalsIgnoreCase("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 1, coordinates.getLatitude() + 0, coordinates.getHeight() + 0);
            System.out.println("Helicopter# " + this.name +"("+ id +") : the visibility is unclear because of the Fog");
        }
        else if (weather.equalsIgnoreCase("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() + 12);
            System.out.println("Helicopter " + this.name +"("+ id +") : please dress up warm... its cold out there!!");
        }
        if (this.coordinates.getHeight() < 1)
        {
           
        }

    }
    
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
       // System.out.println("Registered hello");
    }

   // @Override

}