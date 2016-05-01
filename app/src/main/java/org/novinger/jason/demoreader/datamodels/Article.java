package org.novinger.jason.demoreader.datamodels;

/**
 * Created by jason on 4/27/16.
 */
public class Article {
    private String id;
    private int realId;
    private String headline;
    private String slug;
    private Author[] authors;
    private String summary;
    private String url;

    public Article() {}

    public Article(String id, String headline, String slug, Author[] authors, String url, String summary) {
        this.id = id;
        this.realId = mungeId(id);
        this.headline = headline;
        this.slug = slug;
        this.authors = authors;
        this.url = url;
        this.summary = summary;
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

    public Author[] getAuthors() {
        return authors;
    }

    public Author getPrimaryAuthor() {
        if (authors.length > 0) {
            return authors[0];
        }

        return new Author();
    }

    public String getSummary() {
        return summary;
    }

    public String getUrl() {
        return url;
    }
}
