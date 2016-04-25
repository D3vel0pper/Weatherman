package d3vel0pper.com.weatherman.common;

import android.app.Activity;
import android.os.AsyncTask;
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

    public HttpResponseTask(Activity activity,LinearLayout ll){
        this.LocBaseUrl = activity.getString(R.string.LocBaseUrl);
        this.act = activity;
        this.linearLayout = ll;
    }

    @Override
    protected void onPreExecute(){
        super.onPreExecute();
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
            data.setTitle(jsonObject.getString("title"));
            //data.setDescriptionText(jsonObject.getJSONObject("description").getString("text"));
            data.setDescriptionTime(jsonObject.getJSONObject("description").getString("publicTime"));
            data.setLocation(jsonObject.getJSONObject("location").getString("area") + " / " +
                    jsonObject.getJSONObject("location").getString("prefecture") + " / " +
                    jsonObject.getJSONObject("location").getString("city"));
            JSONArray jsonArray = jsonObject.getJSONObject("copyright").getJSONArray("provider");
            JSONObject temp = jsonArray.getJSONObject(0);
            data.setwCopyright(temp.getString("name") + " : " + temp.getString("link") + "\n" +
                    jsonObject.getJSONObject("copyright").getString("link") + "\n" + jsonObject.getJSONObject("copyright").getString("title"));

        } catch(JSONException e){
            //Log.d("JSONException",e.toString());
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
            /*
            TextView wTitle = (TextView)linearLayout.findViewById(R.id.wTitle);
            wTitle.setText(data.getTitle());
            TextView descTime = (TextView)linearLayout.findViewById(R.id.descTime);
            descTime.setText(data.getDescriptionTime());
            TextView descText = (TextView)linearLayout.findViewById(R.id.description);
            descText.setText(data.getDescriptionText());
            TextView wLocation = (TextView)linearLayout.findViewById(R.id.location);
            wLocation.setText(data.getLocation());
            TextView wCopyright = (TextView)linearLayout.findViewById(R.id.copyright);
            wCopyright.setText(data.getCopyright());
            linearLayout.invalidate();
            */
        }
    }


}