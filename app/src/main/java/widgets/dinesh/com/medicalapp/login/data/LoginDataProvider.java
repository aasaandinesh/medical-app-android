package widgets.dinesh.com.medicalapp.login.data;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import widgets.dinesh.com.medicalapp.base.data.BaseDataProvider;
import widgets.dinesh.com.medicalapp.base.data.ExecutionThread;
import widgets.dinesh.com.medicalapp.base.data.PostExecutionThread;
import widgets.dinesh.com.medicalapp.data.disc.SharedPrefConstants;
import widgets.dinesh.com.medicalapp.data.disc.SharedPrefService;
import widgets.dinesh.com.medicalapp.data.network.APIService;
import widgets.dinesh.com.medicalapp.login.models.LoginEntity;
import widgets.dinesh.com.medicalapp.shared.data.UserDAO;
import widgets.dinesh.com.medicalapp.shared.models.UserEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class LoginDataProvider extends BaseDataProvider implements LoginDataSource {

    private final UserDAO userDAO;
    private final APIService apiService;
    private final SharedPrefService sharedPrefService;

    @Inject
    public LoginDataProvider(UserDAO userDAO, APIService apiService, ExecutionThread executionThread,
                             PostExecutionThread postExecutionThread, SharedPrefService sharedPrefService) {
        super(executionThread, postExecutionThread);
        this.userDAO = userDAO;
        this.apiService = apiService;
        this.sharedPrefService = sharedPrefService;
    }

    @Override
    public void login(LoginEntity loginEntity) {
        apiService.login(loginEntity)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(userEntity -> {
                    sharedPrefService.storeValue(SharedPrefConstants.USER_ID, userEntity.getId());
                    sharedPrefService.storeValue(SharedPrefConstants.USER_TYPE, userEntity.getUserType());
                    Observable.fromCallable(()->{
                        userDAO.insert(userEntity);
                        return userEntity;
                    }).subscribeOn(executionThread.getScheduler())
                            .observeOn(postExecutionThread.getScheduler())
                    .subscribe();
                }, error -> Log.e("API Error", "Something went wrong"));

    }

    @Override
    public Flowable<UserEntity> getFirstUser() {
        return userDAO.getAll()
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .map(userEntities -> {
                    if(userEntities==null){
                        return new UserEntity();
                    }
                    else {
                        if(userEntities.size()==0){
                            return new UserEntity();
                        }
                        else {
                            return userEntities.get(0);
                        }
                    }
                });

    }
}
