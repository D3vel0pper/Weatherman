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
    private String detailText = "";
    private String telopText = "";
    //public String[] wForcast;
    //area + "/" + prefecture + "/" + city
    private String wLocation = "";
    /**
     * provider.name + ":" + provider.link + "\n" + link + "\n + title"
     */
    private String wCopyright = "";
    private String ImgURL = "";
    private String temperatureMax = "";
    private String temperatureMin = "";
    //flag
    private boolean flag = false;



    //Setters
    public void setTitle(String title){
        if(title==null){
            return;
        }
        this.wTitle = title;
    }

    public void setDetailTaxt(String detailText){
        if(detailText==null){
            return;
        }
        this.detailText = detailText.replaceAll("\n\n"," ");
        this.detailText = this.detailText.replaceAll("\n","");
        this.detailText = this.detailText.replaceAll(" ","\n");
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

    public void setImgURL(String url){
        this.ImgURL = url;
    }

    public void setTemperatureMax(String temperatureMax){
        this.temperatureMax = temperatureMax;
    }

    public void setTemperatureMin(String temperatureMin){
        this.temperatureMin = temperatureMin;
    }

    public void setTelopText(String telopText){
        this.telopText = telopText;
    }

    public void standFlag(){
        this.flag = true;
    }

    public void dropFlag(){
        this.flag = false;
    }

    //Getters

    public String getTitle(){
        return this.wTitle;
    }

    public String getTelopText(){
        return this.telopText;
    }

    public String getLocation(){
        return this.wLocation;
    }

    public String getCopyright(){
        return this.wCopyright;
    }

    public String getMaxTemperature(){
        return this.temperatureMax;
    }

    public String getMinTemperature(){
        return this.temperatureMin;
    }

    public String getDetailText(){
        return this.detailText;
    }

    public String getImgURL(){
        return this.ImgURL;
    }

    public boolean getFlag(){
        return this.flag;
    }

}
