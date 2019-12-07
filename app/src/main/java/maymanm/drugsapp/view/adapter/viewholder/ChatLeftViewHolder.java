package maymanm.drugsapp.view.adapter.viewholder;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import maymanm.drugsapp.databinding.ItemChatLeftSideViewBinding;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemChatViewModel;

public class ChatLeftViewHolder extends RecyclerView.ViewHolder {

    private ItemChatLeftSideViewBinding binding;

    public ChatLeftViewHolder(@NonNull ViewDataBinding itemView) {
        super(itemView.getRoot());
        binding = (ItemChatLeftSideViewBinding) itemView;
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

    public void setViewModel(ItemChatViewModel viewModel) {
        if (binding != null) {
            binding.setViewModel(viewModel);
        }
    }
}
