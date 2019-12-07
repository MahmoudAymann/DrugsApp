package maymanm.drugsapp.view.adapter.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import maymanm.drugsapp.R;
import maymanm.drugsapp.databinding.ItemHomeViewBinding;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemHomeViewModel;

public class HomeViewHolder extends RecyclerView.ViewHolder {

    private ItemHomeViewBinding binding;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        bind();
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

    public void setViewModel(ItemHomeViewModel viewModel) {
        if (binding != null) {
            binding.setViewModel(viewModel);
        }
    }

    public void setAnimation() {
        MyAnimation.startAnimation(R.anim.zoom_in, itemView);
    }
}
