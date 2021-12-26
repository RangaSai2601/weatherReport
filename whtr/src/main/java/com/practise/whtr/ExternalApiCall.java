package com.practise.whtr;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Component
public class ExternalApiCall {

	private String city;
	private double lat,lon;
	
	public Weather callFunction(String city) {
		
		String str=null;
		Weather whthr=new Weather();
		int appid=5689;                            // enter valid appid num provided by weather api;
		try {
		String uri=	"https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+appid;
		RestTemplate rst=new RestTemplate();
		str=rst.getForObject(uri, String.class);
		}
		catch(Exception ex) {
			return null;
		}
		
	    JSONObject response=new JSONObject(str);
	    int cod=response.getInt("cod");
	   
	    if(cod!=200) {
	    	return null;
	    }
	    
		JSONObject coord=response.getJSONObject("coord");
		whthr.setLat(coord.getDouble("lat"));
		whthr.setLon(coord.getDouble("lon"));
		
		JSONArray wher=response.getJSONArray("weather");
		JSONObject weather=wher.getJSONObject(0);
		whthr.setDescription(weather.getString("description"));
		
		JSONObject main=response.getJSONObject("main");
		whthr.setTemp_feel(main.getDouble("feels_like")-273.15);
		whthr.setTemp_min(main.getDouble("temp_min")-273.15);
		whthr.setTemp_max(main.getDouble("temp_max")-273.15);
		whthr.setPressure(main.getInt("pressure"));
		whthr.setHumidity(main.getInt("humidity"));
		
		whthr.setVisibility(response.getInt("visibility"));
		
		JSONObject wind=response.getJSONObject("wind");
		whthr.setWind_speed(wind.getDouble("speed"));
		whthr.setWind_deg(wind.getDouble("deg"));
		
		JSONObject clouds=response.getJSONObject("clouds");
		whthr.setClouds(clouds.getDouble("all"));
		
		if(!response.isNull("rain")) {
		JSONObject rain=response.getJSONObject("rain");
		whthr.setRain_1h(rain.getDouble("1h"));
		}
		
		if(!response.isNull("snow")) {
			JSONObject snow=response.getJSONObject("snow");
			whthr.setSnow_1h(snow.getDouble("1h"));
			}
		
		whthr=secondCall(whthr);
		
		return whthr;
		
	}
	
	public Weather secondCall (Weather whtr) {
		
		double lat=whtr.getLat();
		double lon = whtr.getLon();
		
		String str="https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&exclude=hourly,minutely,daily&appid=29215139bf2fb68daf1c9575d368a42a";
		RestTemplate rst=new RestTemplate();
		String res=rst.getForObject(str, String.class);
		
		JSONObject response=new JSONObject(res);
		whtr.setTimezone(response.getString("timezone"));
		
		JSONObject current = response.getJSONObject("current");
		whtr.setDewpoint(current.getDouble("dew_point")-273.15);
		whtr.setUvi(current.getDouble("uvi"));
		
		return whtr;
	}
	
}
