package com.locfai.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private ViewPager viewPager;
    private PagerTitleStrip pagerTitleStrip;
    private List<View> list;//装载界面
    private  List<String> title;//装载标题
    private ViewGroup viewGroup;
    private View view1;
    private View view2;
    private View view3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        pagerTitleStrip=(PagerTitleStrip)findViewById(R.id.titletab);

        view1=View.inflate(this,R.layout.tab1,null);
        view2=View.inflate(this,R.layout.tab2,null);
        view3=View.inflate(this,R.layout.tab3,null);

        list=new ArrayList<View>();//重要

        list.add(view1);
        list.add(view2);
        list.add(view3);
        viewPager.setAdapter(new Myadapter());


    }
    class Myadapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }//是获取当前窗体界面数

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));

        }//如果滑动的界面超出了缓存的范围，就会调用这个方法，将界面销毁

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }// 当要显示的界面可以进行缓存的时候，会调用这个方法进行显示界面的初始化，
        // 我们将要显示的界面加入到ViewGroup中，然后作为返回值返回即可

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view==o;
        }//判定是否同一个界面

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }

}
