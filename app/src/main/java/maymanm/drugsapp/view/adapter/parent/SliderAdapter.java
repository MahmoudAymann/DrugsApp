package maymanm.drugsapp.view.adapter.parent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import maymanm.drugsapp.R;
import maymanm.drugsapp.databinding.ItemSliderViewBinding;
import maymanm.drugsapp.model.home.SlidersItem;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemSliderViewModel;
import maymanm.drugsapp.view.adapter.viewholder.SliderViewHolder;

public class SliderAdapter extends RecyclerView.Adapter<SliderViewHolder> {
    private List<? extends SlidersItem> mDataList;
    private MutableLiveData<SlidersItem> mutableLiveData;
    private static final int layoutRes = R.layout.item_slider_view;

    public SliderAdapter() {
        mutableLiveData = new MutableLiveData<>();
    }

    public void updateDataList(final List<? extends SlidersItem> items) {
        if (mDataList == null) {
            mDataList = items;
            notifyItemRangeInserted(0, items.size());
        } else {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mDataList.size();
                }
                @Override
                public int getNewListSize() {
                    return items.size();
                }
                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    SlidersItem old = mDataList.get(oldItemPosition);
                    SlidersItem myItem = items.get(newItemPosition);
                    return old.getId() == myItem.getId();
                }
                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    SlidersItem old = mDataList.get(oldItemPosition);
                    SlidersItem item = items.get(newItemPosition);
                    return old.getId() == item.getId()
                            && Objects.equals(old.getSliderImage(), item.getSliderImage());
                }
            });
            mDataList = items;
            diffResult.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemSliderViewBinding binding = DataBindingUtil.inflate(layoutInflater, layoutRes
                , parent, false);
        return new SliderViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setAnimation();
        ItemSliderViewModel viewModel = new ItemSliderViewModel(getCurrentItem(position));
        holder.setViewModel(viewModel);
        viewModel.getMutableLiveData().observeForever(o -> {
            mutableLiveData.setValue(getCurrentItem(position));
        });
    }

    private SlidersItem getCurrentItem(int pos) {
        return mDataList.get(pos);
    }


    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    //Helpers
    @Override
    public void onViewAttachedToWindow(@NonNull SliderViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull SliderViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public MutableLiveData<SlidersItem> getMutableLiveData() {
        return mutableLiveData;
    }
}