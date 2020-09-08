package Aircrafts;

import Interface.Flyable;

//import Interface.Flyable;

public  class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane( String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
         String weather = weatherTower.getWeather(this.coordinates);
         System.out.println("Tower say: JetPlane# " + this.name + "(" + id +") registered to weather tower.");
    

        if (weather.equalsIgnoreCase("SUN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
            System.out.println("JetPlane# " + this.name +"("+ id +") OMG a shinny hot day!!!!");
        }
        else if (weather.equalsIgnoreCase("RAIN")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 5, coordinates.getHeight() + 0);
            System.out.println("JetPlane# " + this.name +"("+ id +") I hate raining weather");            
        }
        else if (weather.equalsIgnoreCase("FOG")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 1, coordinates.getHeight() + 0);
            System.out.println("JetPlane# " + this.name +"("+ id +") fly careful these Fog out there");
                   
        }
        else if (weather.equalsIgnoreCase("SNOW")){
            this.coordinates = new Coordinates(coordinates.getLongitude()  + 0, coordinates.getLatitude() + 0, coordinates.getHeight() - 7);
            System.out.println("JetPlane# " + this.name +"("+ id +") watch out for Snow");
        }
        
        if (this.coordinates.getHeight() < 1)
        {
            this.weatherTower.unregister(this);
           
        }
    }
    @Override
    public void registerTower( WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
       // System.out.println("Registered one");
        
        
    }

	
	
}