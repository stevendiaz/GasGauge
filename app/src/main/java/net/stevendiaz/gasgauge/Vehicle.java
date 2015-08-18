package net.stevendiaz.gasgauge;

/**
 * Created by stevendiaz on 8/12/15.
 */
public class Vehicle {


    private String vehicleName;
    private int odometer;
    private int averageMPG;
    private int gallonsInTank;


    public static String SHARED_PREFERENCES = "getsharedpreferences";
    public static String NAME_KEY = "vehiclename";
    public static String ODOMETER_KEY = "odometer";
    public static String GALLONS_KEY = "gallons";
    public static String MPG_KEY = "avgmpg";


    public Vehicle(String name, int odometer, int gallons){
        vehicleName = name;
        this.odometer = odometer;
        gallonsInTank = gallons;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setmOdometer(int odometer) {
        this.odometer = odometer;
    }

    public int getAverageMPG() {
        return averageMPG;
    }

    public void setAverageMPG(int averageMPG) {
        this.averageMPG = averageMPG;
    }

    public int getGallonsInTank() {
        return gallonsInTank;
    }

    public void setGallonsInTank(int gallonsInTank) {
        this.gallonsInTank = gallonsInTank;
    }

    @Override
    public String toString(){
        return "Name: " +vehicleName+ " odometer: " +odometer+ " gallons in tank: " + gallonsInTank;
    }
}
