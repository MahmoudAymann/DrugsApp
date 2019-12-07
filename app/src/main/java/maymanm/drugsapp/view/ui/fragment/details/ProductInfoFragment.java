package maymanm.drugsapp.view.ui.fragment.details;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import org.jetbrains.annotations.NotNull;
import maymanm.drugsapp.R;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentProductInfoBinding;
import maymanm.drugsapp.util.ArgsUtil;
import maymanm.drugsapp.viewmodel.fragment.main.ProductInfoViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductInfoFragment extends BaseFragment implements Observer<Object> {

    private FragmentProductInfoBinding binding;
    private ProductInfoViewModel viewModel;
    private String text;
    private int id;
    public ProductInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = ArgsUtil.getStringArg(getArguments(), Params.DESCRIPTION);
        id = ArgsUtil.getIntArg(getArguments(), Params.PRODUCT_ID);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_info, container, false);
        setupViewModel();
        return binding.getRoot();
    }

    private void setupViewModel() {
        viewModel = new ProductInfoViewModel(text, id);
        binding.setViewModel(viewModel);
        viewModel.getMutableLiveData().observe(getViewLifecycleOwner(), this);
    }

    @Override
    public void onChanged(Object o) {
        if (o instanceof Integer) {
            int result = (Integer) o;
            if (result == View.VISIBLE || result == View.GONE) {
                showProgressAnimation(result);
            } else if (result == Codes.SHOW_MESSAGE) {
                showMessage(viewModel.getMessage());
            }
        }
    }
}
