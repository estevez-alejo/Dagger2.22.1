package com.alejoestevez.dagger222.di.builder;

import com.alejoestevez.dagger222.di.module.MainActivityModule;
import com.alejoestevez.dagger222.di.scope.PerActivity;
import com.alejoestevez.dagger222.ui.MainActivity;

import dagger.Module;

import dagger.android.ContributesAndroidInjector;


@Module
public abstract class BuildersModule {
    //En esta clase, definiriamos cada una de las inyecciones de nuestras activity.

    //Mediante la anotacion @ContributesAndroidInjector, en lugar de crear un SubComponente para la activity
    //con los modulos que utiliza, así como inyectarlo al componente que inyecta nuestra aplicación,
    //podemos utilizar dicha anotación para que sean generados automáticamente por nosotros,
    // en lugar de tener clases de tipo @SubComponent.
    //Para ello bastará con indicarle a la anotación, los módulos que queremos instalar en el subcomponente.
    //en nuestro caso, será el modulo de nuestra activity.

    //El alcance o scope será a nivel de Activity @PerActivity

    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivity();

}
