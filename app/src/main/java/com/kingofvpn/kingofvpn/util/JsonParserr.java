package com.kingofvpn.kingofvpn.util;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by Firnas on 12/21/2017.
 */


public class JsonParserr  {
    static InputStream is = null;
    //static InputStream is;
    static JSONObject jObj;
    //static JSONObject jObj = null;

    static String json = "";


    public JsonParserr() {

    }

    // function get json from url
    // by making HTTP POST or GET mehtod
    public JSONObject makeHttpRequest(String url, String method,
                                      StringEntity se) {

        // Making HTTP request
        try {

            // check for request method
            if(method == "POST"){
                // request method is POST
                // defaultHttpClient
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost(url);
                // httpPost.setEntity(new UrlEncodedFormEntity(params));
                httpPost.setEntity(se);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();

            }
            /*else if(method == "GET"){
                // request method is GET
                DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
            }*/

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = "";
            //line.isEmpty();
            while ((line = reader.readLine()) !=null) {
                //sb.append(line + "\n");
                sb.append(line);
            }
            is.close();
            json = sb.toString();
        }  catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            e.printStackTrace();
        }
        Log.i("tagconvertstr", "["+json+"]");
        Log.d("JSON Parser", json);
        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
            e.printStackTrace();
        }

        // return JSON String
        return jObj;
    }
    public static JSONObject getjObj() {
        return jObj;
    }

    public static void setjObj(JSONObject jObj) {
        JsonParserr.jObj = jObj;
    }
}
