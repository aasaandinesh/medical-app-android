package widgets.dinesh.com.medicalapp.records.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import widgets.dinesh.com.medicalapp.R;
import widgets.dinesh.com.medicalapp.base.widgets.ReactiveViewHolder;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class MedicalRecordViewHolder extends ReactiveViewHolder<MedicalRecordEntity> {

    @BindView(R.id.tv_doctor)
    TextView tvDoctor;

    @BindView(R.id.tv_disease)
    TextView tvDisease;

    @BindView(R.id.tv_prescription)
    TextView tvPrescription;

    public MedicalRecordViewHolder(Context context, View itemView) {
        super(context, itemView);

    }

    @Override
    protected void bindData(MedicalRecordEntity data) {
        tvDoctor.setText(data.getDoctor());
        tvDisease.setText(data.getDisease());
        tvPrescription.setText(data.getPrescription());
    }
}

