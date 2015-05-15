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
    private List<View> list;//װ�ؽ���
    private  List<String> title;//װ�ر���
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

        list=new ArrayList<View>();//��Ҫ

        list.add(view1);
        list.add(view2);
        list.add(view3);
        viewPager.setAdapter(new Myadapter());


    }
    class Myadapter extends PagerAdapter{

        @Override
        public int getCount() {
            return list.size();
        }//�ǻ�ȡ��ǰ���������

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));

        }//��������Ľ��泬���˻���ķ�Χ���ͻ�����������������������

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }// ��Ҫ��ʾ�Ľ�����Խ��л����ʱ�򣬻�����������������ʾ����ĳ�ʼ����
        // ���ǽ�Ҫ��ʾ�Ľ�����뵽ViewGroup�У�Ȼ����Ϊ����ֵ���ؼ���

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view==o;
        }//�ж��Ƿ�ͬһ������

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }

}
