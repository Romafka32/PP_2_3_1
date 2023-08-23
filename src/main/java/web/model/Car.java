package web.model;

public class Car {
    private String model;
    private int serial;
    private String type;

    public Car(String model, int serial, String type) {
        this.model = model;
        this.serial = serial;
        this.type = type;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
