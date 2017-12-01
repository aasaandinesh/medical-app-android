package widgets.dinesh.com.medicalapp.records.data;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public interface MedicalRecordDataSource {
    Flowable<List<MedicalRecordEntity>> getData();
}
