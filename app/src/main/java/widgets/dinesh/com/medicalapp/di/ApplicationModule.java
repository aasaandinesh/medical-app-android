package widgets.dinesh.com.medicalapp.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
@Singleton
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return this.application;
    }

    @Provides
    @Singleton
    @ApplicationComponent.ApplicationContext
    public Context provideApplicationContext() {
        return this.application;
    }

}
