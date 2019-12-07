package maymanm.drugsapp.databinding;

import android.animation.Animator;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;

import com.chaos.view.PinView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import maymanm.drugsapp.R;
import maymanm.drugsapp.application.BaseApplication;
import maymanm.drugsapp.base.constantsutils.Codes;
import maymanm.drugsapp.base.filesutils.VolleyFileObject;
import maymanm.drugsapp.base.volleyutils.ConnectionHelper;
import maymanm.drugsapp.util.ApplicationUtil;
import maymanm.drugsapp.util.MyAnimation;
import maymanm.drugsapp.util.PreferenceHelperManager;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import timber.log.Timber;

public class OtherViewsBinding {

    @BindingAdapter({"imageUrl"})
    public void bindImageView(ImageView imageView, Object path) {
        if (path == null) {
            imageView.setImageResource(R.drawable.logo);
        }
        if (path instanceof Integer) {
            imageView.setImageResource((Integer) path);
        } else if (path instanceof String) {
            if (((String) path).startsWith("http"))
                ConnectionHelper.loadImage(imageView, (String) path);
            else {
                imageView.setImageBitmap(ApplicationUtil.stringToBitMap((String) path));
            }
        } else
            imageView.setImageDrawable((BitmapDrawable) path);
    }

    @BindingAdapter("app:animatePinView")
    public void bindPinView(PinView pinView, boolean animate) {
        pinView.setAnimationEnable(animate);
    }

    @BindingAdapter({"imageUrl"})
    public void bindImageCircularImageView(CircleImageView imageView, Object path) {
        if (path == null) {
            imageView.setImageResource(R.drawable.logo);
        }
        if (path instanceof BitmapDrawable) {
            imageView.setImageDrawable((BitmapDrawable) path);
        } else if (path instanceof String) {
            ConnectionHelper.loadImage(imageView, (String) path);
        } else if (path instanceof Integer) {
            imageView.setImageResource((Integer) path);
        }
    }

    @BindingAdapter({"app:profileImageWhite"})
    public void bindProfileImageWhite(CircleImageView imageView, Object path) {
        if (path == null) {
            imageView.setImageResource(R.drawable.ic_add_image_placeholder_white);
            return;
        }
        if (path instanceof BitmapDrawable) {
            imageView.setImageDrawable((BitmapDrawable) path);
        } else if (path instanceof String) {
            ConnectionHelper.loadImage(imageView, (String) path);
        } else if (path instanceof Integer) {
            imageView.setImageResource((Integer) path);
        }
    }

    @BindingAdapter({"app:profileImage"})
    public void bindProfileImage(CircleImageView imageView, Object path) {
        if (path == null) {
            imageView.setImageResource(R.drawable.ic_add_image_placeholder);
            return;
        }
        if (path instanceof BitmapDrawable) {
            imageView.setImageDrawable((BitmapDrawable) path);
        } else if (path instanceof String) {
            ConnectionHelper.loadImage(imageView, (String) path);
        } else if (path instanceof Integer) {
            imageView.setImageResource((Integer) path);
        }
    }


    @BindingAdapter({"myIcon"})
    public void bindIconMaterialBtnView(MaterialButton button, int resId) {
        if (resId == 0) {
            button.setIcon(null);
            return;
        }
        button.setIcon(ContextCompat.getDrawable(BaseApplication.getInstance().getApplicationContext(), resId));
    }

    @BindingAdapter({"android:text"})
    public void bindText(TextView textView, Object value) {
        textView.setText(value.toString());
    }


