
package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import pojo.Weather;
import util.HibernateUtil;


public class Dao {
    public Weather getWeather() {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();        
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Weather.class).setProjection(Projections.max("id"));
        List list = session.createQuery("FROM Weather where id=" +((int)criteria.uniqueResult())).list();
        session.getTransaction().commit();
        Weather weather = (Weather) list.get(0);
        return weather;
    }
    
    public Weather getMaxTemperature() {
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Weather weather = new Weather();
        
        Criteria criteria = session.createCriteria(Weather.class).setProjection(Projections.max("temperature"));
        weather.setTemperature((double) criteria.uniqueResult());
        criteria = session.createCriteria(Weather.class).setProjection(Projections.max("speedWind"));
        weather.setSpeedWind((double) criteria.uniqueResult());
        criteria = session.createCriteria(Weather.class).setProjection(Projections.max("humidity"));
        weather.setHumidity((int)criteria.uniqueResult());
        criteria = session.createCriteria(Weather.class).setProjection(Projections.max("pressure"));
        weather.setPressure((double) criteria.uniqueResult());
        criteria = session.createCriteria(Weather.class).setProjection(Projections.max("radiation"));
        weather.setRadiation((double) criteria.uniqueResult());
        session.getTransaction().commit();
        return weather;
    }
     public Weather getMinTemperature() {
                 
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Weather weather = new Weather();
        
        Criteria criteria = session.createCriteria(Weather.class).setProjection(Projections.min("temperature"));
        weather.setTemperature((double) criteria.uniqueResult());
        criteria = session.createCriteria(Weather.class).setProjection(Projections.min("speedWind"));
        weather.setSpeedWind((double) criteria.uniqueResult());
        criteria = session.createCriteria(Weather.class).setProjection(Projections.min("humidity"));
        weather.setHumidity((int)criteria.uniqueResult());
        criteria = session.createCriteria(Weather.class).setProjection(Projections.min("pressure"));
        weather.setPressure((double) criteria.uniqueResult());
        criteria = session.createCriteria(Weather.class).setProjection(Projections.min("radiation"));
        weather.setRadiation((double) criteria.uniqueResult());
        session.getTransaction().commit();
        return weather;
    }
     
    public Weather avageVeatherPerDay(){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Weather.class).setProjection(Projections.max("id"));
        List listLostWeather = session.createQuery("FROM Weather where id=" +((int)criteria.uniqueResult())).list();
        Weather stopDate = (Weather) listLostWeather.get(0);
        String startDate = stopDate.getDate().substring(0, 11)+"00:00:00";
        List list = session.createQuery("FROM Weather where date >='"+startDate+"' and date<='"+stopDate.getDate()+"'").list();
        session.getTransaction().commit();
        //return (Weather)list.get(0);
        return avageValue(list);
    }
    
    
    private Weather avageValue(List<Weather> list){
        double temperature = 0;
        double speedwind = 0;
        int humidity = 0;
        double radiation = 0;
        double pressure = 0;
        double precipitation = 0;
        Weather weather = new Weather();
        for(Weather w: list){
            temperature+=w.getTemperature();
            speedwind+=w.getSpeedWind();
            pressure+=w.getPressure();
            humidity+=w.getHumidity();
            radiation+=w.getRadiation();
            precipitation+=w.getPrecipitation();
        }
        weather.setTemperature( (Math.round(temperature/list.size()*10) / 10.0) );
        weather.setSpeedWind((Math.round(speedwind/list.size()*10) / 10.0));
        weather.setHumidity(humidity/list.size());
        weather.setPressure((Math.round(pressure/list.size()*10) / 10.0));
        weather.setRadiation((Math.round(radiation/list.size()*10) / 10.0));
        weather.setPrecipitation((Math.round(precipitation*10) / 10.0));
        return weather;
    }
}
