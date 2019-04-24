package com.alejoestevez.dagger222;

import android.app.Activity;
import android.app.Application;

import com.alejoestevez.dagger222.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

//HasActivityInyector, provee de un DispatchingAndroidInjector<Activity>,
// que indica que las Activity participan en la inyección de dependencias de dagger.
public class App extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate()
    {
        super.onCreate();
        //DaggerAppComponent es una clase generada por Dagger en tiempo de compilación
        //Le inyectamos su aplicación  y construimos el componente mediante build().
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    //Este es el método por donde se inyecta la activity.Invocado por la Activity en el onCreate()
    // AndroidInjection.inject(this);
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
