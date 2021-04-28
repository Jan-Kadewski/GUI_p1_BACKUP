public abstract class Vehicle {
    private String marka;
    private String model;
    private String engineType;
    private double engineCapicity;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getEngineCapicity() {
        return engineCapicity;
    }

    public void setEngineCapicity(double engineCapicity) {
        this.engineCapicity = engineCapicity;
    }

    public double getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(double numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    double numberOfWheels;


}
