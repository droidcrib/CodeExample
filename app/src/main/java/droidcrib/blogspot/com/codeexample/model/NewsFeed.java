package droidcrib.blogspot.com.codeexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsFeed {

    @SerializedName("request_hash")
    public String requestHash;
    @SerializedName("request_cached")
    public Boolean requestCached;
    @SerializedName("request_cache_expiry")
    public Integer requestCacheExpiry;
    @SerializedName("articles")
    public List<Article> articles = null;

}
