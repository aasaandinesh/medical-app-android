package widgets.dinesh.com.medicalapp.data.disc;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import widgets.dinesh.com.medicalapp.di.ApplicationComponent;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Module
public class DiscDataModule {

    @Provides
    @Singleton
    public SharedPrefService provideSharedPrefService(@ApplicationComponent.ApplicationContext Context context) {
        return new SharedPrefManager(context);
    }

    @Provides
    @Singleton
    public MedicalDatabase provideDatabase(@ApplicationComponent.ApplicationContext Context context){
        return Room.databaseBuilder(context,
                MedicalDatabase.class, "medical").build();
    }
}
