package widgets.dinesh.com.medicalapp.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import widgets.dinesh.com.medicalapp.MedicalApplication;
import widgets.dinesh.com.medicalapp.R;
import widgets.dinesh.com.medicalapp.base.BaseActivity;
import widgets.dinesh.com.medicalapp.login.di.DaggerLoginComponent;
import widgets.dinesh.com.medicalapp.login.di.LoginModule;
import widgets.dinesh.com.medicalapp.login.viewmodel.LoginViewModel;
import widgets.dinesh.com.medicalapp.patient.ui.activities.PatientActivity;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class LoginActivity extends BaseActivity {

    @Inject
    LoginViewModel loginViewModel;

    @OnClick(R.id.bt_login)
    void login(){
        String username = etUsername.getText().toString();
        loginViewModel.login(username);

    }

    @BindView(R.id.et_username)
    EditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerLoginComponent.builder()
                .applicationComponent(MedicalApplication.getComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
        loginViewModel.getUserEntityLiveData().observe(this, userEntity -> {
            if(userEntity.getUsername()==null){
                //Do Nothing
            }
            else {
                //Open New Activity
                Intent intent = new Intent(LoginActivity.this, PatientActivity.class);
                intent.putExtra(PatientActivity.USER_DATA, Parcels.wrap(userEntity));
                startActivity(intent);
                Toast.makeText(this, userEntity.getUsername(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_login;
    }


}
