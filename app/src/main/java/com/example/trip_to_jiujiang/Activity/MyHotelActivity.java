/**
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
import com.example.trip_to_jiujiang.model.Tickets;

import java.util.Date;
import java.util.List;

public class MyHotelActivity extends AppCompatActivity {
    private Button button;
    private TextView textView_scorllview;
    private ImageView imageView_scorllview;
    String str = "";
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.myhotel_layout);
        textView_scorllview = findViewById(R.id.textview_scorllview3);
        imageView_scorllview = findViewById(R.id.hotel_backArrow);
        FindAll();
        imageView_scorllview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyHotelActivity.this, MyOrderActivity.class);
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
        String sql = "select * from Hotel";   //查询Specialty语句
        BmobQuery<Hotel> hotelBmobQuery = new BmobQuery<Hotel>();
        hotelBmobQuery.setSQL(sql);
        hotelBmobQuery.doSQLQuery(new SQLQueryListener<Hotel>() {
            @Override
            public void done(BmobQueryResult<Hotel> bmobQueryResult, BmobException e) {
                if (e == null) {
                    List<Hotel> list = (List<Hotel>) bmobQueryResult.getResults();
                    if (list != null && list.size() >= 0) {
                        // Log.i("list",list.toString());
                        for (int i = 0; i < list.size(); i++) {

                            str += list.get(i).getHotelId() + "  " + list.get(i).getHotelName() + "  " + list.get(i).getHotelSort() +
                                    "  " + list.get(i).getHuserNumber() + "  " + list.get(i).getHotelPrice() + "  " + list.get(i).getHoPriceDiscount() +
                                    "  " + list.get(i).getHuserNumber() + "  " + list.get(i).getHotelDate() + "\n" + "\n";
                        }
                        textView_scorllview.setText(str);
                    } else {
                        Toast.makeText(MyHotelActivity.this, "查询失败！！！", Toast.LENGTH_SHORT).show();
                    }//else
                }
            }
        });
    }



//    private void InsertSpecialty(){
//                Hotel hotel = new Hotel();
//        hotel.setHotelId("98745632");
//        hotel.setHotelName("九江临湖商务酒店");
//        hotel.setHotelNumber(52);
//        hotel.setHotelSort("大床房");
//        hotel.setHotelPrice(356);
//        hotel.setHoPriceDiscount(45);
//        hotel.setHotelDate(new Date());
//        hotel.setHuserNumber("123");
//        hotel.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId, BmobException e) {
//                if(e==null){
//                    Toast.makeText(MyHotelActivity.this,"创建数据成功",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MyHotelActivity.this,"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }//InsertSpecialty
}
