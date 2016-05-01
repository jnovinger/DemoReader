package org.novinger.jason.demoreader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.novinger.jason.demoreader.datamodels.Article;

import java.util.ArrayList;

/**
 * Created by jason on 5/1/16.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private ArrayList<Article> mArticles;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mHeadline;
        public TextView mByline;
        public ImageView mLeadArt;
        public Context mContext;

        public ViewHolder(View articleView, Context context) {
            super(articleView);

            mHeadline = (TextView) articleView.findViewById(R.id.headline);
            mByline = (TextView) articleView.findViewById(R.id.byline);
            mLeadArt = (ImageView) articleView.findViewById(R.id.lead_art);
            mContext = context;
        }
    }

    public ArticleAdapter(ArrayList<Article> articles) {
        mArticles = articles;
    }

    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View articleView = inflater.inflate(R.layout.article_list_item_view, parent, false);
        return new ViewHolder(articleView, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = mArticles.get(position);
        holder.mHeadline.setText(article.getHeadline());
        holder.mByline.setText(article.getPrimaryAuthor().toString());
        Glide.with(holder.mContext).load(article.getLeadArtURL()).into(holder.mLeadArt);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}
