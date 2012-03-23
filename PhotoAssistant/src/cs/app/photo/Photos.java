package cs.app.photo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Photos extends Activity {
	Integer[] pictures = {
			R.drawable.sample_1,
			R.drawable.sample_2,
			R.drawable.sample_3,
			R.drawable.sample_4,
			R.drawable.sample_5,
			R.drawable.sample_6,
			R.drawable.sample_7
	};
	ArrayList<Integer>selectedPics = new ArrayList<Integer>();
	ImageView imageView;
	private int imagePos = -1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photos);


		Gallery gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setSpacing(10);
		

		imageView = (ImageView)findViewById(R.id.ImagePreview);
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id){
				TextView clearText = (TextView)findViewById(R.id.textView1);
				clearText.setText("");
				imagePos = position;
				imageView.setImageResource(pictures[position]);

			}
		});

	}

	public void onSelectClick(View button){
		//if the app just started and the user tries to select nothing do nothing 
		if(imagePos != -1){
			//Add the picture only if it hasn't been added yet
			if(!selectedPics.contains(pictures[imagePos])){
				selectedPics.add(pictures[imagePos]);
				TextView addText = (TextView)findViewById(R.id.textView2);
				addText = (TextView)findViewById(R.id.textView2);
				addText.setText("Selected: "+selectedPics.size());
				addText.setTextColor(Color.GREEN);
			}else{//if the picture was already added tell the user
				TextView warnText = (TextView)findViewById(R.id.textView1);
				warnText.setText("Photo already selected");
				warnText.setTextColor(Color.RED);
			}
		}
	}

	public void onClearClick(View button){
		if(imagePos != -1){
			if(selectedPics.contains(pictures[imagePos])){
				TextView clearText = (TextView)findViewById(R.id.textView1);
				clearText.setText("");
				selectedPics.remove(pictures[imagePos]);
				TextView warnText =  (TextView)findViewById(R.id.textView2);
				warnText.setText("Selected: "+selectedPics.size());
				warnText.setTextColor(Color.GREEN);
			}
		}
	}

	public void onNextClick(View button){
		if(selectedPics.isEmpty()){
			TextView warnText = (TextView)findViewById(R.id.textView1);
			warnText.setText("No photos have been selected");
			warnText.setTextColor(Color.RED);
		}else{
			Intent selectedPhotoIntent = new Intent();
			selectedPhotoIntent.setClass(this,PhotosSelected.class);

			selectedPhotoIntent.putExtra("Selections", selectedPics);
			startActivity(selectedPhotoIntent);
		}
	}


	public class ImageAdapter extends BaseAdapter {

		private Context ctx;
		int imageBackground;

		public ImageAdapter(Context c) {
			ctx = c;
			TypedArray ta = obtainStyledAttributes(R.styleable.HelloGallery);
			imageBackground = ta.getResourceId(R.styleable.HelloGallery_android_galleryItemBackground, 1);
			ta.recycle();
		}

		public int getCount() {
			return pictures.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView = new ImageView(ctx);

			imageView.setImageResource(pictures[position]);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(100, 70));
			imageView.setBackgroundResource(imageBackground);


			return imageView;
		}

	}


}

