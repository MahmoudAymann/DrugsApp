package maymanm.drugsapp.view.adapter.parent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;

import maymanm.drugsapp.R;
import maymanm.drugsapp.databinding.ItemFavouriteViewBinding;
import maymanm.drugsapp.model.drugs.DrugsItem;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemFavouriteViewModel;
import maymanm.drugsapp.view.adapter.viewholder.FavouriteViewHolder;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteViewHolder> implements Filterable {
    private List<? extends DrugsItem> mDataList;
    private MutableLiveData<DrugsItem> mutableLiveData;
    private static final int layoutRes = R.layout.item_favourite_view;

    public FavouriteAdapter() {
        mutableLiveData = new MutableLiveData<>();
    }

        public void updateDataList(final List<? extends DrugsItem> newList) {
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
                    DrugsItem old = mDataList.get(oldItemPosition);
                    DrugsItem newItem = newList.get(newItemPosition);
                    return old.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    DrugsItem old = mDataList.get(oldItemPosition);
                    DrugsItem newItem = newList.get(newItemPosition);
                    return old.getId() == newItem.getId()
                            && Objects.equals(old.getName(), newItem.getName())
                            &&old.getCategory() == newItem.getCategory();
                }
            });
            mDataList = newList;
            diffResult.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public FavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemFavouriteViewBinding binding = DataBindingUtil.inflate(layoutInflater, layoutRes
                , parent, false);
        return new FavouriteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteViewHolder holder, int position) {
        ItemFavouriteViewModel viewModel = new ItemFavouriteViewModel(getCurrentItem(position));
        holder.setViewModel(viewModel);
        viewModel.getMutableLiveData().observeForever(o -> {
            mutableLiveData.setValue(getCurrentItem(position));
        });
    }

    private DrugsItem getCurrentItem(int pos) {
        return mDataList.get(pos);
    }


    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    //Helpers
    @Override
    public void onViewAttachedToWindow(@NonNull FavouriteViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull FavouriteViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public MutableLiveData<DrugsItem> getMutableLiveData() {
        return mutableLiveData;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}