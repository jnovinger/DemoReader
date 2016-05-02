package org.novinger.jason.demoreader;

import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;

import org.novinger.jason.demoreader.datamodels.Article;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ArticleListActivity extends AppCompatActivity {

    private final static int qty = 250;
    private final static String feedUrl = "http://www.dailydot.com/api/v1/content/article/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        enableNetworkingPolicy();

        final ArrayList<Article> list = getArticles();

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new ArticleAdapter(list);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void enableNetworkingPolicy() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @NonNull
    private ArrayList<Article> getArticles() {
        Article[] articles;
        try {
            articles = getFeedItems(getFeedUrl());
        } catch (IOException ex) {
            articles = new Article[0];
            Log.d("Exception", ex.toString());
        }

        final ArrayList<Article> list = new ArrayList<>();
        Collections.addAll(list, articles);
        return list;
    }

    private Article[] getFeedItems(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String json = response.body().string();
        Gson gson = new Gson();
        return gson.fromJson(json, Article[].class);
    }

    private String getFeedUrl() {
        if(qty > 0) {
           return feedUrl + "?quantity=" + Integer.toString(qty);
        }

        return feedUrl;
    }
}