    @BindingAdapter("android:drawableStart")
    public void bindTexTview(TextView textView, int drawableRes) {
        if (PreferenceHelperManager.getLanguage().equals("en")) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawableRes, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawableRes, 0);
        }
    }


    @BindingAdapter("app:onTextChangedListener")
    public void bindTextChanged(EditText editText, TextWatcher textWatcher) {
        editText.addTextChangedListener(textWatcher);
    }

    @BindingAdapter("app:onTextChangedListener")
    public void bindTextChanged(TextInputEditText editText, TextWatcher textWatcher) {
        editText.addTextChangedListener(textWatcher);
    }


    @BindingAdapter("app:onEndIconClickListener")
    public void bindTextInputLayout(TextInputLayout inputLayout, View.OnClickListener onClickListener) {
        inputLayout.setEndIconOnClickListener(onClickListener);
    }

    @BindingAdapter("android:rating")
    public void bindRatingBar(MaterialRatingBar ratingBar, Object result) {
        if (result == null)
            return;
        float value;
        if (result instanceof Integer) {
            value = (float) ((Integer) result);
        } else if (result instanceof String) {
            value = Float.parseFloat(result.toString());
        } else
            value = (float) result;
        ratingBar.setRating(value);
    }


    @BindingAdapter("app:setColor")
    public void bindColor(MaterialCardView cardView, String color) {
        if (color == null) {
            color = "#FFFFFF";
        }
        cardView.setCardBackgroundColor(ApplicationUtil.getColorInt(color));
    }


    @BindingAdapter("app:animateArrow")
    public void bindImageArrow(ImageView imageView, ObservableBoolean obsBoolean) {
        if (!obsBoolean.get()) { //animate to up
            imageView.animate().setDuration(300).rotation(0f).start();
        } else
            imageView.animate().setDuration(300).rotation(180f).start();
    }


    @BindingAdapter("app:removeImageOnEndIconClickListener")
    public void bindTextInputLayout(TextInputLayout inputLayout, ArrayList<VolleyFileObject> list) {
        inputLayout.setEndIconOnClickListener(view -> {
            if (list != null)
                list.clear();
            else
                Timber.e("list is null");
        });
    }

    @BindingAdapter("app:visibleInvisible")
    public void bindVisibleInvisible(View view, boolean value) {
        if (value) {
            view.setVisibility(View.VISIBLE);
        } else
            view.setVisibility(View.INVISIBLE);

    }


    @BindingAdapter("app:visibleInvisible")
    public void bindVisibleInvisible(View view, ObservableBoolean value) {
        if (value.get()) {
            view.setVisibility(View.VISIBLE);
        } else
            view.setVisibility(View.INVISIBLE);

    }

    @BindingAdapter("app:visibleGone")
    public void bindVisibleGone(View view, boolean value) {
        if (value) {
            view.setVisibility(View.VISIBLE);
        } else
            view.setVisibility(View.GONE);

    }


    @BindingAdapter("app:visibleGone")
    public void bindVisibleGone(View view, ObservableBoolean value) {
        if (value.get()) {
            view.setVisibility(View.VISIBLE);
        } else
            view.setVisibility(View.GONE);

    }

    @BindingAdapter("app:animateVisible")
    public void bindAnimateVisible(View view, ObservableBoolean value) {
        if (value.get()) {
            MyAnimation.expand(view);
        } else {
            Animator.AnimatorListener listener = null;
            MyAnimation.collapse(view, listener);
        }

    }

    @BindingAdapter("app:visibleGoneCardView")
    public void bindVisibleGone(MaterialCardView view, boolean value) {
        if (value) {
            view.setVisibility(View.VISIBLE);
        } else
            view.setVisibility(View.GONE);
    }

    @BindingAdapter("app:visibleGoneCardView")
    public void bindVisibleGone(MaterialCardView view, ObservableBoolean value) {
        if (value.get()) {
            view.setVisibility(View.VISIBLE);
        } else
            view.setVisibility(View.GONE);
    }

    @BindingAdapter("switchChangedListener")
    public void bindSwitchChangedListener(SwitchMaterial switchMaterial,
                                          CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        switchMaterial.setOnCheckedChangeListener(onCheckedChangeListener);
    }


}
