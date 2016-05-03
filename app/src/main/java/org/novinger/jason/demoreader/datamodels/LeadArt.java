package org.novinger.jason.demoreader.datamodels;

import com.google.gson.annotations.SerializedName;

/**
 * Provides a POJO for deserializing lead art objects from the Dailydot feed with gson.
 */
public class LeadArt {

    @SerializedName("description")
    private String mDescription;

    @SerializedName("original")
    private String mOriginal;

    @SerializedName("extra_small")
    private String mExtraSmall;

    @SerializedName("small")
    private String mSmall;

    @SerializedName("medium")
    private String mMedium;

    @SerializedName("large")
    private String mLarge;

    public String getDescription() {
        return mDescription;
    }

    public String getOriginal() {
        return mOriginal;
    }

    public String getExtraSmall() {
        return mExtraSmall;
    }

    public String getSmall() {
        return mSmall;
    }

    public String getMedium() {
        return mMedium;
    }

    public String getLarge() {
        return mLarge;
    }
}
