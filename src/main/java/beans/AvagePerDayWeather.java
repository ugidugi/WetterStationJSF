/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Dao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pojo.Weather;

@ManagedBean(name="avage")
@SessionScoped
public class AvagePerDayWeather {
    private Dao dao = new Dao();
    private Weather weather = dao.avageVeatherPerDay();
    
    public double getTemperature(){
        return weather.getTemperature();
    }
    public double getSpeedwind(){
        return weather.getSpeedWind();
    }
    public double getPressure(){
        return weather.getPressure();
    }
    public int getHumidity(){
        return weather.getHumidity();
    }
    public double getRadiation(){
        return weather.getRadiation();
    }
    public double getPrecipitation(){
        return weather.getPrecipitation();
    }
}
