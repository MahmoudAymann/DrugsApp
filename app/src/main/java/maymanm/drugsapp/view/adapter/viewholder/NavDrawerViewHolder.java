package maymanm.drugsapp.view.adapter.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import maymanm.drugsapp.databinding.ItemNavDrawerViewBinding;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemNavViewModel;

public class NavDrawerViewHolder extends RecyclerView.ViewHolder {

    private ItemNavDrawerViewBinding binding;

    public NavDrawerViewHolder(@NonNull ItemNavDrawerViewBinding binding) {
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

    public void setViewModel(ItemNavViewModel viewModel) {
        if (binding != null) {
            binding.setViewModel(viewModel);
        }
    }

}
