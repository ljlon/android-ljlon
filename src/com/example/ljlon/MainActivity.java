package com.example.ljlon;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	private WebView webview; 
	 
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		webview = (WebView) findViewById(R.id.webView1); 
        //����WebView���ԣ��ܹ�ִ��Javascript�ű� 
        webview.getSettings().setJavaScriptEnabled(true); 
        //������Ҫ��ʾ����ҳ 
        webview.loadUrl("http://www.ljlon.com/"); 
        //����Web��ͼ 
        webview.setWebViewClient(new HelloWebViewClient ()); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    //���û��� 
    //����Activity���onKeyDown(int keyCoder,KeyEvent event)���� 
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) { 
            webview.goBack(); //goBack()��ʾ����WebView����һҳ�� 
            return true; 
        } 
        return false; 
    } 
	
	 //Web��ͼ 
    private class HelloWebViewClient extends WebViewClient { 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    } 

}
