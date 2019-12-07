package maymanm.drugsapp.view.ui.fragment.dialogs;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.constantsutils.Params;
import maymanm.drugsapp.base.view.BaseFragment;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.databinding.FragmentImageDialogBinding;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.ArgsUtil;
import maymanm.drugsapp.view.ui.clickhandler.DialogsClickHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImageDialogFragment extends BaseFragment {

    private FragmentImageDialogBinding binding;
    private String imageUrl;
    public ImageDialogFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageUrl = ArgsUtil.getStringArg(getArguments(), Params.IMAGE);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_dialog, container, false);
        binding.setClickHandler(new DialogsClickHandler(requireActivity()));
        setImage();
        return binding.getRoot();
    }

    private void setImage() {
        if (imageUrl.startsWith("http")){
            ConnectionHelper.loadImage(binding.imageView, imageUrl, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    binding.progressBar.setVisibility(View.VISIBLE);
                }
                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    binding.progressBar.setVisibility(View.GONE);
                }
                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    binding.progressBar.setVisibility(View.GONE);
                }
                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    binding.progressBar.setVisibility(View.GONE);
                }
            });
        }else {
            binding.imageView.setImageBitmap(ApplicationUtil.stringToBitMap(imageUrl));
        }
    }
}
