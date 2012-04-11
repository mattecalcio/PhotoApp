package cs.app.photo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class ContractView extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contract_view);

		//disable send button
		Button send = (Button)findViewById(R.id.sendButton);
		send.setEnabled(false);
		
		//Get parameters from previous page
		Bundle bundle = getIntent().getExtras();
		String name = bundle.getString("fullName");
		String date = bundle.getString("date");
		String email = bundle.getString("email");

		String contract = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tModel Release\n\n" +
				"In consideration of my engagement as a model, upon the terms herewith stated, I hereby give to _____________________________ [photographer] his/her heirs, legal representatives and assigns, those for whom the photographer is acting, and those acting with his/her authority and permission:\n"+
				"\na)  the unrestricted right and permission to copyright and use, re-use, publish, and republish photographic portraits or pictures of me or in which I may be included intact or in part, composite or distorted in character or form, without restriction as to changes or transformations in conjunction with my own or a fictitious name, or reproduction hereof in color or otherwise, made through any and all media now or hereafter known for illustration, art, promotion, advertising, trade, or any other purpose whatsoever.\n"+
				"\nb)  I also permit the use of any printed material in connection therewith.\n"+
				"\nc)  I hereby relinquish any right that I may have to examine or approve the completed product or products or the advertising copy or printed matter that may be used in conjunction therewith or the use to which it may be applied.\n"+
				"\nd)  I hereby release, discharge and agree to save harmless [photographer], his/her heirs, legal representatives or assigns, and all persons functioning under his/her permission or authority, or those for whom he/she is functioning, from any liability by virtue of any blurring, distortion, alteration, optical illusion, or use in composite form whether intentional or otherwise, that may occur or be produced in the taking of said picture or in any subsequent processing thereof, as well as any publication thereof, including without limitation any claims for libel or invasion of privacy.\n"+
				"\ne)  I hereby affirm that I am over the age of majority and have the right to contract in my own name. I have read the above authorization, release and agreement, prior to its execution; I fully understand the contents thereof. This agreement shall be binding upon me and my heirs, legal representatives and assigns.\n"+
				"\nName: " +name+"\n"+
				"Date: " +date+"\n"+
				"Email: " +email+"\n";
		TextView contractView = (TextView)findViewById(R.id.contractView);
		contractView.setText(contract);

	}

	public void onSignClick(View button){
		ImageView signature = (ImageView)findViewById(R.id.imageView1);

		signature.setImageResource(R.drawable.white_banner_sig);

		//enable send button
		Button send = (Button)findViewById(R.id.sendButton);
		send.setEnabled(true);

	}
	
	public void onSendClick(View button){
		Intent reset = new Intent();
		reset.setClass(this,PhotoHome.class);

	    reset.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	    
	    //USED FOR BACK BUTTON FUNCTIONALITY
	    //Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP;
	    startActivity(reset);
	}


}