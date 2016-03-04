package test.demo.wang.cosplay.cosplaywangdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.demo.wang.cosplay.cosplaywangdemo.com.test.wang.tabTop.TabFragmentAdapter;

public class MainActivity extends Activity {
    List<String> tablist ;
    List<View> viewlist;
    TabLayout title_layout;
    ViewPager viewpager;
    TabFragmentAdapter view_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initview();
        viewlist = getViewlist(tablist);
        view_adapter = new TabFragmentAdapter(viewlist,tablist);
        viewpager.setAdapter(view_adapter);

        title_layout.setupWithViewPager(viewpager);
        //设置TabLayout的模式
        title_layout.setTabMode(TabLayout.MODE_SCROLLABLE);

        title_layout.setTabGravity(TabLayout.GRAVITY_CENTER);


    }

    private void Initview(){
        title_layout = (TabLayout) findViewById(R.id.tab_FindFragment_title);
        viewpager = (ViewPager) findViewById(R.id.tab_viewpager);
        tablist = new ArrayList<String>();
        tablist.add("TAB_1");
        tablist.add("TAB_2");
        tablist.add("TAB_3");
        tablist.add("TAB_4");
        tablist.add("TAB_5");
        tablist.add("TAB_6");
        tablist.add("TAB_7");

    }
    private List<View> getViewlist( List<String>  tablist){
        List<View> views = new ArrayList<View>();

        for(int i=0;i<tablist.size();i++){
            View single_view = LayoutInflater.from(MainActivity.this).inflate(R.layout.viewpager_item,null);
                TextView tv = (TextView) single_view.findViewById(R.id.item_title);
                tv.setText(tablist.get(i));

            views.add(single_view);
        }
        return  views;
    }
}
