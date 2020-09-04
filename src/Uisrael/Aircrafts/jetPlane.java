package Aircrafts;

public class jetPlane {
    private Weather weatherTower;
    
    protected jetPlane(final String name, final Coordinates coordinates){
    super();
    }
    
    public void updateConditions(){
        
    }
    public void registerTower(final Weather Tower){
        
    }

	public jetPlane(Weather weatherTower) {
		this.weatherTower = weatherTower;
	}
}
