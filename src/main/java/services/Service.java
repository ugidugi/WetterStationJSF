
package services;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Service {
    
    public Date strToDate(String string ){
        Date date = null;
        String str = string.replaceAll(".0", "");
        try{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = df.parse(str);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return date;
    }
    
    public String dateToStr(Date date){
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String str = df.format(date);
       return str;
    }
    
    public String strDateForChart(Date date) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("MM.dd HH:mm");
        String str = df.format(date);
        return str;
    }
}
