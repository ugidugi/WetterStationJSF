/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Dao;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import pojo.Weather;

@ManagedBean(name = "weather_bean")
@SessionScoped
public class WeatherBeans {
    private Dao dao = new Dao();
    private Weather weather = dao.getWeather();
    
    public String getDate() {
        return weather.getDate();
    }
    public int getDirectionWind() {
        return weather.getDirectionWind();
    }

    public double getSpeedWind() {
        return weather.getSpeedWind();
    }

    public double getTemperature() {
        return weather.getTemperature();
    }

    public int getHumidity() {
        return weather.getHumidity();
    }

    public double getRadiation() {
        return weather.getRadiation();
    }

    public double getPressure() {
        return weather.getPressure();
    }

    public double getPrecipitation() {
        return weather.getPrecipitation();
    }
}
