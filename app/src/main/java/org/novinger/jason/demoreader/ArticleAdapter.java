package org.novinger.jason.demoreader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

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
        public TextView mSection;
        public ImageView mLeadArt;

        public ViewHolder(View articleView) {
            super(articleView);

            mHeadline = (TextView) articleView.findViewById(R.id.headline);
            mByline = (TextView) articleView.findViewById(R.id.byline);
            mSection = (TextView) articleView.findViewById(R.id.section);
            mLeadArt = (ImageView) articleView.findViewById(R.id.lead_art);
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
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Article article = mArticles.get(position);

        RequestListener listener = new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                holder.mHeadline.setText(article.getHeadline());
                String byline = article.getByline();
                if ("".equals(byline)) {
                    holder.mByline.setVisibility(View.GONE);
                } else {
                    holder.mByline.setText("By " + article.getByline());
                }

                String section = article.getSection();
                if (section == null) {
                    holder.mSection.setVisibility(View.GONE);
                } else {
                    holder.mSection.setText(section);
                }

                return false;
            }
        };
        Context context = holder.mHeadline.getContext().getApplicationContext();
        Glide.with(context).load(article.getLeadArt().getSmall()).listener(listener).into(holder.mLeadArt);
    }

    @Override
    public int getItemCount() {
        return mArticles.size();
    }
}
