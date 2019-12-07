package maymanm.drugsapp.base.view;

import android.Manifest;
import android.content.Context;
import android.net.NetworkInfo.DetailedState;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.airbnb.lottie.LottieAnimationView;

import org.jetbrains.annotations.NotNull;

import maymanm.drugsapp.R;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.filesutils.FileOperations;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.util.PermissionManager;
import maymanm.drugsapp.util.SettingsManager;
import maymanm.drugsapp.view.ui.activity.AuthActivity;
import maymanm.drugsapp.view.ui.activity.DetailsActivity;
import maymanm.drugsapp.view.ui.activity.MainActivity;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class BaseFragment extends Fragment {
    private FragmentActivity mContext;
    private Disposable permissionDis;

    private void showProgressBar(int show) {
        ProgressBar progressBar;
        if (mContext instanceof AuthActivity) {
            try {
                progressBar = ((AuthActivity) mContext).getProgressBar();
                progressBar.setVisibility(show);
            } catch (ClassCastException e) {
                e.getStackTrace();
            }
        } else if (mContext instanceof MainActivity) {
//            try {
//                progressBar = ((MainActivity) mContext).getProgressBar();
//                progressBar.setVisibility(show);
//            } catch (ClassCastException e) {
//                e.getStackTrace();
//            }
        }
    }

    public void setFav(boolean fav) {
        if (mContext instanceof DetailsActivity) {
            ((DetailsActivity) mContext).setFavourite(fav);
        }
    }

    private void showAnimation(int resRaw, int show) {
        LottieAnimationView animationView;
//        if (mContext instanceof MainActivity) {
//            animationView = ((MainActivity) mContext).getAnimationView();
//        } else {
        animationView = ((AuthActivity) mContext).getAnimationView();
//        }
        animationView.setAnimation(resRaw);
        animationView.setVisibility(show);
        if (show == View.VISIBLE)
            animationView.playAnimation();
        else
            animationView.cancelAnimation();
    }

    protected void showProgressAnimation(int show) {
        LottieAnimationView animationView;
        if (mContext instanceof DetailsActivity) {
            animationView = ((DetailsActivity) mContext).getAnimationView();
        } else if (mContext instanceof AuthActivity) {
            animationView = ((AuthActivity) mContext).getAnimationView();
        } else if (mContext instanceof DialogActivity) {
            animationView = ((DialogActivity) mContext).getAnimationView();
        } else {
            Timber.e("ACTIVITY INSTANCE NOT FOUND");
            return;
        }
        animationView.setAnimation(R.raw.load_anim);
        animationView.setVisibility(show);
        if (show == View.VISIBLE)
            animationView.playAnimation();
        else
            animationView.cancelAnimation();
    }

    public void showMessage(Object message) {
        if (mContext instanceof AuthActivity) {
            ((AuthActivity) mContext).showMessage(message);
        } else if (mContext instanceof MainActivity) {
            ((MainActivity) mContext).showMessage(message);
        } else if (mContext instanceof DetailsActivity) {
            ((DetailsActivity) mContext).showMessage(message);
        }
    }

    protected void refreshUserDataInNavHeader() {
        ((MainActivity) mContext).getViewModel().refreshUserData();
    }

    public void setToolbarTitle(String title) {
        if (mContext instanceof DetailsActivity) {
            ((DetailsActivity) mContext).getToolbarTitle().setText(title);
        }
    }

    protected boolean isGPSEnabled() {
        if (SettingsManager.isGPSEnabled(getContext())) {
            return true;
        } else {
            MyAnimation.starDialogWithAnim(requireActivity(), Codes.LOCATION_DIALOG, ApplicationUtil.getRootView(requireActivity()));
            return false;
        }
    }

    protected boolean hasLocationPermission() {
        return PermissionManager.isGranted(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
    }

    protected void pickImage(int reqCode) {
        if (!PermissionManager.hasImagePermission(requireActivity())) {
            permissionDis = PermissionManager
                    .request(requireActivity(), new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE, CAMERA})
                    .subscribe(granted -> {
                        if (granted) {
                            FileOperations.pickImage(getActivity(), reqCode);
                            permissionDis.dispose();
                        } else {
                            MyAnimation.starDialogWithAnim(mContext, Codes.PERMISSION_DIALOG, ApplicationUtil.getRootView(requireActivity()));
                        }
                    });
        } else {
            FileOperations.pickImage(requireActivity(), reqCode);
        }
    }

    public void enableSearch(boolean showQrScan) {

    }

    @Override
    public void onDestroyView() {
        mContext = null;
        super.onDestroyView();
    }

    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        try {
            mContext = (FragmentActivity) context;
        } catch (Exception e) {
            Timber.e(e);
        }
    }

    @NonNull
    @Override
    public Context getContext() {
        return mContext == null ? requireActivity() : mContext;
    }
}
