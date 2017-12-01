package widgets.dinesh.com.medicalapp.requests.ui;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import widgets.dinesh.com.medicalapp.base.widgets.AdapterDelegate;
import widgets.dinesh.com.medicalapp.base.widgets.ReactiveRecyclerAdapter;

/**
 * Created by ajmac1005 on 30/11/17.
 */

public class RequestAdapter extends ReactiveRecyclerAdapter {

    public RequestAdapter(Context context, List<Object> items) {
        super(context);
        this.items = items;
    }

    @Override
    protected List<AdapterDelegate> initAdapterDelegates() {
    List<AdapterDelegate> adapterDelegates = new ArrayList<>();
    adapterDelegates.add(new RequestAdapterDelegate(1, context));
        return adapterDelegates;
    }
}
