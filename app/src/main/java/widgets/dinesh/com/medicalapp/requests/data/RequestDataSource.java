package widgets.dinesh.com.medicalapp.requests.data;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public interface RequestDataSource {
    Flowable<List<RequestEntity>> getData();

    void toggleAllowed(RequestEntity requestEntity);
}
