package org.novinger.jason.demoreader.datamodels;

/**
 * Created by jason on 4/27/16.
 */
public class ArticleFeed {
    private int count;
    private String next;
    private String previous;
    private Article[] results;

    public ArticleFeed() {}

    public ArticleFeed(int count, String next, String previous, Article[] results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Article[] getResults() {
        return results;
    }
}
