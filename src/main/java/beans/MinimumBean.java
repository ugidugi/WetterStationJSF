
package beans;

import dao.Dao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import pojo.Weather;

@ManagedBean(name = "minimum_bean")
@SessionScoped
public class MinimumBean {
    private Dao dao = new Dao();
    private Weather weather = dao.getMinTemperature();
    
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
