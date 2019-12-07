package maymanm.drugsapp.view.adapter.parent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;
import maymanm.drugsapp.R;
import maymanm.drugsapp.databinding.ItemFavouriteViewBinding;
import maymanm.drugsapp.databinding.ItemTabletViewBinding;
import maymanm.drugsapp.model.drugs.TabletsItem;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemFavouriteViewModel;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemTabletViewModel;
import maymanm.drugsapp.view.adapter.viewholder.TabletsViewHolder;
import maymanm.drugsapp.view.adapter.viewholder.TabletsViewHolder;

public class TabletsAdapter extends RecyclerView.Adapter<TabletsViewHolder> {
    private List<? extends TabletsItem> mDataList;
    private MutableLiveData<TabletsItem> mutableLiveData;
    private static final int layoutRes = R.layout.item_tablet_view;

    public TabletsAdapter() {
        mutableLiveData = new MutableLiveData<>();
    }

    public void updateDataList(final List<? extends TabletsItem> newList) {
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
                    TabletsItem old = mDataList.get(oldItemPosition);
                    TabletsItem newItem = newList.get(newItemPosition);
                    return old.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    TabletsItem old = mDataList.get(oldItemPosition);
                    TabletsItem newItem = newList.get(newItemPosition);
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
    public TabletsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ItemTabletViewBinding binding = DataBindingUtil.inflate(layoutInflater, layoutRes
                , parent, false);
        return new TabletsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TabletsViewHolder holder, int position) {
        ItemTabletViewModel viewModel = new ItemTabletViewModel(getCurrentItem(position));
        holder.setViewModel(viewModel);
        viewModel.getMutableLiveData().observeForever(o -> {
            mutableLiveData.setValue(getCurrentItem(position));
        });
    }

    private TabletsItem getCurrentItem(int pos) {
        return mDataList.get(pos);
    }


    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    //Helpers
    @Override
    public void onViewAttachedToWindow(@NonNull TabletsViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull TabletsViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public MutableLiveData<TabletsItem> getMutableLiveData() {
        return mutableLiveData;
    }
}