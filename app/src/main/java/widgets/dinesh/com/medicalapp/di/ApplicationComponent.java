package widgets.dinesh.com.medicalapp.di;

import android.app.Application;
import android.content.Context;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import widgets.dinesh.com.medicalapp.data.disc.DiscDataModule;
import widgets.dinesh.com.medicalapp.data.disc.MedicalDatabase;
import widgets.dinesh.com.medicalapp.data.disc.SharedPrefService;
import widgets.dinesh.com.medicalapp.data.network.NetworkModule;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                NetworkModule.class,
                DiscDataModule.class
        }
)
public interface ApplicationComponent {

    @ApplicationContext
    Context getApplicationContext();

    Application getApplication();
   Retrofit getRetrofit();

    SharedPrefService getSharedPrefService();

    MedicalDatabase provideDatabase();

    @Qualifier
    @Documented
    @Retention(RUNTIME)
    @interface ApplicationContext {
    }
}
