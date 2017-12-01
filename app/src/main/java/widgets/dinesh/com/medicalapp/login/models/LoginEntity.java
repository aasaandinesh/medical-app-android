package widgets.dinesh.com.medicalapp.login.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class LoginEntity {
    @SerializedName("username")
    @Expose
    @NonNull
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
