package com.example.usericonpicker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.usericonpicker.util.ImageUtil;
import com.example.usericonpicker.util.Logger;

public class MainActivity extends ActionBarActivity {
	private ImageView imageView ;
	ImageUtil imageUtil;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imageView = (ImageView)findViewById(R.id.imageview);

		imageUtil = new ImageUtil(this) {
			
			@Override
			public void uploadIconToServer(String FilePath) {
				Logger.d("ImagePath:"+FilePath);
				
				Bitmap bitmap = imageUtil.getBitMapByWidthHeight(FilePath, 500, 500);
				imageView.setImageBitmap(bitmap);
			}
		};
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_capture) {
			imageUtil.startWork(false);
		} else if (id == R.id.action_select) {
			imageUtil.startWork(true);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		imageUtil.setOnActivityResult(requestCode, resultCode, data);
	}
}
