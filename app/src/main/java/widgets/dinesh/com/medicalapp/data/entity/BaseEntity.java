package widgets.dinesh.com.medicalapp.data.entity;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class BaseEntity {

    @SerializedName("id")
    @Expose
    @PrimaryKey
    @NonNull
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
