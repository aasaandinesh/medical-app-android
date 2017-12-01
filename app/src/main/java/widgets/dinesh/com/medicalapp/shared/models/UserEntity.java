package widgets.dinesh.com.medicalapp.shared.models;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import widgets.dinesh.com.medicalapp.data.entity.BaseEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */
@Entity
@Parcel
public class UserEntity extends BaseEntity{




    @SerializedName("name")
    @Expose
    @NonNull
    private String name;

    @SerializedName("username")
    @Expose
    @NonNull
    private String username;

    @SerializedName("user_type")
    @Expose
    @NonNull
    private String userType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


}
