package com.cloneplanets.tickledmedia.Dagger;

import com.cloneplanets.tickledmedia.Fragment.AnswerFragment;
import com.cloneplanets.tickledmedia.Fragment.QuestionFragment;
import com.cloneplanets.tickledmedia.Activity.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by swapnilbhaisare on 27/04/18.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

  void inject(MainActivity activity);
  void inject(AnswerFragment activity);
  void inject(QuestionFragment activity);


}


