package widgets.dinesh.com.medicalapp.requests.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import widgets.dinesh.com.medicalapp.R;
import widgets.dinesh.com.medicalapp.base.widgets.AbstractAdapterDelegate;
import widgets.dinesh.com.medicalapp.requests.data.RequestEntity;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class RequestAdapterDelegate extends AbstractAdapterDelegate<List<RequestEntity>> {

    public RequestAdapterDelegate(int viewType, Context context) {
        super(viewType, context);
    }

    @Override
    public boolean isForViewType(@NonNull List<RequestEntity> items, int position) {
        return true;
    }

    @Override
    public void onBindViewHolder(@NonNull List<RequestEntity> items, int position, @NonNull RecyclerView.ViewHolder holder) {
        ((RequesterViewholder)holder).bind(items.get(position));
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View itemView) {
        return new RequesterViewholder(context, itemView);
    }

    @Override
    protected int getViewHolderLayout() {
        return R.layout.card_request;
    }
}
