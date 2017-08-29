
package beans;

import dao.Dao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import pojo.Weather;

@ManagedBean(name = "maximum_bean")
@SessionScoped
public class MaximumBean {
    private Dao dao = new Dao();
    private Weather weather = dao.getMaxTemperature();
    
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
