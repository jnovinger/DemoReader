package org.novinger.jason.demoreader.datamodels;

/**
 * Created by jason on 5/1/16.
 */
public class LeadArt {
    private String description;
    private String original;
    private String extra_small;
    private String small;
    private String medium;
    private String large;

    public LeadArt() {}

    public LeadArt(String description, String original, String extra_small, String small, String medium, String large) {
        this.description = description;
        this.original = original;
        this.extra_small = extra_small;
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public String getExtraSmall() {
        return extra_small;
    }
}
