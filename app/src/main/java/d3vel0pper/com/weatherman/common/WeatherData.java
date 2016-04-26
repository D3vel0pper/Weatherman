package d3vel0pper.com.weatherman.common;

import android.graphics.Bitmap;

/**
 * Created by D3velopper on 2016/04/18.
 * use this api for connecting↓
 * http://weather.livedoor.com/weather_hacks/webservice
 * And also this class is container for data u'v gotten
 * U MUST Determine which data u use or show
 */
public class WeatherData {

    public WeatherData(){

    }

    //description whether of where
    private String wTitle = "";
    private String descriptionText = "";
    //public String[] wForcast;
    //area + "/" + prefecture + "/" + city
    private String wLocation = "";
    /**
     * provider.name + ":" + provider.link + "\n" + link + "\n + title"
     */
    private String wCopyright = "";
    private String ImgURL;


    //Setters
    public void setTitle(String title){
        if(title==null){
            return;
        }
        this.wTitle = title;
    }

    public void setDescriptionText(String descriptionText){
        if(descriptionText==null){
            return;
        }
        this.descriptionText = descriptionText;
    }

    /**
     *
     * @param location must be formed in area + " / " + prefecture + " / " + city
     */
    public void setLocation(String location){
        if(location==null){
            return;
        }
        this.wLocation = location;
    }

    /**
     *
     * @param copyright must be formed in provider.name + " : " + provider.link + "\n" + link + "\n + title"
     */
    public void setwCopyright(String copyright){
        if(copyright==null){
            return;
        }
        this.wCopyright = copyright;
    }

    //Getters

    public String getTitle(){
        return this.wTitle;
    }

    public String getDescriptionText(){
        return this.descriptionText;
    }

    public String getLocation(){
        return this.wLocation;
    }

    public String getCopyright(){
        return this.wCopyright;
    }

}
