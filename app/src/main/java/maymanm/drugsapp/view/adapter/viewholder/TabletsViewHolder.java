package maymanm.drugsapp.view.adapter.viewholder;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import maymanm.drugsapp.databinding.ItemFavouriteViewBinding;
import maymanm.drugsapp.databinding.ItemTabletViewBinding;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemFavouriteViewModel;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemTabletViewModel;

public class TabletsViewHolder extends RecyclerView.ViewHolder {

    private ItemTabletViewBinding binding;

    public TabletsViewHolder(@NonNull ItemTabletViewBinding binding) {
        super(binding.getRoot());
        this.binding= binding;
    }

    public void bind() {
        if (binding == null) {
            binding = DataBindingUtil.bind(itemView);
        }
    }

    public void unbind() {
        if (binding != null) {
            binding.unbind(); // Don't forget to unbind
        }
    }

    public void setViewModel(ItemTabletViewModel viewModel) {
        if (binding != null) {
            binding.setViewModel(viewModel);
        }
    }

}
