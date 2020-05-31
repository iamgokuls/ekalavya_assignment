package org.module_two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AppTwo 
{
   public String print() {
	   return "Accessed Module Two";
   }
   
   public Object getWeather()  {
	
	   String LOCATION="India";
	   String API_KEY="6afc0afd4994ef2e27c0aa0157ac63f2";
	   String url = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION+"&appid="+API_KEY;
	   
	try {
		
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
		//int responsecode=conn.getResponseCode();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		return in.readLine();
		
	} catch (MalformedURLException e) {
		System.out.println("error getting url");
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("IO exception");
		e.printStackTrace();
	}
	
	
	   return null;
   }
}
