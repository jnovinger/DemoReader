package org.novinger.jason.demoreader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        public ViewHolder(View articleView) {
            super(articleView);

            mHeadline = (TextView) articleView.findViewById(R.id.headline);
            mByline = (TextView) articleView.findViewById(R.id.byline);
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
        return new ViewHolder(articleView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Article article = mArticles.get(position);
        holder.mHeadline.setText(article.getHeadline());
        holder.mByline.setText(article.getPrimaryAuthor().toString());
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}
