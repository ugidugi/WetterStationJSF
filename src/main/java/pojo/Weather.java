
package pojo;

import java.util.Date;
import services.Service;


public class Weather {
    private int id;
    private String date;
    private int directionWind;
    private double speedWind;
    private double temperature;
    private int humidity;
    private double radiation;
    private double pressure;
    private double precipitation;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date.substring(0, 19);
    }
    
    public int getDirectionWind() {
        return directionWind;
    }

    public void setDirectionWind(int directionWind) {
        this.directionWind = directionWind;
    }

    public double getSpeedWind() {
        return speedWind;
    }

    public void setSpeedWind(double speedWind) {
        this.speedWind = speedWind;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        if(humidity>=100){
            humidity = 99;
        }
        this.humidity = humidity;
    }

    public double getRadiation() {
        return radiation;
    }

    public void setRadiation(double radiation) {
        this.radiation = radiation;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }
}
