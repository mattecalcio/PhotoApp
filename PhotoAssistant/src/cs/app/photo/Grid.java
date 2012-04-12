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

public class Grid extends Activity {
	/** Called when the activity is first created. */
	
	ArrayList<String> values = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	ListView listView;
	
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);

		listView = (ListView) findViewById(R.id.gridList);
		values.add("Grid1");
		values.add("Grid2");
		values.add("Grid3");
		values.add("Grid4");
		values.add("Grid5");
		values.add("Grid6");
		values.add("Grid7");
		values.add("Grid8");
		values.add("Grid9");
		values.add("Grid10");

		// First paramenter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the View to which the data is written
		// Forth - the Array of data
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// Assign adapter to ListView
		listView.setAdapter(adapter);
		
		//Start intent before we get into the list view selection
		final Intent gridPage = new Intent();
		gridPage.setClass(this,GridPage.class);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				//Start an activity here that takes you to the contract info
				//if(position == 0){
					startActivity(gridPage);
				//}
			}
		});

	}
	
	public void onCreateNewClick(View button){
		EditText gridName = (EditText)findViewById(R.id.newGridName);
		TextView name = (TextView)findViewById(R.id.textView22);
		
		
		if(gridName.getText().toString().isEmpty()){
			name.setTextColor(Color.RED);
		}else{
			values.add(gridName.getText().toString());
			adapter.notifyDataSetChanged();
			name.setTextColor(Color.BLACK);
			gridName.setText("");
			listView.setSelection(adapter.getCount()-1);
			
		}
		
	}
	
	/*public String[] copyArray(String [] oldArr, String gridName){
		String[] newArr = new String[oldArr.length+1];
		for(int x=0; x<oldArr.length; x++){
			newArr[x] = oldArr[x];
		}
		newArr[newArr.length-1] = gridName;
		return newArr;
	}*/
	

}