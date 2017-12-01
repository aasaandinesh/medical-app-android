package widgets.dinesh.com.medicalapp.records.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class MedicalRecordViewModel extends ViewModel {

    private final MedicalRecordDataSource medicalRecordDataSource;
    private LiveData<List<MedicalRecordEntity>> medicalRecordEntityLiveData;

    @Inject
    public MedicalRecordViewModel(MedicalRecordDataSource medicalRecordDataSource) {
        this.medicalRecordDataSource = medicalRecordDataSource;
    }

    public LiveData<List<MedicalRecordEntity>> getMedicalRecordEntityLiveData() {
        if(medicalRecordEntityLiveData == null){
            medicalRecordEntityLiveData = LiveDataReactiveStreams.fromPublisher(medicalRecordDataSource.getData());
        }
        return medicalRecordEntityLiveData;
    }
}
