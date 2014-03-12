package com.kodok.bangkong;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends Activity {

	WebView view;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ConnectivityManager cn = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cn.getActiveNetworkInfo();
		setTitle("Cipta Group");
		view =(WebView)findViewById(R.id.wview);
		WebSettings setting = view.getSettings();
		setting.setJavaScriptEnabled(true);
		if(ni != null && ni.isConnected()==true){
			view.loadUrl("http://www.cargobatam.com/index.php");
			view.setWebViewClient(new WebviewClients());
		}else{
			TextView txt = new TextView(this);
			txt.setText("Tidak ada koneksi internet");
			setContentView(txt);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId()==R.id.action_refresh){
			view.reload();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
