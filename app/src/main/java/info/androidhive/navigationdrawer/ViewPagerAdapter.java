package info.androidhive.navigationdrawer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by zorica on 11.1.18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmenti = new ArrayList<Fragment>();
    ArrayList<String> titles = new ArrayList<String>();

    public void dodadiFragment (Fragment fragment){
        fragmenti.add(fragment);

    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmenti.get(position);
    }

    @Override
    public int getCount() {
        return fragmenti.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {return titles.get(position);}

}