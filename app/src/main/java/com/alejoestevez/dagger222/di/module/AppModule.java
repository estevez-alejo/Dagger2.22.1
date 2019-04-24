package com.alejoestevez.dagger222.di.module;

import android.content.Context;

import com.alejoestevez.dagger222.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public abstract class AppModule {

    //En el modulo de la aplicación, proveemos de aquellas dependencias que sean necesarias,
    // en nuestro caso el contexto de la aplicación.
    @Provides
    @Singleton
    static Context provideContext(App application){
        return application.getApplicationContext();
    }

}
