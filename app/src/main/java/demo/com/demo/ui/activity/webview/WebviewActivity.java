package demo.com.demo.ui.activity.webview;

import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import demo.com.demo.R;
import demo.com.demo.ui.base.BaseActivity;

/**
 * 类或接口的描述信息
 *
 * @Author:qubin
 * @Theme:
 * @Data:2019-10-24
 * @Describe:Fdd123456 QBin@19921112
 */
public class WebviewActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView webView;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.img_back)
    ImageView imgBack;

    private final String URL = "LOAD_URL";

    @Override
    public int initLayout() {
        return R.layout.activity_webview;
    }

    @Override
    public void initData() {
        String url = getIntent().getStringExtra(URL);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webView.canGoBack()){
                    webView.goBack();
                }else{
                    finish();
                }

            }
        });
        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(url);
                return true;
            }


        });

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                txtTitle.setText(title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100){
                    progressBar.setVisibility(View.GONE);
                }else {
                    progressBar.setVisibility(View.VISIBLE);
                    progressBar.setProgress(newProgress);
                }


                super.onProgressChanged(view, newProgress);
            }
        });

    }

    @Override
    protected void onDestroy() {

        if (webView != null){
            webView.clearHistory();
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}
