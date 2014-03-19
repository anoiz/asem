package com.example.smartchat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;

import com.korovyansk.android.slideout.SlideoutActivity;

public class UtamaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//if(Build.VERSION.SDK_INT< Build.VERSION_CODES.HONEYCOMB)finish();
		setContentView(R.layout.chatmenu);
		/*if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
	    	getActionBar().hide();
	    }*/
		findViewById(R.id.chat_btn).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
						SlideoutActivity.prepare(UtamaActivity.this, R.id.inner_content, width);
						startActivity(new Intent(UtamaActivity.this,
								MenuActivity.class));
						overridePendingTransition(0, 0);
					}
				});
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == android.R.id.home){
			int width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
			SlideoutActivity.prepare(UtamaActivity.this, R.id.inner_content, width);
			startActivity(new Intent(UtamaActivity.this, MenuActivity.class));
			overridePendingTransition(0, 0);
		}
		return true;
	}
}
