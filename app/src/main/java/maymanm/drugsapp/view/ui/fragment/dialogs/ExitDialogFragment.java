package maymanm.drugsapp.view.ui.fragment.dialogs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.databinding.FragmentExitDialogBinding;
import maymanm.drugsapp.view.ui.clickhandler.DialogsClickHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExitDialogFragment extends BaseFragment {

    private FragmentExitDialogBinding binding;
    public ExitDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exit_dialog, container, false);
        binding.setClickHandler(new DialogsClickHandler(requireActivity()));
        return binding.getRoot();
    }
}
