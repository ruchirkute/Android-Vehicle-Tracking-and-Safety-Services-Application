package com.cs551androidproject.gpstransmitter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SigninActivity extends AsyncTask<String,Void,String>{

    private int byGetOrPost = 0;

    public SigninActivity() {
    }



    protected void onPreExecute(){

    }

    @Override
    protected String doInBackground(String... arg0) {
        if(byGetOrPost == 0){ //means by Get Method

            try{
                String lat = (String)arg0[0];
                String lng = (String)arg0[1];
                String device = (String)arg0[2];
                String code = (String)arg0[3];

                String link = "http://ruchraj.co.in/Android/ind.php?lat="+lat+"&lng="+lng+"&device="+device+"&code="+code;

                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line="";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                in.close();
                return sb.toString();
            }

            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
        else{
            try{
                String lat = (String)arg0[0];
                String lng = (String)arg0[1];
                String device = (String)arg0[2];
                String code = (String)arg0[3];

                String link="http://ruchraj.co.in/Android/ind.php";
                String data  = URLEncoder.encode("lat", "UTF-8") + "=" + URLEncoder.encode(lat, "UTF-8");
                data += "&" + URLEncoder.encode("lng", "UTF-8") + "=" + URLEncoder.encode(lng, "UTF-8");
                data += "&" + URLEncoder.encode("device", "UTF-8") + "=" + URLEncoder.encode(device, "UTF-8");
                data += "&" + URLEncoder.encode("code", "UTF-8") + "=" + URLEncoder.encode(code, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
    }

    @Override
    protected void onPostExecute(String result){
    }
}
