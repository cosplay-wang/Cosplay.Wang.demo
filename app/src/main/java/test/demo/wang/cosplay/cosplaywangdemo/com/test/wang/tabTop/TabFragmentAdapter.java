package test.demo.wang.cosplay.cosplaywangdemo.com.test.wang.tabTop;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by zhiwei.wang on 2016/3/1.
 */
public class TabFragmentAdapter extends PagerAdapter {
    List<View> view_list;
    List<String> title_list;


    public TabFragmentAdapter(List<View> view_list, List<String> title_list) {
        this.view_list = view_list;
        this.title_list = title_list;
    }

    @Override
    public int getCount() {
        return view_list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(view_list.get(position));
        return view_list.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(view_list.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title_list.get(position);
    }
}
