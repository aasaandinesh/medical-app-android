package widgets.dinesh.com.medicalapp.login.di;

import dagger.Component;
import widgets.dinesh.com.medicalapp.base.di.RxModule;
import widgets.dinesh.com.medicalapp.base.di.ScopedActivity;
import widgets.dinesh.com.medicalapp.di.ApplicationComponent;
import widgets.dinesh.com.medicalapp.login.ui.LoginActivity;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@ScopedActivity
@Component(
        modules = {
                LoginModule.class,
                RxModule.class
        },
        dependencies = ApplicationComponent.class
)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
