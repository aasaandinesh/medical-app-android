package widgets.dinesh.com.medicalapp.base.data;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class BackgroundThread implements ExecutionThread {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.newThread();
    }
}
