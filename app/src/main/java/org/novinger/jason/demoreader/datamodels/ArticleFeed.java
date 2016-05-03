package org.novinger.jason.demoreader.datamodels;

/**
 * Provides a POJO for deserializing article feeds from the Dailydot with gson.
 */
public class ArticleFeed {
    private int mCount;
    private String mNext;
    private String mPrevious;
    private Article[] mResults;

    public ArticleFeed() {}

    public ArticleFeed(int count, String next, String previous, Article[] results) {
        mCount = count;
        mNext = next;
        mPrevious = previous;
        mResults = results;
    }

    public Article[] getResults() {
        return mResults;
    }
}
