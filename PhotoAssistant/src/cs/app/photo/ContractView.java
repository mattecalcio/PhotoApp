package cs.app.photo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;

public class ContractView extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contract_view);
		
	
	}
	
	public void onSignClick(View button){
		ImageView signature = (ImageView)findViewById(R.id.imageView1);
		
		signature.setImageResource(R.drawable.white_banner_sig);
		
	}
	
	
}