package droidcrib.blogspot.com.codeexample.screen.list.mvp;

import android.util.Log;

import javax.inject.Inject;

import droidcrib.blogspot.com.codeexample.api.RestApi;
import droidcrib.blogspot.com.codeexample.dagger.DependencyInjector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsListActivityPresenter {

    @Inject
    RestApi restApi;

    private NewsListActivityView view;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public NewsListActivityPresenter(NewsListActivityView view) {
        DependencyInjector.getAppComponent().inject(this);
        this.view = view;
    }

    private void loadData() {

        view.showRefreshIndicator();
        Disposable disposableRestApi = restApi.getNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    Log.d("_restApi_", "loadData: " + result.articles);
                    view.updateAll(result.articles);
                });
        compositeDisposable.add(disposableRestApi);
    }

    public void onRefreshAction() {
        loadData();
    }

    public void onItemClick(int position) {
        view.showSnackbar(position);
    }

    public void onDestroy() {
        compositeDisposable.clear();
    }

}
