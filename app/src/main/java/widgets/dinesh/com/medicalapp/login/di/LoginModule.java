package widgets.dinesh.com.medicalapp.login.di;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import widgets.dinesh.com.medicalapp.base.data.ExecutionThread;
import widgets.dinesh.com.medicalapp.base.data.PostExecutionThread;
import widgets.dinesh.com.medicalapp.data.disc.MedicalDatabase;
import widgets.dinesh.com.medicalapp.data.disc.SharedPrefService;
import widgets.dinesh.com.medicalapp.data.network.APIService;
import widgets.dinesh.com.medicalapp.login.data.LoginDataProvider;
import widgets.dinesh.com.medicalapp.login.data.LoginDataSource;
import widgets.dinesh.com.medicalapp.login.ui.LoginActivity;
import widgets.dinesh.com.medicalapp.login.viewmodel.LoginViewModel;
import widgets.dinesh.com.medicalapp.shared.data.UserDAO;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Module
public class LoginModule {
    private final LoginActivity activity;

    public LoginModule(LoginActivity activity) {
        this.activity = activity;
    }

    @Provides
    public UserDAO provideUserDao(MedicalDatabase database){
        return database.userDAO();
    }

    @Provides
    public APIService getService(Retrofit retrofit){
        return retrofit.create(APIService.class);
    }

    @Provides
    public LoginDataSource getDataSource(UserDAO userDAO, APIService apiService,
                                         ExecutionThread executionThread,
                                         PostExecutionThread postExecutionThread,
                                         SharedPrefService sharedPrefService){
        return new LoginDataProvider(userDAO, apiService, executionThread, postExecutionThread,
                sharedPrefService);
    }

    @Provides
    public LoginViewModel getLoginViewModel(LoginDataSource loginDataSource){
        return new LoginViewModel(loginDataSource);
    }
}
