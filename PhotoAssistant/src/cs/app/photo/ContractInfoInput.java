package cs.app.photo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class ContractInfoInput extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contract_info_input);



	}

	public void onNextContractClick(View button){
		EditText fullName = (EditText)findViewById(R.id.firstLastName);
		EditText date = (EditText) findViewById(R.id.date);
		EditText email = (EditText) findViewById(R.id.email);
		

		if(fullName.getText().toString().isEmpty() || 
				date.getText().toString().isEmpty() ||
				email.getText().toString().isEmpty() ){
			
			TextView warnFullName = (TextView)findViewById(R.id.textView2);
			warnFullName.setText("First Last Name");
			TextView warnDate = (TextView)findViewById(R.id.textView3);
			warnDate.setText("Date");
			TextView warnEmail = (TextView)findViewById(R.id.textView4);
			warnEmail.setText("Email");
			
			if(fullName.getText().toString().isEmpty()){
				warnFullName.setTextColor(Color.RED);
			}else{
				warnFullName.setTextColor(Color.BLACK);
			}
			if(date.getText().toString().isEmpty()){
				warnDate.setTextColor(Color.RED);
			}else{
				warnDate.setTextColor(Color.BLACK);
			}
			if(email.getText().toString().isEmpty()){
				warnEmail.setTextColor(Color.RED);
			}else{
				warnEmail.setTextColor(Color.BLACK);
			}
		}else{
			Intent contractView = new Intent();
			contractView.setClass(this,ContractView.class);

			contractView.putExtra("fullName", fullName.getText().toString());
			contractView.putExtra("date", date.getText().toString());
			contractView.putExtra("email", email.getText().toString());

			startActivity(contractView);
		}
	}

}