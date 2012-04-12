package cs.app.photo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class Settings extends Activity {
	/** Called when the activity is first created. */
	
	ArrayList<String> values = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	ListView listView;
	
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

	}
	
	public void onUpdateClick(View button){
		EditText fullName = (EditText)findViewById(R.id.fullName);
		EditText email = (EditText) findViewById(R.id.emailInput2);
		
		
		if(!fullName.getText().toString().isEmpty()){
			TextView setText = (TextView)findViewById(R.id.currentDisplay);
			setText.setText(fullName.getText().toString());
			fullName.setText("");
			
		}
		if(!email.getText().toString().isEmpty()){
			TextView setText = (TextView)findViewById(R.id.currentEmail);
			setText.setText(email.getText().toString());
			email.setText("");
		}
	}
	

	

}