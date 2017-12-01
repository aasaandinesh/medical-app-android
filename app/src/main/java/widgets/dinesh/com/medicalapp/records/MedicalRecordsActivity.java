package widgets.dinesh.com.medicalapp.records;

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
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordEntity;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordViewModel;
import widgets.dinesh.com.medicalapp.records.di.DaggerMedicalRecordComponent;
import widgets.dinesh.com.medicalapp.records.di.MedicalRecordModule;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class MedicalRecordsActivity extends BaseActivity {
    @BindView(R.id.rv_medical_records)
    RecyclerView rvMedicalRecords;

    @Inject
    MedicalRecordViewModel medicalRecordViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_medical_records;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerMedicalRecordComponent.builder()
                .applicationComponent(MedicalApplication.getComponent())
                .medicalRecordModule(new MedicalRecordModule(this))
                .rxModule(new RxModule())
                .build()
                .inject(this);
        medicalRecordViewModel.getMedicalRecordEntityLiveData()
                .observe(this, this::updateData);
    }

    private void updateData(List<MedicalRecordEntity> medicalRecordEntities) {
        List<Object> items = new ArrayList<>();
        items.addAll(medicalRecordEntities);
        MedicalRecordsAdapter medicalRecordsAdapter = new MedicalRecordsAdapter(this, items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMedicalRecords.setLayoutManager(layoutManager);
        rvMedicalRecords.setAdapter(medicalRecordsAdapter);
        rvMedicalRecords.getAdapter().notifyDataSetChanged();


    }
}
