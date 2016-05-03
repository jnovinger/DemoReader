package org.novinger.jason.demoreader.datamodels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * POJO for deserializing articles from the Dailydot feed with gson.
 */
public class Article {

    @SerializedName("id")
    private String mId;

    @SerializedName("headline")
    private String mHeadline;

    @SerializedName("slug")
    private String mSlug;

    @SerializedName("authors")
    private ArrayList<Author> mAuthors;

    @SerializedName("summary")
    private String mSummary;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("lead_art")
    private LeadArt mLeadArt;

    public String getId() {
        return mId;
    }

    public String getHeadline() {
        return mHeadline;
    }

    public ArrayList<Author> getAuthors() {
        return mAuthors;
    }

    public Author getPrimaryAuthor() {
        if (null != mAuthors && mAuthors.size() > 0) {
            return mAuthors.get(0);
        }

        return new Author();
    }

    public String getLeadArtURL() {
        if (null == mLeadArt) {
            return "";
        }

        return mLeadArt.getExtraSmall();
    }

    public String toString() {
        return getHeadline() + " — " + getPrimaryAuthor().getName();
    }
}

