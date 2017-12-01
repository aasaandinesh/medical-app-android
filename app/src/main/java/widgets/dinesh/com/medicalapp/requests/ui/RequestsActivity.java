package widgets.dinesh.com.medicalapp.requests.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import widgets.dinesh.com.medicalapp.MedicalApplication;
import widgets.dinesh.com.medicalapp.R;
import widgets.dinesh.com.medicalapp.base.BaseActivity;
import widgets.dinesh.com.medicalapp.base.di.RxModule;
import widgets.dinesh.com.medicalapp.base.widgets.ReactiveRecyclerAdapter;
import widgets.dinesh.com.medicalapp.requests.data.RequestEntity;
import widgets.dinesh.com.medicalapp.requests.data.RequestViewModel;
import widgets.dinesh.com.medicalapp.requests.di.DaggerRequestComponent;
import widgets.dinesh.com.medicalapp.requests.di.RequestModule;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class RequestsActivity extends BaseActivity {
    @BindView(R.id.rv_requests)
    RecyclerView rvRequests;

    @Inject
    RequestViewModel requestViewModel;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_requests;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerRequestComponent.builder()
                .applicationComponent(MedicalApplication.getComponent())
                .requestModule(new RequestModule(this))
                .rxModule(new RxModule())
                .build()
                .inject(this);
        requestViewModel.getRequestLiveData()
                .observe(this, this::updateData);

    }

    private void updateData(List<RequestEntity> requestEntities) {
        List<Object> items = new ArrayList<>();
        items.addAll(requestEntities);
        RequestAdapter medicalRecordsAdapter = new RequestAdapter(this, items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRequests.setLayoutManager(layoutManager);
        rvRequests.setAdapter(medicalRecordsAdapter);
        rvRequests.getAdapter().notifyDataSetChanged();
        ((ReactiveRecyclerAdapter)rvRequests.getAdapter()).
                getReactiveViewClickObservable()
                .subscribe(o -> {
                    requestViewModel.toggleAllowed((RequestEntity)o);
                });
    }
}
