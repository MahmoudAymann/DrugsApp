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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import maymanm.drugsapp.R;
import maymanm.drugsapp.databinding.ItemDrugsViewBinding;
import maymanm.drugsapp.model.drugs.DrugsItem;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemDrugViewModel;
import maymanm.drugsapp.view.adapter.viewholder.DrugsViewHolder;

public class DrugsAdapter extends RecyclerView.Adapter<DrugsViewHolder> implements Filterable {
    private List<? extends DrugsItem> mDataList;
    private MutableLiveData<DrugsItem> mutableLiveData;
    private List<DrugsItem> oldListData;
    private List<DrugsItem> filteredList;
    private static final int layoutRes = R.layout.item_drugs_view;

    public DrugsAdapter() {
        mutableLiveData = new MutableLiveData<>();
    }

    public void setOldListData(List<DrugsItem> oldListData) {
        if(this.oldListData == null){
            this.oldListData = new ArrayList<>();
        }
        this.oldListData = oldListData;
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
                            && Objects.equals(old.getName(), newItem.getName());
                }
            });
            mDataList = newList;
            diffResult.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @Override
    public DrugsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemDrugsViewBinding binding = DataBindingUtil.inflate(layoutInflater, layoutRes
                , parent, false);
        return new DrugsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DrugsViewHolder holder, int position) {
        ItemDrugViewModel viewModel = new ItemDrugViewModel(getCurrentItem(position));
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
    public void onViewAttachedToWindow(@NonNull DrugsViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull DrugsViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public MutableLiveData<DrugsItem> getMutableLiveData() {
        return mutableLiveData;
    }

    @Override
    public Filter getFilter() {
        return new MyNamesFilter();
    }

    private class MyNamesFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String charString = constraint.toString();
            filteredList = new ArrayList<>();
            if (!charString.isEmpty()) {
                for (DrugsItem row : oldListData) {
                    // set your conditions here.
                    if (row.getName().toLowerCase().contains(charString.toLowerCase())) {
                        filteredList.add(row);
                    }
                }
            }else {
                filteredList = new ArrayList<>();
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (List<DrugsItem>) results.values;
            updateDataList(filteredList);
        }
    }

}