package net.itempire.viewpagerweb;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager = null;
    TabsPagerAdapter adapter;
    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager = (ViewPager) findViewById(R.id.vpMain);
        //viewPager.setAdapter(new mPagerAdapter(fragmentManager));
        adapter = new TabsPagerAdapter(fragmentManager, MainActivity.this);
        addFragments();
        adapter.notifyDataSetChanged();
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Show the title of fragment
                Toast.makeText(MainActivity.this, adapter.tabTitles.get(position), Toast.LENGTH_SHORT).show();

                //If fragment being loaded is later than the first one,
                // then add one more fragment after the last fragment to the adapter.
                if(position>currentPosition){
                    currentPosition+=1;
                    adapter.addFragment(new SingleView(), "Fragment"+String.valueOf(position+3));
                    adapter.notifyDataSetChanged();
                }else{
                    currentPosition--;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    private void addFragments(){
        adapter.addFragment(new SingleView(), "Fragment1");
        adapter.addFragment(new SingleView(), "Fragment2");
        adapter.addFragment(new SingleView(), "Fragment3");
    }
}


class TabsPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    public List<String> tabTitles = new ArrayList<>();
    private int fragmentPosition = 0;
    Context context;

    /**
     * Creates a new PagerAdapter instance.
     *
     * @param fragmentManager The FragmentManager.
     */
    public TabsPagerAdapter(FragmentManager fragmentManager, Context ctx) {
        super(fragmentManager);
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
//        if(position == 0){
//            Fragment fragment = fragments.get(fragmentPosition);
//            Toast.makeText(context, tabTitles.get(fragmentPosition), Toast.LENGTH_SHORT).show();
//            fragmentPosition++;
//            return fragment;
//        }
//        else{
//            Fragment fragment = fragments.get(fragmentPosition);
//            Toast.makeText(context, tabTitles.get(fragmentPosition), Toast.LENGTH_SHORT).show();
//            addFragment(new SingleView(),"Fragment"+fragments.size()+1);
//            notifyDataSetChanged();
//            fragmentPosition++;
//            return fragment;
//        }
//        if(position == 0){
//            Toast.makeText(context, tabTitles.get(position), Toast.LENGTH_SHORT).show();
//            return fragments.get(position);
//        }
//        else{
//            Toast.makeText(context, tabTitles.get(position), Toast.LENGTH_SHORT).show();
//            addFragment(new SingleView(),"Fragment"+fragments.size()+1);
//            notifyDataSetChanged();
//            return fragments.get(position);
//        }
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }

    /**
     * Adds the fragment to the list, also adds the fragment's tab title.
     *
     * @param fragment New instance of the Fragment to be associated with this tab.
     * @param tabTitle A String containing the tab title for this Fragment.
     */
    public void addFragment(Fragment fragment, String tabTitle) {
        fragments.add(fragment);
        tabTitles.add(tabTitle);
    }

}