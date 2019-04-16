package droidcrib.blogspot.com.codeexample.api;

import droidcrib.blogspot.com.codeexample.model.NewsFeed;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface RestApi {

    @GET("news")
    Observable<NewsFeed> getNews();



}
