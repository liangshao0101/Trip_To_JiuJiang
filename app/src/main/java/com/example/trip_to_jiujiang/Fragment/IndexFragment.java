package com.example.trip_to_jiujiang.Fragment;

import android.widget.*;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IndexFragment extends Fragment {
    private IndexViewModel mViewModel;
    TransportActivity transportFragment;

    public static IndexFragment newInstance() {
        return new IndexFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.index_fragment, null);
        setView();
        return mView;
    }

    //轮播图
    private View mView;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;

    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片地址
    private String[] address = new String[]{
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606827848351&di=dfaaeda19c7b3297b958e676f04d2d4b&imgtype=0&src=http%3A%2F%2Fdimg02.c-ctrip.com%2Fimages%2Ftg%2F562%2F276%2F223%2F2c0714cf57154d319d9a0c70d76e5042_C_880_350.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606827934663&di=9d8acd9c25b69f2bf37136de5dd56bb0&imgtype=0&src=http%3A%2F%2Fx0.ifengimg.com%2Fcmpp%2Ffck%2F2019_46%2F20d6c9d1ffae925_w1080_h665.jpg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1589716800,3936721967&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606828037194&di=ef2b7b6db72730aed0c79333269173a7&imgtype=0&src=http%3A%2F%2Fyouimg1.c-ctrip.com%2Ftarget%2Ffd%2Ftg%2Fg3%2FM06%2FBE%2F50%2FCggYGVbmTEqABRuIAALxy9TMeXg090.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606828067898&di=521e8f00d5815fc939c0746ec527b435&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171220%2Fa81780ee9a174ba5b9578c505e96b8ae.jpeg"
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "九江美景，感受大自然的美",
            "快来九江吧",
            "美景让人陶醉",
            "九江太美了",
            "九江！九江！九江！"
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;

    private void setView() {
        mViewPaper = (ViewPager) mView.findViewById(R.id.vp);
        //显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < address.length; i++) {
            //利用Picasso加载网络图片
            ImageView imageView = new ImageView(getActivity());
            Picasso.with(getActivity()).load(address[i]).resize(350, 150).into(imageView);
            images.add(imageView);

        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));
        dots.add(mView.findViewById(R.id.dot_4));
        title = (TextView) mView.findViewById(R.id.title);
        title.setText(titles[0]);
        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);
        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.dot_on);
                dots.get(oldPosition).setBackgroundResource(R.drawable.dot_off);
                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    /*定义的适配器*/
    public class ViewPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
            view.removeView(images.get(position));
        }

        @Override

        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }
    }

    /**
     * 利用线程池定时执行动画轮播
     */

    @Override

    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }

    /**
     * 图片轮播任务
     */
    private class ViewPageTask implements Runnable {
        @Override
        public void run() {
            currentItem = (currentItem + 1) % address.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler() {

        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        }

        ;
    };

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }


    //中部菜单栏

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IndexViewModel.class);
        // TODO: Use the ViewModel
        RadioButton rb_transport = (RadioButton) getActivity().findViewById(R.id.transport);
        rb_transport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "交通", Toast.LENGTH_LONG).show();
                Intent it_transport = new Intent(getActivity(), TransportActivity.class);
                startActivity(it_transport);




            }
        });//交通模块
        RadioButton rb_tickets_order = (RadioButton) getActivity().findViewById(R.id.tickets_order);
        rb_tickets_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "门票预订", Toast.LENGTH_LONG).show();
                Intent it_tickets_order = new Intent();
                it_tickets_order.setClass(getActivity(), TicketsOrderActivity.class);
                startActivity(it_tickets_order);
            }
        });//门票预订
        RadioButton rb_jingpingluxian = (RadioButton) getActivity().findViewById(R.id.jingpingluxian);
        rb_jingpingluxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "精品路线", Toast.LENGTH_LONG).show();
                Intent it_jingpingluxia = new Intent();
                it_jingpingluxia.setClass(getActivity(), BeautifulLuXianActivity.class);
                startActivity(it_jingpingluxia);
            }
        });//精品路线
        RadioButton rb_xunyang_food = (RadioButton) getActivity().findViewById(R.id.xunyang_food);
        rb_xunyang_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "浔阳美食", Toast.LENGTH_LONG).show();
                Intent it_xunyang_food = new Intent();
                it_xunyang_food.setClass(getActivity(), GoodFoodActivity.class);
                startActivity(it_xunyang_food);
            }
        });//浔阳美食
        RadioButton rb_hotel_order = (RadioButton) getActivity().findViewById(R.id.hotel_order);
        rb_hotel_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "酒店预订", Toast.LENGTH_LONG).show();
                Intent it_hotel_order = new Intent();
                it_hotel_order.setClass(getActivity(), HotelOrderActivity.class);
                startActivity(it_hotel_order);
            }
        });//酒店预订
        RadioButton rb_play_xunyang = (RadioButton) getActivity().findViewById(R.id.play_xunyang);
        rb_play_xunyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "共游浔阳", Toast.LENGTH_LONG).show();
                Intent it_play_xunyang = new Intent();
                it_play_xunyang.setClass(getActivity(), PlayXuYangActivity.class);
                startActivity(it_play_xunyang);
            }
        });//共游浔阳
        RadioButton rb_xunyanggonglie = (RadioButton) getActivity().findViewById(R.id.xunyanggonglie);
        rb_xunyanggonglie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "浔阳攻略", Toast.LENGTH_LONG).show();
                Intent it_xunyanggonglie = new Intent();
                it_xunyanggonglie.setClass(getActivity(), XuYangGongLieActivity.class);
                startActivity(it_xunyanggonglie);
            }
        });//浔阳攻略
        RadioButton rb_interest_xunyang = (RadioButton) getActivity().findViewById(R.id.interest_xunyang);
        rb_interest_xunyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "趣味浔阳", Toast.LENGTH_LONG).show();
                Intent it_interest_xunyang = new Intent();
                it_interest_xunyang.setClass(getActivity(), InterestXunYangActivity.class);
                startActivity(it_interest_xunyang);
            }
        });//趣味浔阳
    }

}
