package deserialize;


public class Car {
     
    String make;
    String model;
    int year;
     
    public Car() {      
    }
     
    public Car(String make, String model, int year) {
         
        this.make = make;
        this.model = model;
        this.year = year;
    }
     
    public String getMake() {
        return this.make;
    }
 
    public void setMake(String make) {
        this.make = make;
    }
     
    public String toString() {
        return "My car is a " + this.year + " " + this.make + " " + this.model;
    }
}