package widgets.dinesh.com.medicalapp.login.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import widgets.dinesh.com.medicalapp.login.data.LoginDataSource;
import widgets.dinesh.com.medicalapp.login.models.LoginEntity;
import widgets.dinesh.com.medicalapp.shared.models.UserEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class LoginViewModel extends ViewModel {
    private final LoginDataSource loginDataSource;
    private LiveData<UserEntity> userEntityLiveData;

    @Inject
    public LoginViewModel(LoginDataSource loginDataSource) {
        this.loginDataSource = loginDataSource;
    }

    public LiveData<UserEntity> getUserEntityLiveData() {
        if(userEntityLiveData == null){
            userEntityLiveData = LiveDataReactiveStreams.fromPublisher(loginDataSource.getFirstUser());
        }
        return userEntityLiveData;
    }

    public void login(String username) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUsername(username);
        loginDataSource.login(loginEntity);
    }
}
