package droidcrib.blogspot.com.codeexample;

import android.app.Application;

import droidcrib.blogspot.com.codeexample.dagger.AppModule;
import droidcrib.blogspot.com.codeexample.dagger.DaggerAppComponent;
import droidcrib.blogspot.com.codeexample.dagger.DependencyInjector;
import droidcrib.blogspot.com.codeexample.dagger.NetworkModule;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        DependencyInjector.provideAppComponent(DaggerAppComponent.builder().appModule(new AppModule(this)).networkModule(new NetworkModule()).build());
        DependencyInjector.getAppComponent().inject(this);
    }

}
