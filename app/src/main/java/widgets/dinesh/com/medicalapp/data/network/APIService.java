package widgets.dinesh.com.medicalapp.data.network;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import widgets.dinesh.com.medicalapp.login.models.LoginEntity;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordEntity;
import widgets.dinesh.com.medicalapp.requests.data.RequestEntity;
import widgets.dinesh.com.medicalapp.requests.data.RequestPatchDO;
import widgets.dinesh.com.medicalapp.shared.models.UserEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public interface APIService {
    @POST("login/")
    Flowable<UserEntity> login(@Body LoginEntity loginEntity);

    @GET("medical_record/")
    Flowable<List<MedicalRecordEntity>> getMedicalRecords(@Query("patient_id") int patientId);

    @GET("request/")
    Flowable<List<RequestEntity>> getRequestEntities(@Query("patient_id") int patientId);

    @PATCH("request/{id}/")
    Observable<RequestEntity> updateRequest(@Path("id") int id, @Body RequestPatchDO requestEntity);
}
