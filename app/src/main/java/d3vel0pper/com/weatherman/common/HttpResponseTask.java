package d3vel0pper.com.weatherman.common;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import d3vel0pper.com.weatherman.R;

/**
 * Created by D3vel0pper on 2016/04/24.
 */
public class HttpResponseTask extends AsyncTask<Void,Void,WeatherData> {

    private String LocBaseUrl;
    private Activity act = null;
    //layout which have each textview to show
    private LinearLayout linearLayout;
    private ProgressDialog progressDialog;

    public HttpResponseTask(Activity activity, LinearLayout ll){
        this.LocBaseUrl = activity.getString(R.string.LocBaseUrl);
        this.act = activity;
        this.linearLayout = ll;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
        progressDialog = new ProgressDialog(act);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
    }

    @Override
    protected WeatherData doInBackground(Void... params){

        String result = null;

        //Make Request Object
        Request request = new Request.Builder()
                .url(LocBaseUrl + "?city=400040").get().build();
        //Make Client Object
        OkHttpClient client = new OkHttpClient();
        //Request then get result
        try {
            Response response = client.newCall(request).execute();
            result = response.body().string();
        } catch(IOException e){
            //Log.d("IOException",e.toString());
        }
        //make instance of Data
        WeatherData data = new WeatherData();
        //get JSON Data and then put to the Data structure
        try{
            JSONObject jsonObject = new JSONObject(result);
            JSONObject temp;
            //Title
            data.setTitle(jsonObject.getString("title"));
            temp = jsonObject.getJSONObject("location");
            //Location
            data.setLocation(temp.getString("area") + " / " +
                    temp.getString("prefecture") + " / " +
                    temp.getString("city"));
            //Copyrights
            String copyright;
            JSONArray jsonArray = jsonObject.getJSONObject("copyright").getJSONArray("provider");
            temp = jsonArray.getJSONObject(0);
            copyright = temp.getString("name") + " : " + temp.getString("link") + "\n";
            temp = jsonObject.getJSONObject("copyright");
            copyright += temp.getString("link") + "\n" + temp.getString("title");
            data.setwCopyright(copyright);
            //Temperature
            jsonArray = jsonObject.getJSONArray("forecasts");
            temp = jsonArray.getJSONObject(0);

            JSONObject temp2 = temp.getJSONObject("temperature");
            if(temp2.isNull("max")){
                data.setTemperatureMax("-");
            } else {
                data.setTemperatureMax(temp2.getJSONObject("max").getString("celsius"));
            }
            temp2 = temp.getJSONObject("temperature");
            if(temp2.isNull("min")){
                data.setTemperatureMin("-");
            } else {
                data.setTemperatureMin(temp2.getJSONObject("min").getString("celsius"));
            }
            /*
             maybe at here need dataLabel
             */

            //Image
            data.setImgURL(temp.getJSONObject("image").getString("url"));
            //telop
            data.setTelopText(temp.getString("telop"));

            //Detail
            data.setDetailTaxt(jsonObject.getJSONObject("description").getString("text"));





        } catch(JSONException e){
            //Log.d("JSONException", e.toString());
        }

        //Return
        return data;
    }

    @Override
    protected void onPostExecute(WeatherData data){
        super.onPostExecute(data);

        if(data == null){
            Toast.makeText(act, "!! result is null !!", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(act,"Now You Can Get Start To Access", Toast.LENGTH_SHORT).show();

            TextView wTitle,telopText,temperatureMax,temperatureMin,wCopyright;
            ImageView temperatureImg;

            //Title
            wTitle = (TextView)linearLayout.findViewById(R.id.wTitle);
            wTitle.setText(data.getTitle());
            //description text of forecast
            telopText = (TextView)linearLayout.findViewById(R.id.telopText);
            telopText.setText(data.getTelopText());
            //Max temperature
            temperatureMax = (TextView)linearLayout.findViewById(R.id.temperatureMax);
            temperatureMax.setText(temperatureMax.getText() + data.getMaxTemperature());
            //Min temperature
            temperatureMin = (TextView)linearLayout.findViewById(R.id.temperatureMin);
            temperatureMin.setText(temperatureMin.getText() + data.getMinTemperature());

            //Copyright
            wCopyright = (TextView)linearLayout.findViewById(R.id.wCopyright);

            temperatureImg = (ImageView)linearLayout.findViewById(R.id.wImage);


            wCopyright.setText(data.getCopyright());
            progressDialog.dismiss();

        }
    }


}
