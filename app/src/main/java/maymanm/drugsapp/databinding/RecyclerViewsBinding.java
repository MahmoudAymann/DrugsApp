package maymanm.drugsapp.databinding;

import android.graphics.drawable.Drawable;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;


/**
 * created by MahmoudAyman
 */
public class RecyclerViewsBinding {

    @BindingAdapter(value = {"app:adapter", "app:itemTouchHelper", "app:divider", "app:dividerDrawable"}, requireAll = false)
    public void bindRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter,
                                 ItemTouchHelper.SimpleCallback itemTouchHelper, boolean divider, Drawable dividerDrawableRes) {
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        if (itemTouchHelper != null)
            new ItemTouchHelper(itemTouchHelper).attachToRecyclerView(recyclerView);
        if (divider) {
            DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayoutManager.VERTICAL);
            if (dividerDrawableRes != null)
                decoration.setDrawable(dividerDrawableRes);
            recyclerView.addItemDecoration(decoration);
        }
    }

    @BindingAdapter({"app:adapter"})
    public void bindViewPager(ViewPager2 viewPager, RecyclerView.Adapter adapter) {
        viewPager.setUserInputEnabled(false);
        viewPager.setAdapter(adapter);
    }


}
