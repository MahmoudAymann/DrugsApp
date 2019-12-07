package maymanm.drugsapp.view.adapter.parent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import maymanm.drugsapp.R;
import maymanm.drugsapp.model.home.HomeItem;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemHomeViewModel;
import maymanm.drugsapp.view.adapter.viewholder.HomeViewHolder;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    private List<HomeItem> dataList;
    private MutableLiveData<HomeItem> mutableLiveData;
    public HomeAdapter() {
        mutableLiveData = new MutableLiveData<>();
        dataList = new ArrayList<>();
    }

    public MutableLiveData<HomeItem> getMutableLiveData() {
        return mutableLiveData;
    }

    public void updateDataList(List<HomeItem> dataList) {
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull HomeViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull HomeViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_view,
                new FrameLayout(parent.getContext()), false);
        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.setAnimation(); //for item animation
        ItemHomeViewModel viewModel = new ItemHomeViewModel(getCurrentItem(position));
        holder.setViewModel(viewModel);
        viewModel.getMutableLiveData().observeForever(o -> {
            notifyItemChanged(position);
            //listen inside the adapter for mutable data change to get the item details
            mutableLiveData.setValue(getCurrentItem(position));
        });
    }

    private HomeItem getCurrentItem(int pos) {
        return dataList.get(pos);
    }



    @Override
    public int getItemCount() {
        return  dataList.size() ;
    }
}
