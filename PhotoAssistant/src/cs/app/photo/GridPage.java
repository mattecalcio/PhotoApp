package cs.app.photo;

import java.util.Timer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class GridPage extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_page);
        
        ImageView iv = (ImageView)findViewById(R.id.gridBlock);
        iv.setScaleType(ScaleType.FIT_XY);
    }
    
    //not there anymore
    public void onDoneClick(View button){
    	Intent reset = new Intent();
		reset.setClass(this,Grid.class);

	    reset.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    
	    
	    startActivity(reset);  
    }
    
    public void onSaveClick(View buton){
    	TextView setText = (TextView)findViewById(R.id.successSave);
    	setText.setText("Save was successful");
    	setText.setTextColor(Color.GREEN);
    	
    	//long startTime = System.currentTimeMillis();
    	
    	//while(System.currentTimeMillis() - startTime < 1000){
    		//wait 5 seconds
    		setText.setText("Save was successful");
        	setText.setTextColor(Color.GREEN);
    	//}
    	
    	//setText.setText("");
    }
    
    
    
}