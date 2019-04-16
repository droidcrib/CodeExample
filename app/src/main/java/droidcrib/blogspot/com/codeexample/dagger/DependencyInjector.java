package droidcrib.blogspot.com.codeexample.dagger;

import android.support.annotation.NonNull;

public class DependencyInjector {
    private static AppComponent gApplicationComponent;

    private DependencyInjector() {
    }

    /**
     * Return the instance of application component.
     *
     * @return The instance of application component
     */
    @NonNull
    public static AppComponent getAppComponent() {
        return gApplicationComponent;
    }

    /**
     * Set the instance of {@code ApplicationComponent}
     *
     * @param appComponent A {@code ApplicationComponent} instance.
     */
    public static void provideAppComponent(@NonNull final AppComponent appComponent) {
        gApplicationComponent = appComponent;
    }
}
