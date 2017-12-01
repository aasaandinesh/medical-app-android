package widgets.dinesh.com.medicalapp.requests.data;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ajmac1005 on 01/12/17.
 */

public class RequestPatchDO {
    @SerializedName("allowed")
    @Expose
    @NonNull
    private boolean allowed;

    @NonNull
    public boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(@NonNull boolean allowed) {
        this.allowed = allowed;
    }
}
