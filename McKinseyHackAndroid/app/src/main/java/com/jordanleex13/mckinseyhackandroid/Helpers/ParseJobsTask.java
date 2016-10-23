package com.jordanleex13.mckinseyhackandroid.Helpers;

import android.os.AsyncTask;
import android.util.Log;

import com.jordanleex13.mckinseyhackandroid.Models.Job;
import com.jordanleex13.mckinseyhackandroid.Managers.JobManager;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Jordan on 2016-10-22.
 */

public class ParseJobsTask extends AsyncTask<Object, Object, Object> {

    public static final String TAG = ParseJobsTask.class.getSimpleName();

    @Override
    protected Object doInBackground(Object... params) {
        try {
            httpGet();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Uses Indeed API to get JSON files online and parses them into the Job Data structure
     * @throws IOException
     * @throws JSONException
     */
    public void httpGet() throws IOException, JSONException {
        String in = "http://api.indeed.com/ads/apisearch?" +
                "publisher=2863597559522400&format=json&q=java&l=london%2C+gb&sort=" +
                "&radius=&st=&jt=&start=&limit=100&fromage=&filter=&latlong=1&co=gb&chnl=" +
                "&userip=1.2.3.4&useragent=Mozilla/%2F4.0%28Firefox%29&v=2";


        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = httpclient.execute(new HttpGet(in));


        StatusLine statusLine = response.getStatusLine();

        if(statusLine.getStatusCode() == HttpStatus.SC_OK){
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            response.getEntity().writeTo(out);


            String responseString = out.toString();
            Log.d(TAG, responseString);



            JSONObject reader = new JSONObject(responseString);

            //Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = reader.optJSONArray("results");
            for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String jobTitle = jsonObject.optString("jobtitle");
                String company = jsonObject.optString("company");
                String city = jsonObject.optString("city");
                String state = jsonObject.optString("state");
                String country = jsonObject.optString("country");
                String description = jsonObject.optString("snippet");
                String url = jsonObject.optString("url");
                float latitude = Float.parseFloat(jsonObject.optString("latitude"));
                float longitude = Float.parseFloat(jsonObject.optString("longitude"));


                Job curr = new Job(jobTitle, company, city, state, country, description, url, latitude, longitude);
                JobManager.addJob(curr);

            }



            out.close();
        } else{
            //Closes the connection.
            response.getEntity().getContent().close();

        }
    }
}
