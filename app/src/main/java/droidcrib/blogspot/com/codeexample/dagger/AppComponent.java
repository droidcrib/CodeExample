package droidcrib.blogspot.com.codeexample.dagger;


import javax.inject.Singleton;

import dagger.Component;
import droidcrib.blogspot.com.codeexample.App;
import droidcrib.blogspot.com.codeexample.screen.list.NewsListActivity;
import droidcrib.blogspot.com.codeexample.screen.list.mvp.NewsListActivityPresenter;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {

    void inject(App app);

    void inject(NewsListActivity newsListActivity);

    void inject(NewsListActivityPresenter newsListActivityPresenter);
}
