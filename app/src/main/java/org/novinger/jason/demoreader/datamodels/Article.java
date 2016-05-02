package org.novinger.jason.demoreader.datamodels;

import java.util.ArrayList;

/**
 * Created by jason on 4/27/16.
 */
public class Article {
    private String id;
    private int realId;
    private String headline;
    private String slug;
    private ArrayList<Author> authors;
    private String summary;
    private String url;
    private LeadArt lead_art;

    public Article() {}

    public Article(String id, String headline, String slug, ArrayList<Author> authors, String url, String summary, LeadArt lead_art) {
        this.id = id;
        this.realId = mungeId(id);
        this.headline = headline;
        this.slug = slug;
        this.authors = authors;
        this.url = url;
        this.summary = summary;
        this.lead_art = lead_art;
    }

    private int mungeId(String id) {
        String[] parts = id.split(".");
        return Integer.parseInt(parts[2]);
    }

    public String toString() {
        return getHeadline() + " — " + getPrimaryAuthor().getName();
    }

    public int getId() {
        return realId;
    }

    public String getHeadline() {
        return headline;
    }

    public String getSlug() {
        return slug;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public Author getPrimaryAuthor() {
        if (authors.size() > 0) {
            return authors.get(0);
        }

        return new Author();
    }

    public String getSummary() {
        return summary;
    }

    public String getUrl() {
        return url;
    }

    public String getLeadArtURL() {
        if (null == lead_art) {
            return "";
        }

        return lead_art.getExtraSmall();
    }
}
