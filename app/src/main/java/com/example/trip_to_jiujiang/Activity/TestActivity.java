package com.example.trip_to_jiujiang.Activity;

import android.os.Bundle;

import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.example.trip_to_jiujiang.R;

public class TestActivity extends AppCompatActivity {
    private MapView mapView;
    private AMap aMap;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.test_layout);
        mapView = findViewById(R.id.map);
        init();
        ToggleButton tb = findViewById(R.id.tb);
        tb.setOnCheckedChangeListener((buttonView,isChecked) ->{
            if (isChecked){
                aMap.setMapType(AMap.MAP_TYPE_SATELLITE);
            }
            else{
                aMap.setMapType(AMap.MAP_TYPE_NORMAL);
            }
        });
    }
    private void init(){
        if(aMap == null){
            aMap = mapView.getMap();
        }
    }//init

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

   public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
   }
   public void onDestroy(){
        super.onDestroy();
        mapView.onDestroy();
   }
}
