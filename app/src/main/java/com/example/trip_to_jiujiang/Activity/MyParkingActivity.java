/***
 * author:Liam
 * **/
package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.Hotel;
import com.example.trip_to_jiujiang.model.Parking;

import java.util.Date;
import java.util.List;

public class MyParkingActivity extends AppCompatActivity {
    private Button button;
    private TextView textView_scorllview;
    private ImageView imageView_scorllview;
    String str = "";

    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.myparking_layout);
        textView_scorllview = findViewById(R.id.textview_scorllview4);
        imageView_scorllview = findViewById(R.id.parking_backArrow);
        FindAll();
        imageView_scorllview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyParkingActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });//imageView_scorllview

//        button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                InsertSpecialty();
//            }
//        });
    }
    private void FindAll() {
        String sql = "select * from Parking";   //查询Specialty语句
        BmobQuery<Parking> parkingBmobQuery = new BmobQuery<Parking>();
        parkingBmobQuery.setSQL(sql);
        parkingBmobQuery.doSQLQuery(new SQLQueryListener<Parking>() {
            @Override
            public void done(BmobQueryResult<Parking> bmobQueryResult, BmobException e) {
                if (e == null) {
                    List<Parking> list = (List<Parking>) bmobQueryResult.getResults();
                    if (list != null && list.size() >= 0) {
                        // Log.i("list",list.toString());
                        for (int i = 0; i < list.size(); i++) {

                            str += list.get(i).getParkingId() + "  " + list.get(i).getCarNumber() + "  " + list.get(i).getParkingArea() +
                                    "  " + list.get(i).getParkingStartTime() + "  " + list.get(i).getParkingPrice() + "  " + list.get(i).getParkingDate() +
                                    "  " + list.get(i).getParkingTime() + "  " + list.get(i).getPuserNumber() + "\n" + "\n";
                        }
                        textView_scorllview.setText(str);
                    } else {
                        Toast.makeText(MyParkingActivity.this, "查询失败！！！", Toast.LENGTH_SHORT).show();
                    }//else
                }
            }
        });
    }



//        private void InsertSpecialty(){
//            Parking parking = new Parking();
//        parking.setParkingId("36974125");
//        parking.setCarNumber("赣G.6KH9P");
//        parking.setParkingArea("万达游乐园停车场");
//        parking.setParkingStartTime(new Date());
//        parking.setParkingTime(360);
//       parking.setParkingDate(new Date());
//       parking.setParkingPrice(25);
//       parking.setPuserNumber("123");
//        parking.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId, BmobException e) {
//                if(e==null){
//                    Toast.makeText(MyParkingActivity.this,"创建数据成功",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MyParkingActivity.this,"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }//InsertSpecialty
}
