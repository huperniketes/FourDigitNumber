package com.AnAndroidApp.FourDigitNumber;

import com.geoloqi.android.sdk.service.LQService;
import com.mapquest.android.maps.GeoPoint;
import com.mapquest.android.maps.MapActivity;
import com.mapquest.android.maps.MapView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FourDigitNumberActivity extends MapActivity
{
	String geoAppID = "6577b9038c1ce5471fa553091bf9f605";
	String geoAppSecret = "fd695ffc43b5f37e1bf4c0b726572fc7";
	MapView map;
	double latitude;
	double longitude;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Intent intent = new Intent(this, LQService.class);
        intent.setAction(LQService.ACTION_DEFAULT);
        intent.putExtra(LQService.EXTRA_SDK_ID, geoAppID);
        intent.putExtra(LQService.EXTRA_SDK_SECRET, geoAppSecret);
        startService(intent);
        
        //Geo stuff.
        NetworkThread geoloqi = new NetworkThread();
        geoloqi.execute();
        while(geoloqi.isAlive());
        {
        	//Just chill.
        }
        //Setup a map.
        setupMap(geoloqi.getLat(), geoloqi.getLong());
    }
    
    private void setupMap(double lat, double lon)
    {
    	this.map = (MapView) findViewById(R.id.mapView);
    	this.map.getController().setCenter(new GeoPoint(lat,lon));
    	this.map.getController().setZoom(5);
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}