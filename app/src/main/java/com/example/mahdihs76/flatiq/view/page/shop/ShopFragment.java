package com.example.mahdihs76.flatiq.view.page.shop;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.mahdihs76.flatiq.R;
import com.example.mahdihs76.flatiq.constant.Constant;

public class ShopFragment extends Fragment {

    private WebView webView;
    public ShopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);
        WebView myWebView = (WebView) view.findViewById(R.id.webview);
        myWebView.loadUrl(Constant.SHOP_URL);
        return view;
    }

}
