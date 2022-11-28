package edu.upi.cs.mobileapp.techi.pedulilansia;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class GeneralDBElder
{
    private static final String base = "http://techi.desainweb4c2.com/";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler handler)
    {
        client.get(getAbsoluteUrl(url), params, handler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler handler)
    {
        client.post(getAbsoluteUrl(url), params, handler);
    }

    private static String getAbsoluteUrl(String relative)
    {
        return base + relative;
    }
}