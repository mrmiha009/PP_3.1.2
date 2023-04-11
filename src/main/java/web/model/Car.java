package web.model;

public class Car {
    private String model;
    private String series;
    private int speed;

    public Car(String model, String series, int speed) {
        this.model = model;
        this.series = series;
        this.speed = speed;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
