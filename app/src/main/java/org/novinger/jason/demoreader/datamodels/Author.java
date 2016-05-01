package org.novinger.jason.demoreader.datamodels;

/**
 * Created by jason on 4/27/16.
 */
public class Author {
    private String name;
    private String url;
    private String slug;

    public Author() {}

    public Author(String name, String url, String slug) {
        this.name = name;
        this.url = url;
        this.slug = slug;
    }

    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getSlug() {
        return slug;
    }
}
