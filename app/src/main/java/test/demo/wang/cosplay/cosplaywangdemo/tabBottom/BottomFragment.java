package test.demo.wang.cosplay.cosplaywangdemo.tabBottom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.demo.wang.cosplay.cosplaywangdemo.R;
import test.demo.wang.cosplay.cosplaywangdemo.com.test.wang.tabTop.TabFragmentAdapter;

/**
 * Created by zhiwei.wang on 2016/3/1.
 */
public class BottomFragment extends Fragment {

    List<String> tablist;
    List<View> viewlist;
    TabLayout title_layout;
    ViewPager viewpager;
    TabFragmentAdapter view_adapter;

    private List<View> getViewlist(List<String> tab_list) {
        List<View> views = new ArrayList<View>();

        for (int i = 0; i < tab_list.size(); i++) {
            View single_view = LayoutInflater.from(getActivity().getApplicationContext()).inflate(R.layout.viewpager_item, null);
            TextView tv = (TextView) single_view.findViewById(R.id.item_title);
            tv.setText(tab_list.get(i));

            views.add(single_view);
        }
        return views;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_main, container, false);
        title_layout = (TabLayout) mView.findViewById(R.id.tab_FindFragment_title);
        viewpager = (ViewPager) mView.findViewById(R.id.tab_viewpager);
        tablist = new ArrayList<String>();
        tablist.add("TAB_1");
        tablist.add("TAB_2");
        tablist.add("TAB_3");
        tablist.add("TAB_4");
        tablist.add("TAB_5");

        viewlist = getViewlist(tablist);
        view_adapter = new TabFragmentAdapter(viewlist, tablist);
        viewpager.setAdapter(view_adapter);
        title_layout.setupWithViewPager(viewpager);
        //设置TabLayout的模式
        title_layout.setTabMode(TabLayout.MODE_FIXED);

        title_layout.setTabGravity(TabLayout.GRAVITY_FILL);

        return mView;


    }

}
