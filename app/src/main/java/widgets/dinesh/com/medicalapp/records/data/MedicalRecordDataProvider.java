package widgets.dinesh.com.medicalapp.records.data;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import widgets.dinesh.com.medicalapp.base.data.BaseDataProvider;
import widgets.dinesh.com.medicalapp.base.data.ExecutionThread;
import widgets.dinesh.com.medicalapp.base.data.PostExecutionThread;
import widgets.dinesh.com.medicalapp.data.disc.SharedPrefConstants;
import widgets.dinesh.com.medicalapp.data.disc.SharedPrefService;
import widgets.dinesh.com.medicalapp.data.network.APIService;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class MedicalRecordDataProvider extends BaseDataProvider implements MedicalRecordDataSource {
    private final MedicalRecordDAO medicalRecordDAO;
    private final APIService apiService;
    private final SharedPrefService sharedPrefService;

    @Inject
    public MedicalRecordDataProvider(ExecutionThread executionThread,
                                     PostExecutionThread postExecutionThread, MedicalRecordDAO medicalRecordDAO, APIService apiService, SharedPrefService sharedPrefService) {
        super(executionThread, postExecutionThread);
        this.medicalRecordDAO = medicalRecordDAO;
        this.apiService = apiService;
        this.sharedPrefService = sharedPrefService;
    }

    @Override
    public Flowable<List<MedicalRecordEntity>> getData() {
        apiService.getMedicalRecords(sharedPrefService.retrieveValue(SharedPrefConstants.USER_ID,1))
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(medicalRecordEntitys -> {
                    Observable.fromCallable(() -> {
                        medicalRecordDAO.insert(medicalRecordEntitys);
                        return medicalRecordEntitys;
                    })
                            .subscribeOn(executionThread.getScheduler())
                            .observeOn(postExecutionThread.getScheduler())
                            .subscribe();
                }, error -> Log.e("API Error", "Something went wrong"));

        return medicalRecordDAO.getAll();

    }
}
