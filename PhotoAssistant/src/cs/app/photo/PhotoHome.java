package cs.app.photo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class PhotoHome extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void onContractsClick(View button){
    	Intent contractsIntent = new Intent();
    	contractsIntent.setClass(this,Contracts.class);
    	
    	startActivity(contractsIntent);
    }
    
    public void onPhotosClick(View Button){
    	Intent photosIntent = new Intent();
    	photosIntent.setClass(this,Photos.class);
    	
    	startActivity(photosIntent);
    }
    
    public void onGridClick(View Button){
    	Intent gridIntent = new Intent();
    	gridIntent.setClass(this,Grid.class);
    	
    	startActivity(gridIntent);
    }
    
    public void onSettingsClick(View Button){
    	Intent gridIntent = new Intent();
    	gridIntent.setClass(this,Settings.class);
    	
    	startActivity(gridIntent);
    }
}