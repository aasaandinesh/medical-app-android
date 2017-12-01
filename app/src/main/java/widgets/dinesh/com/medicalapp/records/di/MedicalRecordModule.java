package widgets.dinesh.com.medicalapp.records.di;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import widgets.dinesh.com.medicalapp.base.data.ExecutionThread;
import widgets.dinesh.com.medicalapp.base.data.PostExecutionThread;
import widgets.dinesh.com.medicalapp.data.disc.MedicalDatabase;
import widgets.dinesh.com.medicalapp.data.disc.SharedPrefService;
import widgets.dinesh.com.medicalapp.data.network.APIService;
import widgets.dinesh.com.medicalapp.records.MedicalRecordsActivity;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordDAO;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordDataProvider;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordDataSource;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordViewModel;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Module
public class MedicalRecordModule {
    private final MedicalRecordsActivity activity;

    public MedicalRecordModule(MedicalRecordsActivity activity) {
        this.activity = activity;
    }

    @Provides
    public MedicalRecordDAO provideUserDao(MedicalDatabase database){
        return database.medicalRecordDAO();
    }

    @Provides
    public APIService getService(Retrofit retrofit){
        return retrofit.create(APIService.class);
    }

    @Provides
    public MedicalRecordDataSource getDataSource(MedicalRecordDAO userDAO, APIService apiService,
                                                 ExecutionThread executionThread,
                                                 PostExecutionThread postExecutionThread, SharedPrefService sharedPrefService){
        return new MedicalRecordDataProvider(executionThread, postExecutionThread,userDAO,
                apiService, sharedPrefService);
    }

    @Provides
    public MedicalRecordViewModel getLoginViewModel(MedicalRecordDataSource loginDataSource){
        return new MedicalRecordViewModel(loginDataSource);
    }
}
