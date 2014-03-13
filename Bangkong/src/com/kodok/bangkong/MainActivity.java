package com.kodok.bangkong;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {

	WebView view;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Activity context;
		context = this;
		ConnectivityManager cn = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo ni = cn.getActiveNetworkInfo();
		setTitle("Cipta Group");
		view =(WebView)findViewById(R.id.wview);
		WebSettings setting = view.getSettings();
		setting.setJavaScriptEnabled(true);
		if(ni != null && ni.isConnected()==true){
			view.loadUrl("http://www.cargobatam.com/index.php");
			view.setWebViewClient(new WebViewClient(){
				ProgressDialog pd = new ProgressDialog(context);

				/* (non-Javadoc)
				 * @see android.webkit.WebViewClient#onPageStarted(android.webkit.WebView, java.lang.String, android.graphics.Bitmap)
				 */
				@Override
				public void onPageStarted(WebView view, String url,
						Bitmap favicon) {
					// TODO Auto-generated method stub
					super.onPageStarted(view, url, favicon);
					pd.setMessage("lading the file... be patient");
					pd.setCancelable(false);
					pd.show();
					
				}

				/* (non-Javadoc)
				 * @see android.webkit.WebViewClient#onPageFinished(android.webkit.WebView, java.lang.String)
				 */
				@Override
				public void onPageFinished(WebView view, String url) {
					// TODO Auto-generated method stub
					super.onPageFinished(view, url);
					if(pd.isShowing())
					     pd.dismiss();
				}

				/* (non-Javadoc)
				 * @see android.webkit.WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String)
				 */
				@Override
				public boolean shouldOverrideUrlLoading(WebView view, String url) {
					// TODO Auto-generated method stub
					pd.setMessage("lading the file... be patient");
					pd.setCancelable(false);
					pd.show();
					view.loadUrl("http://www.cargobatam.com/index.php");
					return true;
				}
				
				
			});
			view.setWebChromeClient(new WebChromeClient(){

				/* (non-Javadoc)
				 * @see android.webkit.WebChromeClient#onProgressChanged(android.webkit.WebView, int)
				 */
				@Override
				public void onProgressChanged(WebView view, int newProgress) {
					//  Auto-generated method stub
					super.onProgressChanged(view, newProgress);
					context.setProgress(newProgress*1000);
					 
					 
				}
				
			});
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
