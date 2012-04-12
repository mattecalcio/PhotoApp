package cs.app.photo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

public class Contracts extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contracts);

		ListView listView = (ListView) findViewById(R.id.contractsList);
		String[] values = new String[] { 
				"Professional Models", 
				"Amateur Models", 
				"Minors",
				"Basic Form 1", 
				"Basic Form 2", 
				"Basic Form 3", 
				"Basic Form 4", 
				"Basic Form 5",
				"Basic Form 6", 
				"Basic Form 7" 
		};

		// First paramenter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the View to which the data is written
		// Forth - the Array of data
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// Assign adapter to ListView
		listView.setAdapter(adapter);
		
		//Start intent before we get into the list view selection
		final Intent infoPage = new Intent();
		infoPage.setClass(this,ContractInfoInput.class);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//Start an activity here that takes you to the contract info
				//if(position == 0){
					startActivity(infoPage);
				//}
			}
		});

	}

}