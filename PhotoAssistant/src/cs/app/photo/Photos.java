package cs.app.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
	ImageView imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.photos);

		Gallery gallery = (Gallery) findViewById(R.id.gallery);
		gallery.setAdapter(new ImageAdapter(this));
		gallery.setSpacing(10);

		imageView = (ImageView)findViewById(R.id.ImagePreview);
		gallery.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View v, int position, long id){
				//Scaling preview picture
				/*LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(300, 270);
				imageView.setLayoutParams(layoutParams);*/
				
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
			//imageView.setAdjustViewBounds(true);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setLayoutParams(new Gallery.LayoutParams(100, 70));
			imageView.setBackgroundResource(imageBackground);

			return imageView;
		}

	}


}

