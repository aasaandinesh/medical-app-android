package widgets.dinesh.com.medicalapp.patient.ui.activities;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import widgets.dinesh.com.medicalapp.R;
import widgets.dinesh.com.medicalapp.base.BaseActivity;
import widgets.dinesh.com.medicalapp.records.MedicalRecordsActivity;
import widgets.dinesh.com.medicalapp.requests.ui.RequestsActivity;
import widgets.dinesh.com.medicalapp.shared.models.UserEntity;

import static org.parceler.Parcels.unwrap;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class PatientActivity extends BaseActivity {

    public static final String USER_DATA = "userData";
    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_user_type)
    TextView tvUserType;

    @BindView(R.id.tv_user_id)
    TextView tvUserId;

    @BindView(R.id.tv_username)
    TextView tvUsername;

    @OnClick(R.id.bt_view_medical_reports)
    void viewMedicalReports(){
        openMedicalReportsActivity();
    }

    private void openMedicalReportsActivity() {
        openActivity(MedicalRecordsActivity.class);
    }

    @OnClick(R.id.bt_view_prescriotions)
    void viewPrescriptions(){
        openPrescriptionsActivity();
    }

    private void openPrescriptionsActivity() {

    }

    @OnClick(R.id.bt_view_requests)
    void viewRequests(){
        openRequestsActivity();
    }

    private void openRequestsActivity() {
        openActivity(RequestsActivity.class);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_patient;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        UserEntity userEntity =  unwrap(getIntent().getParcelableExtra(USER_DATA));
        tvName.setText(userEntity.getName());
        tvUserType.setText(userEntity.getUserType());
        tvUsername.setText(userEntity.getUsername());
        tvUserId.setText( String.valueOf(userEntity.getId()));
    }
}
