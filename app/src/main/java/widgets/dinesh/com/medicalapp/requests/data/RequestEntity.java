package widgets.dinesh.com.medicalapp.requests.data;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import widgets.dinesh.com.medicalapp.data.entity.BaseEntity;
import widgets.dinesh.com.medicalapp.shared.models.UserEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Entity
public class RequestEntity extends BaseEntity{

    @SerializedName("business_user")
    @Expose
    @NonNull
    @Embedded(prefix = "business_user")
    private UserEntity businessUser;

    @SerializedName("patient")
    @Expose
    @NonNull
    @Embedded(prefix = "patient")
    private UserEntity patient;

    @SerializedName("allowed")
    @Expose
    @NonNull
    private boolean allowed;

    @NonNull
    public UserEntity getBusinessUser() {
        return businessUser;
    }

    public void setBusinessUser(@NonNull UserEntity businessUser) {
        this.businessUser = businessUser;
    }

    @NonNull
    public UserEntity getPatient() {
        return patient;
    }

    public void setPatient(@NonNull UserEntity patient) {
        this.patient = patient;
    }

    @NonNull
    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(@NonNull boolean allowed) {
        this.allowed = allowed;
    }
}
