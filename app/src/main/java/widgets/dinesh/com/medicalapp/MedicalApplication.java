package widgets.dinesh.com.medicalapp;

import android.support.multidex.MultiDexApplication;

import com.twitter.sdk.android.core.Twitter;

import widgets.dinesh.com.medicalapp.data.disc.DiscDataModule;
import widgets.dinesh.com.medicalapp.data.network.NetworkModule;
import widgets.dinesh.com.medicalapp.di.ApplicationComponent;
import widgets.dinesh.com.medicalapp.di.ApplicationModule;
import widgets.dinesh.com.medicalapp.di.DaggerApplicationComponent;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class MedicalApplication extends MultiDexApplication {
    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Twitter.initialize(this);

        component =  DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .discDataModule(new DiscDataModule())
                .networkModule(new NetworkModule())
                .build();


    }

    public static ApplicationComponent getComponent() {
        return component;
    }
}
