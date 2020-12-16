/**
 * author:Liam
 **/
package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.example.trip_to_jiujiang.model.Specialty;
import com.example.trip_to_jiujiang.model.Tickets;

import java.util.Date;
import java.util.List;

public class MyTicketsActivity extends AppCompatActivity {
    // private Button button;
    private TextView textView_scorllview;
    private ImageView imageView_scollview;
    String str = "";

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mytickets_layout);
        textView_scorllview = findViewById(R.id.textview_scorllview2);
        imageView_scollview = findViewById(R.id.tickets_backArrow);
        FindAll();
        imageView_scollview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyTicketsActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });//imageView_scollview

        //button = findViewById(R.id.button);

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                InsertSpecialty();
//            }
//        });
    }

    private void FindAll() {
        String sql = "select * from Tickets";   //查询Specialty语句
        BmobQuery<Tickets> ticketsBmobQuery = new BmobQuery<Tickets>();
        ticketsBmobQuery.setSQL(sql);
        ticketsBmobQuery.doSQLQuery(new SQLQueryListener<Tickets>() {
            @Override
            public void done(BmobQueryResult<Tickets> bmobQueryResult, BmobException e) {
                if (e == null) {
                    List<Tickets> list = (List<Tickets>) bmobQueryResult.getResults();
                    if (list != null && list.size() >= 0) {
                        // Log.i("list",list.toString());
                        for (int i = 0; i < list.size(); i++) {

                            str += list.get(i).getTicketsId() + "  " + list.get(i).getTicketsArea() + "  " + list.get(i).getTicketsSort() +
                                    "  " + list.get(i).getTuserNumber() + "  " + list.get(i).getTicketsPrice() + "  " + list.get(i).getTiPriceDiscount() +
                                    "  " + list.get(i).getTuserNumber() + "  " + list.get(i).getTicketsDate() + "\n" + "\n";
                        }
                        textView_scorllview.setText(str);
                    } else {
                        Toast.makeText(MyTicketsActivity.this, "查询失败！！！", Toast.LENGTH_SHORT).show();
                    }//else
                }
            }
        });
    }
//        private void InsertSpecialty(){
//            Tickets tickets = new Tickets();
//        tickets.setTicketsId("68554125");
//        tickets.setTicketsArea("鄱阳湖风景区");
//        tickets.setTicketsNumber(200);
//        tickets.setTicketsPrice(20);
//        tickets.setTiPriceDiscount(3);
//        tickets.setTicketsSort("4A级景区");
//        tickets.setTicketsDate(new Date());
//        tickets.setTuserNumber("123");
//        tickets.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId, BmobException e) {
//                if(e==null){
//                    Toast.makeText(MyTicketsActivity.this,"创建数据成功",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MyTicketsActivity.this,"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }//InsertSpecialty
}
