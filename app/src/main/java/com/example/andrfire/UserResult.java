package com.example.andrfire;

public class UserResult {
    public int ResultId;
    public String TokenId;
    public double Latitude;
    public double Longtitude;
    public float Temperature;
    public float Humidity;
    public float AirQuality;

    public UserResult() {

    }

    public UserResult(String tokenId) {
        this.TokenId = tokenId;
    }

    public UserResult(int resultId, String tokenId, double latitude,
                      double longtitude, float temperature,
                      float humidity, float airQuality) {
        ResultId = resultId;
        TokenId = tokenId;
        Latitude = latitude;
        Longtitude = longtitude;
        Temperature = temperature;
        Humidity = humidity;
        AirQuality = airQuality;
    }
}
