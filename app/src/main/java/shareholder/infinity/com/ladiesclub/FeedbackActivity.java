package shareholder.infinity.com.ladiesclub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FeedbackActivity extends AppCompatActivity {

    WebView wv;
    String myPage ="https://docs.google.com/forms/d/e/1FAIpQLSd3kSklSZrhzPQcSxQsnDD14OQXZDMMo83j2amvJ7w2KzK5-Q/viewform";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        wv =(WebView)findViewById(R.id.feedbackid);
        wv.getSettings().getJavaScriptEnabled();
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setFocusable(true);
        wv.setFocusableInTouchMode(true);
        wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv.getSettings().setDomStorageEnabled(true);
        wv.getSettings().setDatabaseEnabled(true);
        wv.getSettings().setAppCacheEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv.setWebViewClient(new WebViewClient());//this line opens the link in the same browser
        wv.loadUrl(myPage);
    }
}
