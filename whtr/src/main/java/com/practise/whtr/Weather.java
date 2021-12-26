package com.practise.whtr;

public class Weather {

	private double lat,lon;
	private String description;
	private double temp_feel;
	private double temp_min;
	private double temp_max;
	private int pressure;
	private int humidity;
	private int visibility;
	private double wind_speed,wind_deg;
	private double clouds;
	private double rain_1h=0.0;
	private double snow_1h=0.0;
	private double uvi,dewpoint;
	private String timezone;

	@Override
	public String toString() {
		return "Weather [lat=" + lat + ", lon=" + lon + ", description=" + description + ", temp_feel=" + temp_feel
				+ ", temp_min=" + temp_min + ", temp_max=" + temp_max + ", pressure=" + pressure + ", humidity="
				+ humidity + ", visibility=" + visibility + ", wind_speed=" + wind_speed + ", wind_deg=" + wind_deg
				+ ", clouds=" + clouds + ", rain_1h=" + rain_1h + ", snow_1h=" + snow_1h + ", uvi=" + uvi
				+ ", dewpoint=" + dewpoint + ", timezone=" + timezone + "]";
	}

	
	public double getSnow_1h() {
		return snow_1h;
	}


	public void setSnow_1h(double snow_1h) {
		this.snow_1h = snow_1h;
	}


	public String getTimezone() {
		return timezone;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTemp_feel() {
		return temp_feel;
	}

	public void setTemp_feel(double temp_feel) {
		
		this.temp_feel = (double) Math.round(temp_feel*100)/100;
	}

	public double getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(double temp_min) {
		this.temp_min = (double) Math.round(temp_min*100)/100;
	}

	public double getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(double temp_max) {
		this.temp_max = (double) Math.round(temp_max*100)/100;
	}

	public int getPressure() {
		return pressure;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public double getWind_speed() {
		return wind_speed;
	}

	public void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}

	public double getWind_deg() {
		return wind_deg;
	}

	public void setWind_deg(double wind_deg) {
		this.wind_deg = wind_deg;
	}

	public double getClouds() {
		return clouds;
	}

	public void setClouds(double clouds) {
		this.clouds = clouds;
	}

	public double getRain_1h() {
		return rain_1h;
	}

	public void setRain_1h(double rain_1h) {
		this.rain_1h = rain_1h;
	}

	public double getUvi() {
		return uvi;
	}

	public void setUvi(double uvi) {
		this.uvi = uvi;
	}

	public double getDewpoint() {
		return dewpoint;
	}

	public void setDewpoint(double dewpoint) {
		this.dewpoint = (double) Math.round(dewpoint*100)/100;
	}

	
	
	
}
