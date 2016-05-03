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
 * Provides a POJO for deserializing article feeds from the Dailydot with gson.
 */
public class ArticleFeed {

    private String mFeedUrl;

    public ArticleFeed(String url) {
        mFeedUrl = url;
    }

    public ArrayList<Article> getArticles() {
        OkHttpClient client = new OkHttpClient();
        ArrayList<Article> articles = new ArrayList<>();

        try {
            Request request = new Request.Builder().url(mFeedUrl).build();
            Response response = client.newCall(request).execute();
            String json = response.body().string();
            Gson gson = new Gson();
            Article[] articles_array = gson.fromJson(json, Article[].class);
            Collections.addAll(articles, articles_array);
        } catch (IOException ex) {
            // nothing to see here
        }
        Log.d("getArticles()", Integer.toString(articles.size()));

        return articles;
    }
}
