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

    @SerializedName("primary_section_title")
    private String mSection;

    @SerializedName("pub_date")
    private String mPubDate;

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

    public String getByline() {
        String byline = "";
        ArrayList<Author> authors = getAuthors();
        for (int i = 0; i < authors.size(); i++) {
            if (i > 0) {
                byline += ", ";
            }
            byline += authors.get(i).getName();
        }
        return byline;
    }

    public String getLeadArtURL() {
        if (null == mLeadArt) {
            return "";
        }

        return mLeadArt.getExtraSmall();
    }

    public LeadArt getLeadArt() {
        return mLeadArt;
    }

    public String getSection() {
        return mSection;
    }

    public String getPubDate() {
        return mPubDate;
    }

    public String toString() {
        return getHeadline() + " — " + getPrimaryAuthor().getName();
    }
}

