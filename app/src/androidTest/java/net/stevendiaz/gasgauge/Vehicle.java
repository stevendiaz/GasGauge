package net.stevendiaz.gasgauge;

/**
 * Created by stevendiaz on 8/12/15.
 */
public class Vehicle {
    private String vehicleName;
    private int odometer;
    private int averageMPG;
    private int gallonsInTank;

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
}
