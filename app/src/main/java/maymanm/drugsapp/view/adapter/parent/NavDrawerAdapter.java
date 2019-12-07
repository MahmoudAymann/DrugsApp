package maymanm.drugsapp.view.adapter.parent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import maymanm.drugsapp.R;
import maymanm.drugsapp.databinding.ItemNavDrawerViewBinding;
import maymanm.drugsapp.model.navdrawer.NavDrawerItem;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemNavViewModel;
import maymanm.drugsapp.view.adapter.viewholder.NavDrawerViewHolder;
import timber.log.Timber;

public class NavDrawerAdapter extends RecyclerView.Adapter<NavDrawerViewHolder> {
    private List<? extends NavDrawerItem> mDataList;
    private MutableLiveData<NavDrawerItem> mutableLiveData;
    private static final int layoutRes = R.layout.item_nav_drawer_view;

    public NavDrawerAdapter() {
        mutableLiveData = new MutableLiveData<>();
    }

    public void updateDataList(final List<? extends NavDrawerItem> newList) {
        if (mDataList == null) {
            mDataList = newList;
            notifyItemRangeInserted(0, newList.size());
        } else {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mDataList.size();
                }

                @Override
                public int getNewListSize() {
                    return newList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    NavDrawerItem old = mDataList.get(oldItemPosition);
                    NavDrawerItem newItem = newList.get(newItemPosition);
                    return old.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    NavDrawerItem old = mDataList.get(oldItemPosition);
                    NavDrawerItem newItem = newList.get(newItemPosition);
                    return old.getId() == newItem.getId()
                            && Objects.equals(old.getTitle(), newItem.getTitle())
                            && old.getIconRes() == newItem.getIconRes();
                }
            });
            mDataList = newList;
            diffResult.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public NavDrawerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemNavDrawerViewBinding binding = DataBindingUtil.inflate(layoutInflater, layoutRes
                , parent, false);
        return new NavDrawerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull NavDrawerViewHolder holder, int position) {
        ItemNavViewModel viewModel = new ItemNavViewModel(getCurrentItem(position));
        holder.setViewModel(viewModel);
        viewModel.getMutableLiveData().observeForever(o -> {
            mutableLiveData.setValue(getCurrentItem(position));
            Timber.e("sssss");
        });
    }

    private NavDrawerItem getCurrentItem(int pos) {
        return mDataList.get(pos);
    }


    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    //Helpers
    @Override
    public void onViewAttachedToWindow(@NonNull NavDrawerViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull NavDrawerViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public MutableLiveData<NavDrawerItem> getMutableLiveData() {
        return mutableLiveData;
    }
}