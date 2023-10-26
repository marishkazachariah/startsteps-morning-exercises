package week_8.day_4;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Vehicle implements Externalizable {
    private String make;
    private String model;
    private int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Vehicle() {

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(make);
        out.writeObject(model);
        out.writeInt(year);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        make = (String) in.readObject();
        model = (String) in.readObject();
        year = in.readInt();
    }
}
