package widgets.dinesh.com.medicalapp.requests.di;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import widgets.dinesh.com.medicalapp.base.data.ExecutionThread;
import widgets.dinesh.com.medicalapp.base.data.PostExecutionThread;
import widgets.dinesh.com.medicalapp.data.disc.MedicalDatabase;
import widgets.dinesh.com.medicalapp.data.disc.SharedPrefService;
import widgets.dinesh.com.medicalapp.data.network.APIService;
import widgets.dinesh.com.medicalapp.requests.data.RequestDAO;
import widgets.dinesh.com.medicalapp.requests.data.RequestDataProvider;
import widgets.dinesh.com.medicalapp.requests.data.RequestDataSource;
import widgets.dinesh.com.medicalapp.requests.data.RequestViewModel;
import widgets.dinesh.com.medicalapp.requests.ui.RequestsActivity;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Module
public class RequestModule {
    private final RequestsActivity requestsActivity;


    public RequestModule(RequestsActivity requestsActivity) {
        this.requestsActivity = requestsActivity;
    }

    @Provides
    public RequestDAO provideUserDao(MedicalDatabase database){
        return database.requestDAO();
    }

    @Provides
    public APIService getService(Retrofit retrofit){
        return retrofit.create(APIService.class);
    }

    @Provides
    public RequestDataSource getDataSource(RequestDAO userDAO, APIService apiService,
                                           ExecutionThread executionThread,
                                           PostExecutionThread postExecutionThread,
                                           SharedPrefService sharedPrefService){
        return new RequestDataProvider( executionThread, postExecutionThread,
                 userDAO, apiService, sharedPrefService);
    }

    @Provides
    public RequestViewModel getLoginViewModel(RequestDataSource loginDataSource){
        return new RequestViewModel(loginDataSource);
    }
}
