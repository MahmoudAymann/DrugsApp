package maymanm.drugsapp.view.adapter.viewholder;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import maymanm.drugsapp.R;
import maymanm.drugsapp.databinding.ItemSliderViewBinding;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemSliderViewModel;

public class SliderViewHolder extends RecyclerView.ViewHolder {

    private ItemSliderViewBinding binding;

    public SliderViewHolder(ItemSliderViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
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

    public void setViewModel(ItemSliderViewModel viewModel) {
        if (binding != null) {
            binding.setViewModel(viewModel);
        }
    }

    public void setAnimation() {
        if (PreferenceHelperManager.getLanguage().equals("ar"))
            MyAnimation.startAnimation(R.anim.right_in, itemView);
        else
            MyAnimation.startAnimation(R.anim.left_in, itemView);
    }
}
