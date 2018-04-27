package com.cloneplanets.tickledmedia.Retrofit;

import com.cloneplanets.tickledmedia.Retrofit.AnswerContributor.AnswerContributor;
import com.cloneplanets.tickledmedia.Retrofit.QuestonContributor.QuestonContributor;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by swapnilbhaisare on 27/04/18.
 */

public interface TMServices {

    @GET("19i7wt")
    Call<QuestonContributor> getQuestion();


    @GET("vt8zx")
    Call<AnswerContributor> getAnswers();
}
