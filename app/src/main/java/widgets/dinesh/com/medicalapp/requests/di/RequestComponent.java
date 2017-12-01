package widgets.dinesh.com.medicalapp.requests.di;

import dagger.Component;
import widgets.dinesh.com.medicalapp.base.di.RxModule;
import widgets.dinesh.com.medicalapp.base.di.ScopedActivity;
import widgets.dinesh.com.medicalapp.di.ApplicationComponent;
import widgets.dinesh.com.medicalapp.requests.ui.RequestsActivity;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@ScopedActivity
@Component(
        modules = {
                RequestModule.class,
                RxModule.class
        },
        dependencies = ApplicationComponent.class
)
public interface RequestComponent {
    void inject(RequestsActivity requestsActivity);
}
