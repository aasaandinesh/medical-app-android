package widgets.dinesh.com.medicalapp.records;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import widgets.dinesh.com.medicalapp.R;
import widgets.dinesh.com.medicalapp.base.widgets.AbstractAdapterDelegate;
import widgets.dinesh.com.medicalapp.records.data.MedicalRecordEntity;
import widgets.dinesh.com.medicalapp.records.ui.MedicalRecordViewHolder;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class MedicalRecordsAdapterDelegate extends AbstractAdapterDelegate<List<MedicalRecordEntity>> {

    public MedicalRecordsAdapterDelegate(int viewType, Context context) {
        super(viewType, context);
    }

    @Override
    public boolean isForViewType(@NonNull List<MedicalRecordEntity> items, int position) {
        return true;
    }

    @Override
    public void onBindViewHolder(@NonNull List<MedicalRecordEntity> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        ((MedicalRecordViewHolder)holder).bind(items.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new MedicalRecordViewHolder(context, itemView);
    }

    @Override
    protected int getViewHolderLayout() {
        return R.layout.card_medical_record;
    }
}
