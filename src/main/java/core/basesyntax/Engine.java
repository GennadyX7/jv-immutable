package core.basesyntax;

import java.util.Objects;

public class Engine implements Cloneable {
    private int horsePower;
    private String manufacturer;

    public Engine(int horsePower, String manufacturer) {
        if (manufacturer == null) {
            throw new NullPointerException("Manufacturer cannot be null.");
        }
        this.horsePower = horsePower;
        this.manufacturer = manufacturer;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsePower, manufacturer);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Engine engine = (Engine) obj;
        return horsePower == engine.horsePower && Objects.equals(manufacturer, engine.manufacturer);
    }

    @Override
    public Engine clone() {
        try {
            Engine cloneEngine = (Engine) super.clone();
            cloneEngine.manufacturer = this.manufacturer;
            cloneEngine.horsePower = this.horsePower;
            return cloneEngine;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create Engine clone", e);
        }
    }

    @Override
    public String toString() {
        return "Engine{"
            + "horsePower=" + horsePower
            + ", manufacturer='" + manufacturer + '\''
            + '}';
    }
}
