package widgets.dinesh.com.medicalapp.requests.data;

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

public class RequestDataProvider extends BaseDataProvider implements RequestDataSource {
    private final RequestDAO dao;
    private final APIService apiService;
    private final SharedPrefService sharedPrefService;

    @Inject
    public RequestDataProvider(ExecutionThread executionThread, PostExecutionThread postExecutionThread, RequestDAO dao, APIService apiService, SharedPrefService sharedPrefService) {
        super(executionThread, postExecutionThread);
        this.dao = dao;
        this.apiService = apiService;
        this.sharedPrefService = sharedPrefService;
    }

    @Override
    public Flowable<List<RequestEntity>> getData() {
        apiService.getRequestEntities(sharedPrefService.retrieveValue(SharedPrefConstants.USER_ID,1))
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(medicalRecordEntitys -> {
                    Observable.fromCallable(() -> {
                        dao.insert(medicalRecordEntitys);
                        return medicalRecordEntitys;
                    })
                            .subscribeOn(executionThread.getScheduler())
                            .observeOn(postExecutionThread.getScheduler())
                            .subscribe();
                }, error -> Log.e("API Error", "Something went wrong"));

        return dao.getAll();
    }

    @Override
    public void toggleAllowed(RequestEntity requestEntity) {
        RequestPatchDO requestPatchDO = new RequestPatchDO();
        requestPatchDO.setAllowed(requestEntity.isAllowed());
        apiService.updateRequest(requestEntity.getId(), requestPatchDO)
                .subscribeOn(executionThread.getScheduler())
                .observeOn(postExecutionThread.getScheduler())
                .subscribe(requestEntity1 -> {
                    Observable.fromCallable(() -> {
                        dao.insertOne(requestEntity1);
                        return requestEntity1;
                    })
                    .subscribeOn(executionThread.getScheduler())
                    .observeOn(postExecutionThread.getScheduler())
                    .subscribe();

                }

                );

    }
}
