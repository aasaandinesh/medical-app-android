package widgets.dinesh.com.medicalapp.requests.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class RequestViewModel extends ViewModel {
    private final RequestDataSource requestDataSource;
    private LiveData<List<RequestEntity>> listLiveData;

    @Inject
    public RequestViewModel(RequestDataSource requestDataSource) {
        this.requestDataSource = requestDataSource;
    }

    public LiveData<List<RequestEntity>> getRequestLiveData() {
        if(listLiveData == null){
            listLiveData = LiveDataReactiveStreams.fromPublisher(requestDataSource.getData());
        }
        return listLiveData;
    }

    public void toggleAllowed(RequestEntity requestEntity){
        requestEntity.setAllowed(!requestEntity.isAllowed());
        requestDataSource.toggleAllowed(requestEntity);
    }
}
