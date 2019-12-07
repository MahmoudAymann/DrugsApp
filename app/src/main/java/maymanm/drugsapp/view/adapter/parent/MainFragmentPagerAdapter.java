package maymanm.drugsapp.view.adapter.parent;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

/**
 * Created by MahmoudAyman on 11/13/2019.
 **/
public class MainFragmentPagerAdapter extends FragmentStateAdapter {
    private ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    public MainFragmentPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    public void addFragment(Fragment fragment, Bundle bundleExtra) {
        fragment.setArguments(bundleExtra);
        fragmentArrayList.add(fragment);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentArrayList.get(position);
    }
    @Override
    public int getItemCount() {
        return fragmentArrayList.size();
    }
}
