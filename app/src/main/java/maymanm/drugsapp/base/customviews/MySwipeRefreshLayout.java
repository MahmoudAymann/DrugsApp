package maymanm.drugsapp.base.customviews;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import maymanm.drugsapp.R;

public class MySwipeRefreshLayout extends SwipeRefreshLayout {
    public MySwipeRefreshLayout(@NonNull Context context) {
        super(context);
        setColorSchemeResources(R.color.g_blue, R.color.g_red, R.color.g_yellow, R.color.g_green);
    }

    public MySwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setColorSchemeResources(R.color.g_blue, R.color.g_red, R.color.g_yellow, R.color.g_green);
    }
}
