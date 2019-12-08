package maymanm.drugsapp.view.ui.fragment.details;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.MovementManager;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentProductDetailsBinding;
import maymanm.drugsapp.util.ArgsUtil;
import maymanm.drugsapp.util.PreferenceHelperManager;
import maymanm.drugsapp.viewmodel.fragment.main.ProductDetailViewModel;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductDetailsFragment extends BaseFragment implements Observer<Object> {

    private FragmentProductDetailsBinding binding;
    private ProductDetailViewModel viewModel;
    private int drugId;

    public ProductDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drugId = ArgsUtil.getIntArg(getArguments(), Params.PRODUCT_ID);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_details, container, false);
        setupViewModel();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Timber.e(PreferenceHelperManager.getDrugId());
        Timber.e(PreferenceHelperManager.getIds()+"");
        for (int i = 0; i < PreferenceHelperManager.getIds().size(); i++) {
            if (PreferenceHelperManager.getIds().get(i).equals(PreferenceHelperManager.getDrugId())) {
                setFav(true);
                Timber.e("ssssss");
                break;
            }
        }
    }

    private void setupViewModel() {
        viewModel = new ProductDetailViewModel(drugId);
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
            } else if (result == Codes.COMPOSITION) {
                Bundle bundle = new Bundle();
                bundle.putString(Params.DESCRIPTION, viewModel.item.getComposition());
                bundle.putInt(Params.PRODUCT_ID, drugId);
                MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_INFO, bundle);
            } else if (result == Codes.INDICATION) {
                Bundle bundle = new Bundle();
                bundle.putString(Params.DESCRIPTION, viewModel.item.getIndication());
                bundle.putInt(Params.PRODUCT_ID, drugId);
                MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_INFO, bundle);
            } else if (result == Codes.CONTRAINDICATION) {
                Bundle bundle = new Bundle();
                bundle.putString(Params.DESCRIPTION, viewModel.item.getContraindications());
                bundle.putInt(Params.PRODUCT_ID, drugId);
                MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_INFO, bundle);
            } else if (result == Codes.PRECAUTIONS) {
                Bundle bundle = new Bundle();
                bundle.putString(Params.DESCRIPTION, viewModel.item.getPrecautions());
                bundle.putInt(Params.PRODUCT_ID, drugId);
                MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_INFO, bundle);
            } else if (result == Codes.PREGNANCY) {
                Bundle bundle = new Bundle();
                bundle.putString(Params.DESCRIPTION, viewModel.item.getPregnancy());
                bundle.putInt(Params.PRODUCT_ID, drugId);
                MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_INFO, bundle);
            } else if (result == Codes.INTERACTIONS) {
                Bundle bundle = new Bundle();
                bundle.putString(Params.DESCRIPTION, viewModel.item.getInteractions());
                bundle.putInt(Params.PRODUCT_ID, drugId);
                MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_INFO, bundle);
            } else if (result == Codes.SIDE_EFFECTS) {
                Bundle bundle = new Bundle();
                bundle.putString(Params.DESCRIPTION, viewModel.item.getSideEffects());
                bundle.putInt(Params.PRODUCT_ID, drugId);
                MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_INFO, bundle);
            }else if (result == Codes.DOSE){
                Bundle bundle = new Bundle();
                bundle.putString(Params.DESCRIPTION, viewModel.item.getDose());
                bundle.putInt(Params.PRODUCT_ID, drugId);
                MovementManager.startDetailsActivity(getContext(), Codes.PRODUCT_INFO, bundle);
            }
        }
    }
}
