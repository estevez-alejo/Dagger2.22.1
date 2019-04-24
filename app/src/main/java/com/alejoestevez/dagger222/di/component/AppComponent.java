package com.alejoestevez.dagger222.di.component;

import android.content.Context;

import com.alejoestevez.dagger222.App;
import com.alejoestevez.dagger222.di.builder.BuildersModule;
import com.alejoestevez.dagger222.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

//Instalamos AndroidSupportInjectionModule para asegurarnos de que lo enlazado este disponible.
//Además del módulo de la aplicación AppModule
// y el BuildersModule donde definimos la inyección de Activities y Fragments.
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
            AppModule.class,
            BuildersModule.class
                    })
public interface AppComponent {

    //Mediante la anotacion @Component.Builder, el cual permite definir un constructor para enlazar el componente
    //con la aplicación, en este caso el componente se construye inyectándole la aplicación.
    @Component.Builder
    interface Builder {

        //La anotación @BindsInstance
        //permite cargar la instancia de un tipo, del componente, en nuestro caso, la instancia de aplicación.
        @BindsInstance
        Builder application(App application);

        //build(), retorna el componente construido.
        AppComponent build();
    }

    void inject(App app);

    Context context();
}
