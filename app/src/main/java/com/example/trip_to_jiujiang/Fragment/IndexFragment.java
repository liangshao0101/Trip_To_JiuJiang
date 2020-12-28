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
import com.example.trip_to_jiujiang.Activity.*;
import com.example.trip_to_jiujiang.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IndexFragment extends Fragment {
    private IndexViewModel mViewModel;
    //  private ListView listView;
    private ImageView imageView_index2, imageView_index3, imageView_index4, imageView_index5, imageView_index6;
    private String[] message = new String[]{"九江庐山风景区", "九江万达游乐园", "湖口石钟山", "九江浔阳楼", "九江茶饼"};
    private String[] image_listview = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608097188144&di=ce82502a2b663d8a60d4407e62d70f35&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fbaike%2Fpic%2Fitem%2F3c6d55fbb2fb431645f4498129a4462308f7d365.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608097232253&di=866eb86449952a00bf266760e743ec51&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20170330%2F36e92dd3523240328e5c126e6d566e4a_th.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608097290336&di=2dda1daf922de4f77456c446e136311a&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20171027%2Fe13a6d3ac225449c96760b03e1fc0339.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608097324142&di=f56abbf95f541141597306808fd20936&imgtype=0&src=http%3A%2F%2Fs3.lvjs.com.cn%2Fuploads%2Fpc%2Fplace2%2F2016-02-18%2F5494b6e8-41ca-4941-939a-b8d6ae119722.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608097373745&di=a4f4cdad0ac598d1e869cf7730c3a4aa&imgtype=0&src=http%3A%2F%2Fp3.pstatp.com%2Flarge%2Fpgc-image%2F1524200979001d8bcd742a5"};

    // private MyAdapter myAdapter;
    public static IndexFragment newInstance() {
        return new IndexFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.index_fragment, null);
        setView();
        // listView.setAdapter(myAdapter);
        Picasso.with(getActivity()).load(image_listview[0]).resize(1100, 500).into(imageView_index2);
        Picasso.with(getActivity()).load(image_listview[1]).resize(1100, 500).into(imageView_index3);
        Picasso.with(getActivity()).load(image_listview[2]).resize(1100, 500).into(imageView_index4);
        Picasso.with(getActivity()).load(image_listview[3]).resize(1100, 500).into(imageView_index5);
        Picasso.with(getActivity()).load(image_listview[4]).resize(1100, 500).into(imageView_index6);
        return mView;
    }

    //轮播图
    private View mView;
    private ViewPager mViewPaper, mViewPaper2;
    private List<ImageView> images, images2;
    private List<View> dots, dots2;
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
    //存放图片地址
    private String[] address2 = new String[]{
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608090588783&di=ae9942743bf2afbb0ceae221c981c93c&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20190212%2Fd0e228ec99b6463ba35d74f6dd871194.jpeg",
            "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=781052816,1692395435&fm=26&gp=0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608090736475&di=65ff77594605e1faad4ee149e414204f&imgtype=0&src=http%3A%2F%2Fimg.picture.lckc.net%2F20170616%2Famsunoh20sn.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608090811460&di=8685e5c603830de03a3a8ed2a964e2c4&imgtype=0&src=http%3A%2F%2Fgss0.baidu.com%2F-4o3dSag_xI4khGko9WTAnF6hhy%2Fzhidao%2Fpic%2Fitem%2F8644ebf81a4c510f9d6529f86b59252dd52aa5ab.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608090864718&di=381166d1b760cb6eb5d466e26f71fa88&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fphotoblog%2F1505%2F02%2Fc1%2F6232264_1430527436325_mthumb.jpg"
    };
    //存放图片的标题
    private String[] titles2 = new String[]{
            "庐山滑雪场欢迎您！",
            "九江特产，茶饼欢迎带回家！",
            "美丽九江甘棠湖！",
            "九江美食，快来尝尝吧",
            "九江五人龙舟比赛，欢迎来看！"
    };
    private TextView title, title2;
    private ViewPagerAdapter adapter;
    private ViewPagerAdapter2 adapter2;
    private ScheduledExecutorService scheduledExecutorService;

    private void setView() {
        // listView = mView.findViewById(R.id.list_index);
        // myAdapter = new MyAdapter();
        imageView_index2 = mView.findViewById(R.id.image_index1);
        imageView_index3 = mView.findViewById(R.id.image_index2);
        imageView_index4 = mView.findViewById(R.id.image_index3);
        imageView_index5 = mView.findViewById(R.id.image_index4);
        imageView_index6 = mView.findViewById(R.id.image_index5);
        mViewPaper = (ViewPager) mView.findViewById(R.id.vp);
        mViewPaper2 = mView.findViewById(R.id.vp2);//第二个轮播图
        //显示的图片
        images = new ArrayList<ImageView>();
        images2 = new ArrayList<ImageView>();
        for (int i = 0; i < address.length; i++) {
            //利用Picasso加载网络图片
            ImageView imageView = new ImageView(getActivity());
            Picasso.with(getActivity()).load(address[i]).resize(350, 150).into(imageView);
            images.add(imageView);
            //利用Picasso加载网络图片2
            ImageView imageView2 = new ImageView(getActivity());
            Picasso.with(getActivity()).load(address2[i]).resize(500, 150).into(imageView2);
            images2.add(imageView2);

        }

        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));
        dots.add(mView.findViewById(R.id.dot_4));
        dots2 = new ArrayList<View>();
        dots2.add(mView.findViewById(R.id.dot_5));
        dots2.add(mView.findViewById(R.id.dot_6));
        dots2.add(mView.findViewById(R.id.dot_7));
        dots2.add(mView.findViewById(R.id.dot_8));
        dots2.add(mView.findViewById(R.id.dot_9));

        title = (TextView) mView.findViewById(R.id.title);
        title.setText(titles[0]);
        title2 = mView.findViewById(R.id.title2);
        title2.setText(titles2[0]);

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
        //第二个
        adapter2 = new ViewPagerAdapter2();
        mViewPaper2.setAdapter(adapter2);
        mViewPaper2.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                title2.setText(titles2[position]);
                dots2.get(position).setBackgroundResource(R.drawable.dot_on);
                dots2.get(oldPosition).setBackgroundResource(R.drawable.dot_off);
                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
            mViewPaper2.setCurrentItem(currentItem);
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

    /******************第一个轮播图结束，第二个轮播图开始****************************/

    /*定义的适配器*/
    public class ViewPagerAdapter2 extends PagerAdapter {
        @Override
        public int getCount() {
            return images2.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
            view.removeView(images2.get(position));
        }

        @Override

        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images2.get(position));
            return images2.get(position);
        }
    }

    /***************************第二个轮播图结束***************************************/
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
        RadioButton rb_tickets_order = (RadioButton) getActivity().findViewById(R.id.tickets);
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
        RadioButton rb_hotel_order = (RadioButton) getActivity().findViewById(R.id.hotel);
        rb_hotel_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "酒店预订", Toast.LENGTH_LONG).show();
                Intent it_hotel_order = new Intent();
                it_hotel_order.setClass(getActivity(), HotelActivity.class);
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
                Toast.makeText(getActivity(), "浔阳攻略", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(getActivity(), XunYangGongLieActivity.class);
                startActivity(intent);
            }
        });//浔阳攻略
        RadioButton rb_interest_xunyang = (RadioButton) getActivity().findViewById(R.id.interest_xunyang);
        rb_interest_xunyang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "趣味浔阳", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), InterestXunYangActivity.class);
                startActivity(intent);
            }
        });//趣味浔阳
    }
/***********************为ListView添加适配器***********************/
//class MyAdapter extends BaseAdapter{
//
//    @Override
//    public int getCount() {
//        return image_listview.length;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return image_listview[position];
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View view = View.inflate(getActivity(),R.layout.index_fragment_item_layout,null);
//        ImageView imageView3 = new ImageView(getActivity());
//        imageView3 =  view.findViewById(R.id.image_index_listview);
//        Picasso.with(getActivity()).load(image_listview[position]).resize(600,300).into(imageView3);
//        TextView textView_message = view.findViewById(R.id.text_left_index);
//        textView_message.setText(message[position]);
//        TextView textView_money = view.findViewById(R.id.text_right_index);
//        textView_money.setText(money[position]);
//         return view;
//    }
//}//MyAdapter
}
