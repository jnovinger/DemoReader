package org.novinger.jason.demoreader.datamodels;

import com.google.gson.annotations.SerializedName;

/**
 * Provides a POJO for deserializing authors from the Dailydot feed with gson.
 */
public class Author {

    @SerializedName("name")
    private String mName;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("slug")
    private String mSlug;

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getSlug() {
        return mSlug;
    }
}
