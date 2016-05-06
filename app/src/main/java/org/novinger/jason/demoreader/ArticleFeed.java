package org.novinger.jason.demoreader;

import android.util.Log;

import com.google.gson.Gson;

import org.novinger.jason.demoreader.datamodels.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Provides an interface to a Daily Dot API feed
 */
public class ArticleFeed {

    public static class ArticleArrayList extends ArrayList<Article> {}
    private String mFeedUrl;

    public ArticleFeed(String url) {
        mFeedUrl = url;
    }

    public ArrayList<Article> getArticles() {
        OkHttpClient client = new OkHttpClient();

        try {
            Request request = new Request.Builder().url(mFeedUrl).build();
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            Gson gson = new Gson();
            return gson.fromJson(json, ArticleArrayList.class);
        } catch (IOException ex) {
            return new ArrayList<Article>();
        }

    }
}
