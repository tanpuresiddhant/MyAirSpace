package com.example.tarun.myairspace;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Siddhant on 3/11/2017.
 */

public class JsonTask extends AsyncTask<String, String, String> {

    protected void onPreExecute() {
        super.onPreExecute();

    }

    protected String doInBackground(String... params) {
        System.out.println("HI");

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();


            InputStream stream = connection.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                //    if(line.contains("United States")) {
                buffer.append(line + "\n");
                Log.d("Response: ", "> " + line);   //here u ll get whole response...... 🙂
                // }
            }
            return buffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
//        JSONObject obj = null;
//        try {
//            obj = new JSONObject(result);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        JSONArray states = null;
//        try {
//            states = obj.getJSONArray("states");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        final int n = states.length();
//        System.out.println(n);
//
//        for (int i = 0; i < n; ++i) {
//            String str = null;
//            try {
//                str = states.getString(i);
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }



            //String str = "[0, 1, 2, 3,4,5,6,7,8,9,,10,11,12]";
            //String[] str1 = str.split(",");
            //if((str1[5]!=) && (str1[6]!=)) {
            // if ((Float.valueOf(str1[5]) < 38) & (Float.valueOf(str1[5]) > 28)) {
            //   if (Float.valueOf(str1[6]) < -106 & Float.valueOf(str1[6]) > -116) {
            //  System.out.println(Float.parseFloat(str1[5]) + " " + Float.parseFloat(str1[6]));
            //     }
//                }
            //     //String resultF = str1[5].replaceAll("[\\""]","");
            //       if(str1[5].matches(".*\\d+.*") || str1[5].matches(".*\\d+.*") ) {
            //            if ((Float.parseFloat(str1[5]) < 38) && (Float.parseFloat(str1[5]) > 28)) {
            //               if (Float.parseFloat(str1[6]) < 36 && Float.parseFloat(str1[6]) > 25) {
            //               System.out.println(Float.parseFloat(str1[5]) + " " + Float.parseFloat(str1[6]));
            //                 }
            //               }
//            }

            //System.out.println();
            //  JSONObject states = states.getJSONObject(i);
            //  System.out.println(states.getString());
            //System.out.println(person.getString("name"));
            //System.out.println(person.getString("gender"));
            //System.out.println(person.getDouble("latitude"));
            //System.out.println(person.getDouble("longitude"));
   //     }
        //return result;
    }
}
