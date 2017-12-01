package widgets.dinesh.com.medicalapp.base.data;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class UIThread implements PostExecutionThread {
    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
