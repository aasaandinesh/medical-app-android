package widgets.dinesh.com.medicalapp.requests.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import widgets.dinesh.com.medicalapp.R;
import widgets.dinesh.com.medicalapp.base.widgets.ReactiveViewHolder;
import widgets.dinesh.com.medicalapp.requests.data.RequestEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class RequesterViewholder extends ReactiveViewHolder<RequestEntity> {
    @BindView(R.id.tv_doctor)
    TextView tvRequester;

    @BindView(R.id.tv_disease)
    TextView tvPatient;

    @BindView(R.id.tv_prescription)
    TextView tvAllowed;

    public RequesterViewholder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    protected void bindData(RequestEntity data) {
        tvRequester.setText(data.getBusinessUser().getName());
        tvPatient.setText(data.getPatient().getName());
        tvAllowed.setText(String.valueOf(data.isAllowed()));
    }
}
