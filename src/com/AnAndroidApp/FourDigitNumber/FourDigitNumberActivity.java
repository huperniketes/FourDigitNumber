package com.AnAndroidApp.FourDigitNumber;

import com.geoloqi.android.sdk.service.LQService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class FourDigitNumberActivity extends Activity
{
	String geoAppID = "6577b9038c1ce5471fa553091bf9f605";
	String geoAppSecret = "fd695ffc43b5f37e1bf4c0b726572fc7";
	WebView map;
	double latitude = 0;
	double longitude = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        map = (WebView) findViewById(R.id.webView1);
        
        //Geo stuff
        // Start the tracking service
        Intent intent = new Intent(this, LQService.class);
        intent.setAction(LQService.ACTION_DEFAULT);
        intent.putExtra(LQService.EXTRA_SDK_ID, geoAppID);
        intent.putExtra(LQService.EXTRA_SDK_SECRET, geoAppSecret);
        startService(intent);
        
        
        map.loadUrl("http://www.mapquestapi.com/staticmap/v3/getmap?key=Fmjtd%7Cluua2duanu%2Cbg%3Do5-hrtlh&size=400,400&zoom=7&center="+ latitude + "," + longitude);
    }
    
    /*private void setupMap(double lat, double lon)
    {
    	this.map = (MapView) findViewById(R.id.mapView);
    	this.map.getController().setCenter(new GeoPoint(lat,lon));
    	this.map.getController().setZoom(5);
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}*/
}