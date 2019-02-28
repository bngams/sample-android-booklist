package fr.istef.cw1719.android.booklist.netowrk;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import cz.msebera.android.httpclient.Header;

public class BookAPIClient {
    private static final String API_BASE_URL = "https://www.googleapis.com/books/v1/";
    private AsyncHttpClient httpClient;


    public BookAPIClient() {
        this.httpClient = new AsyncHttpClient();
    }

    private String buildApiUrl(String requestUrl) {
        return this.API_BASE_URL + requestUrl;
    }

    private void getBooks(String query) {
        try {
            query = URLEncoder.encode(query, "utf-8");
            RequestParams params = new RequestParams();
            params.put("q", query);
            params.put("maxResults", "5");
            this.httpClient.get(this.buildApiUrl("volumes"), params, new TextHttpResponseHandler() {
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {

                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, String responseString) {

                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
