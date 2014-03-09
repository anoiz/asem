package com.kodok.bangkong;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

	WebView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("Cipta Group");
		view =(WebView)findViewById(R.id.wview);
		WebSettings setting = view.getSettings();
		setting.setJavaScriptEnabled(true);
		view.loadUrl("http://www.cargobatam.com/index.php");
		view.setWebViewClient(new WebviewClients());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
