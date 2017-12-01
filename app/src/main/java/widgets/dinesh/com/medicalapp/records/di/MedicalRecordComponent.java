package widgets.dinesh.com.medicalapp.records.di;

import dagger.Component;
import widgets.dinesh.com.medicalapp.base.di.RxModule;
import widgets.dinesh.com.medicalapp.base.di.ScopedActivity;
import widgets.dinesh.com.medicalapp.di.ApplicationComponent;
import widgets.dinesh.com.medicalapp.records.MedicalRecordsActivity;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@ScopedActivity
@Component(
        modules = {
                MedicalRecordModule.class,
                RxModule.class
        },
        dependencies = ApplicationComponent.class
)
public interface MedicalRecordComponent {
    void inject(MedicalRecordsActivity medicalRecordsActivity);
}
