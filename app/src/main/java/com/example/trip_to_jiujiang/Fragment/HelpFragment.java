package com.example.trip_to_jiujiang.Fragment;


import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.*;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MyLocationStyle;


import com.example.trip_to_jiujiang.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelpFragment extends Fragment{
    private GridView gridView;
    private TextView textView_location;
    private MyAdapter myAdapter;
    private MapView mapView = null;
    private AMap aMap;
    //声明mlocationClient对象
    public AMapLocationClient mLocationClient;
    //声明mLocationOption对象
    public AMapLocationClientOption mLocationOption = null;
    //声明定位回调监听器
    public AMapLocationListener mLocationListener = new MyAMapLocationListener();
    private int [] images ={R.drawable.help,R.drawable.policeman,R.drawable.consult,R.drawable.tousu};
    private String [] number = {"120","110","0792-5540073","12345"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Log.i("onCreateView()方法","onCreateView()");
        View view = inflater.inflate(R.layout.help_fragment,container,false);
        myAdapter = new MyAdapter();
        gridView = view.findViewById(R.id.help_gridview);
        gridView.setAdapter(myAdapter);
        //获取地图控件引用
        mapView = view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        //初始化AMap
        if(aMap == null){
            aMap = mapView.getMap();
        }
        /*********定位蓝点的显示***********/
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        // aMap.getUiSettings().setMyLocationButtonEnabled(true);//设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_MAP_ROTATE);//连续定位、且将视角移动到地图中心点，地图依照设备方向旋转，定位点会跟随设备移动。（1秒1次定位）
          /**************定位实现**************/
//        mLocationClient = new AMapLocationClient(getContext());
//        mLocationOption = new AMapLocationClientOption();
//        //设置定位监听
//        mLocationClient.setLocationListener(this);
////设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
//        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
////设置定位间隔,单位毫秒,默认为2000ms
//        mLocationOption.setInterval(2000);
////设置定位参数
//        mLocationClient.setLocationOption(mLocationOption);
//        mLocationClient.startLocation();
        init();
/************定位实现**************/
        return view;
    }//onCreateView()

    private void init() {
        //初始化定位
        mLocationClient = new AMapLocationClient(getContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(false);

        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);
        //设置是否返回地址信息（默认返回地址信息）
        mLocationOption.setNeedAddress(true);
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //关闭缓存机制
        mLocationOption.setLocationCacheEnable(false);
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        //启动定位
        mLocationClient.startLocation();

    }

    private class MyAMapLocationListener implements AMapLocationListener {

        @Override
        public void onLocationChanged(AMapLocation aMapLocation) {
            if (aMapLocation != null) {
                if (aMapLocation.getErrorCode() == 0) {
                    Log.e("位置：", aMapLocation.getAddress());
                } else {
                    //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                    Log.e("AmapError", "location Error, ErrCode:"
                            + aMapLocation.getErrorCode() + ", errInfo:"
                            + aMapLocation.getErrorInfo());
                }
            }
        }
    }
//    @Override
//    public void onLocationChanged(AMapLocation amapLocation) {
//        if (amapLocation != null) {
//            if (amapLocation.getErrorCode() == 0) {
//                //定位成功回调信息，设置相关消息
//                amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                amapLocation.getLatitude();//获取纬度
//                amapLocation.getLongitude();//获取经度
//                amapLocation.getAccuracy();//获取精度信息
//                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                Date date = new Date(amapLocation.getTime());
//                df.format(date);//定位时间
//            } else {
//                //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
//                Log.e("AmapError","location Error, ErrCode:"
//                        + amapLocation.getErrorCode() + ", errInfo:"
//                        + amapLocation.getErrorInfo());
//                Log.i("errorDetail:",amapLocation.getLocationDetail());
//            }
//        }
//
//    }
    /**************实现高德定位方法******************/
//    @Override
//    public void activate(OnLocationChangedListener onLocationChangedListener) {
//        Log.d("zh", "activate进来了");
//        mListener = onLocationChangedListener;
//        if (mLocationClient == null) {
//            mLocationClient = new AMapLocationClient(getActivity());
//            mLocationOption = new AMapLocationClientOption();
//            //设置定位监听
//            mLocationClient.setLocationListener(this);
//            //设置为高精度定位模式
//            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
//            //设置定位参数
//            mLocationOption.setOnceLocation(true);//只定位一次
//            mLocationOption.setHttpTimeOut(2000);
//            mLocationClient.setLocationOption(mLocationOption);
//            // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
//            // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
//            // 在定位结束后，在合适的生命周期调用onDestroy()方法
//            // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
//            mLocationClient.startLocation();//开始定位
//        }
//
//    }
//
//    @Override
//    public void deactivate() {
//        Log.d("zh", "deactivate我是什么时候进来的");
//        mListener = null;
//        if (mLocationClient != null) {
//            mLocationClient.stopLocation();
//            mLocationClient.onDestroy();
//        }
//        mLocationClient = null;
//
//    }
//    @Override
//    public void onLocationChanged(AMapLocation aMapLocation) {
//        Log.d("zh", "onLocationChanged进来了");
//        Log.d("zh", aMapLocation + "");
//        Log.d("zh", aMapLocation.getErrorCode() + "");
//        if (aMapLocation.getErrorCode() == 0) {
//            //可在其中解析amapLocation获取相应内容。
//            Log.i("地址", aMapLocation.getCity());
//        } else {
//            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
//            Log.e("AmapError", "location Error, ErrCode:"
//                    + aMapLocation.getErrorCode() + ", errInfo:"
//                    + aMapLocation.getErrorInfo());
//        }
//
//    }
    /**
     * 必须重写以下方法
     */
    @Override
    public void onResume(){
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }




    /**********GridView的适配器*************/
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(getActivity(),R.layout.help_gridview_item,null);
            TextView textView = view.findViewById(R.id.gridview_tv);
            ImageView imageView = view.findViewById(R.id.gridview_icon);
            textView.setText(number[position]);
            imageView.setImageResource(images[position]);
            return view;
        }
    }

}