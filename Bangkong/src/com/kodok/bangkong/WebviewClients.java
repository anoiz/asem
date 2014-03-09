package com.kodok.bangkong;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebviewClients extends WebViewClient {

	/* (non-Javadoc)
	 * @see android.webkit.WebViewClient#shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String)
	 */
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// Auto-generated method stub
		//return super.shouldOverrideUrlLoading(view, url);
		if(Uri.parse(url).getHost().endsWith("http://www.cargobatam.com/index.php"))
			return false;
		Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse(url));
		view.getContext().startActivity(i);
		return true;
	}
	
	

}
