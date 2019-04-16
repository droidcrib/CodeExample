package droidcrib.blogspot.com.codeexample.api;

import android.util.Log;

import droidcrib.blogspot.com.codeexample.model.NewsFeed;
import io.reactivex.Observable;

public class NetworkApi implements RestApi{

    RestApi restApi;
    public NetworkApi(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<NewsFeed> getNews() {
        return restApi.getNews().doOnError(throwable -> {
            Log.e("_api_error_", "getNews: ", throwable);
        });
    }
}
