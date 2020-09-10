package Aircrafts;

import java.util.ArrayList;

import Interface.Flyable;

public abstract class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    /**
     * This iterate through a list of flyables and calls for update of each
     * flyable's condition
     */
    protected void conditionsChanged(){
        for (int i = 0; i < observers.size(); i++){
            observers.get(i).updateConditions();
        }
    }
}