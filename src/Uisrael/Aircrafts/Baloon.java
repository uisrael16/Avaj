package Aircrafts;

import Interface.Flyable;

public class Baloon extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;
    
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
    
    public void updateConditions() {
        String weather = this.weatherTower.getWeather(coordinates);
        System.out.println("Current: " + weather);




       
        if (weather.equalsIgnoreCase("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 2, coordinates.getLatitude() + 0, coordinates.getHeight() + 4);
             System.out.println("Hello  helloe hellfsvla vskj vfkv");
        }
        else if (weather.equalsIgnoreCase("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 5);
            System.out.println("GHDja sdngf ghgfg");
        }
        else if (weather.equalsIgnoreCase("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 3);
            System.out.println("GHDja sdngf ghgfg11111");
        }
        else if (weather.equalsIgnoreCase("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 15);
            System.out.println("GHDja sdngf ghgfg2222");
        }
        if (this.coordinates.getHeight() < 1)
        {
         
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        System.out.println("Registered"  + this.name + this.id);
     
    }

	// @Override
	// public void registerTower(Object weatherTower) {
	// 	// TODO Auto-generated method stub

	// }
}