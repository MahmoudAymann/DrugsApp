package maymanm.drugsapp.view.adapter.viewholder;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import maymanm.drugsapp.databinding.ItemDrugsViewBinding;
import maymanm.drugsapp.databinding.ItemFavouriteViewBinding;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemDrugViewModel;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemFavouriteViewModel;

public class DrugsViewHolder extends RecyclerView.ViewHolder {

    private ItemDrugsViewBinding binding;

    public DrugsViewHolder(@NonNull ItemDrugsViewBinding binding) {
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

    public void setViewModel(ItemDrugViewModel viewModel) {
        if (binding != null) {
            binding.setViewModel(viewModel);
        }
    }

}
