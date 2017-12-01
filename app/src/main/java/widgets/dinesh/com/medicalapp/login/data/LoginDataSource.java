package widgets.dinesh.com.medicalapp.login.data;

import io.reactivex.Flowable;
import widgets.dinesh.com.medicalapp.login.models.LoginEntity;
import widgets.dinesh.com.medicalapp.shared.models.UserEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public interface LoginDataSource {
    void login(LoginEntity loginEntity);
    Flowable<UserEntity> getFirstUser();
}
