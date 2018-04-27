package com.cloneplanets.tickledmedia.Dagger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.cloneplanets.tickledmedia.Retrofit.TMServices;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by swapnilbhaisare on 27/04/18.
 */

@Module
public class AppModule {

    String BASE_URL="https://api.myjson.com/bins/";

    public Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {return  application;}

    @Provides @Singleton
    public SharedPreferences provideSharedPref(Context context){
        return context.getSharedPreferences("app",Context.MODE_PRIVATE);
    }

    @Provides @Singleton
    public TMServices getRetrofit()
    {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .baseUrl(BASE_URL)
                .build()
                .create(TMServices.class);
    }

}
