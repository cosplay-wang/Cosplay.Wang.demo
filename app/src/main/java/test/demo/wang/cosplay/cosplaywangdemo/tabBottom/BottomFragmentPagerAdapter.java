package test.demo.wang.cosplay.cosplaywangdemo.tabBottom;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.MotionEvent;

import java.util.List;

/**
 * Created by zhiwei.wang on 2016/3/1.
 */
public class BottomFragmentPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragment_list;
    List<String> title_list;

    public BottomFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragment_list, List<String> title_list) {
        super(fm);
        this.fragment_list = fragment_list;
        this.title_list = title_list;
    }


    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title_list.get(position);
    }
}
