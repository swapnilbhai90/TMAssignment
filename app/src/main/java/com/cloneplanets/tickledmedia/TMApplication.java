package com.cloneplanets.tickledmedia;

import android.app.Application;

import com.cloneplanets.tickledmedia.Dagger.AppComponent;
import com.cloneplanets.tickledmedia.Dagger.AppModule;
import com.cloneplanets.tickledmedia.Dagger.DaggerAppComponent;

/**
 * Created by swapnilbhaisare on 27/04/18.
 */

public class TMApplication extends Application {

 AppComponent components;

    @Override
    public void onCreate() {
        super.onCreate();

        components= DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }


    public AppComponent getComponents() {
        return components;
    }
}
