
package droidcrib.blogspot.com.codeexample.model;

import com.google.gson.annotations.SerializedName;

public class Article {

    @SerializedName("url")
    public String url;
    @SerializedName("title")
    public String title;
    @SerializedName("date")
    public String date;
    @SerializedName("author_name")
    public String authorName;
    @SerializedName("author_url")
    public String authorUrl;
    @SerializedName("forum_url")
    public String forumUrl;
    @SerializedName("image_url")
    public String imageUrl;
    @SerializedName("comments")
    public Integer comments;
    @SerializedName("intro")
    public String intro;

    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorUrl='" + authorUrl + '\'' +
                ", forumUrl='" + forumUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", comments=" + comments +
                ", intro='" + intro + '\'' +
                '}';
    }
}
