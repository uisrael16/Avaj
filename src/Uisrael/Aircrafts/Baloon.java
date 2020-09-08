package Aircrafts;

import Interface.Flyable;

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;
    
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        //System.out.println("Current: " + weather);
        System.out.println("Tower say: Baloon# " + this.name + "(" + id +") registered to weather tower.");
        



       
        if (weather.equalsIgnoreCase("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 2, coordinates.getLatitude() + 0, coordinates.getHeight() + 4);
             System.out.println("Baloon# " + this.name +"("+ id +") Hello out there in this beautiful Sunny day");
        }
        else if (weather.equalsIgnoreCase("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 5);
            System.out.println("Baloon# " + this.name +"("+ id +") Get your Rain suite ready... its raining out there!!!");
        }
        else if (weather.equalsIgnoreCase("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 3);
            System.out.println("Baloon# " + this.name +"("+ id +")  path is unclear... look out for Fog");
        }
        else if (weather.equalsIgnoreCase("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 15);
            System.out.println("Baloon# " + this.name +"("+ id +")  we will freeze to death!!!");
        }
        if (this.coordinates.getHeight() < 1)
        {
         
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
     //   System.out.println("Registered"  + this.name + this.id);
     
    }

	// @Override
	// public void registerTower(Object weatherTower) {
	// 	// TODO Auto-generated method stub

	// }
}