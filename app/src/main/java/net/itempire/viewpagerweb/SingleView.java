package net.itempire.viewpagerweb;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SingleView extends Fragment {

    ViewPager viewPager;
    ImagesPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_single_view, container, false);

        viewPager = (ViewPager) v.findViewById(R.id.vpPetImages);
        FragmentManager fragmentManager = getChildFragmentManager();
        // getChildFragmentManager because we are going to use a fragment inside another fragment,
        // so getFragmentManager() or getActivity().getSupportFragmentManager() will return the fragmentManager of Parent Fragment.

        adapter = new ImagesPagerAdapter(fragmentManager,getActivity().getApplicationContext());
        addFragments();
        adapter.notifyDataSetChanged();
        viewPager.setAdapter(adapter);

        return v;
    } // End of onCreateView

    private void addFragments(){
        ImageSwipeFragment fragment = new ImageSwipeFragment();
        ImageSwipeFragment fragment2 = new ImageSwipeFragment();
        ImageSwipeFragment fragment3 = new ImageSwipeFragment();
        fragment.setImageNumber(0);
        fragment2.setImageNumber(1);
        fragment3.setImageNumber(2);
        adapter.addFragment(fragment);
        adapter.addFragment(fragment2);
        adapter.addFragment(fragment3);
    }

}

class ImagesPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    Context context;

    /**
     * Creates a new PagerAdapter instance.
     *
     * @param fragmentManager The FragmentManager.
     */
    public ImagesPagerAdapter(FragmentManager fragmentManager, Context ctx) {
        super(fragmentManager);
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Adds the fragment to the list, also adds the fragment's tab title.
     *
     * @param fragment New instance of the Fragment to be associated with this tab.
     */
    public void addFragment(Fragment fragment) {
        fragments.add(fragment);
    }

}