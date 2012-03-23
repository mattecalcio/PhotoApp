package cs.app.photo;

import java.util.ArrayList;

import cs.app.photo.Photos.ImageAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class PhotosSelected extends Activity {
	Integer[] pictures;

	ImageView imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//Get the pictures the user selected 
		Bundle bundle = getIntent().getExtras();
		ArrayList<Integer>tempPics = bundle.getIntegerArrayList("Selections");
		pictures = tempPics.toArray(new Integer[0]);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photos_selected);
		
		Gallery gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setSpacing(10);
		

		imageView = (ImageView)findViewById(R.id.ImagePreview);
		
		gallery.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id){
				imageView.setImageResource(pictures[position]);

			}
		});
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
