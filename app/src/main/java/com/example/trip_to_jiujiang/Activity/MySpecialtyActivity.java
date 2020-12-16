/**
 *author:Liam
 */
package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;
import cn.bmob.v3.listener.SaveListener;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.Specialty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MySpecialtyActivity extends AppCompatActivity{
    //private Button button;
   private TextView textView_scorllview;
   private ImageView imageView_scollview;
   String str = "";
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.myspecilty_layout);
        Bmob.initialize(this, "75a00f939f327300d5b2e4a6b69d9f58");  //初始化Bmob
       textView_scorllview = findViewById(R.id.textview_scorllview);
       imageView_scollview = findViewById(R.id.specialty_backArrow);

       FindAll();
       imageView_scollview.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MySpecialtyActivity.this,MyOrderActivity.class);
               startActivity(intent);
           }
       });
//        for(int i = 0 ; i < list.size() ; i++){
//            String str = list.get(i).getSpecialtyId()+"  "+list.get(i).getSpecialtyName()+"  "+list.get(i).getSpecialtyPrice()+
//                    "  "+list.get(i).getSpecialtySort()+"  "+list.get(i).getSuserNumber()+"  "+list.get(i).getSpecialtyDate();
//           stringList.add(str);
//        }
//        ArrayAdapter myAdapter = new ArrayAdapter(this,R.layout.specialty_listview_item,stringList);
//        listView.setAdapter(myAdapter);


//        button = findViewById(R.id.button);
//       button.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               InsertSpecialty();
//           }
//       });
    }//onCreate
//    private void InsertSpecialty(){
//        Specialty specialty = new Specialty();
//        specialty.setSpecialtyId("05050505");
//        specialty.setSpecialtyName("东林大佛纪念品");
//        specialty.setSpecialtyPrice(88);
//        specialty.setSpecialtySort("摆件");
//        specialty.setSpecialtyDate(new Date());
//        specialty.setSuserNumber("123");
//
//        specialty.save(new SaveListener<String>() {
//            @Override
//            public void done(String objectId, BmobException e) {
//                if(e==null){
//                    Toast.makeText(MySpecialtyActivity.this,"创建数据成功",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MySpecialtyActivity.this,"失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }//InsertSpecialty
    //查询所有数据
    private void FindAll(){
     String sql = "select * from Specialty";   //查询Specialty语句
        BmobQuery<Specialty> specialtyBmobQuery = new BmobQuery<Specialty>();
        specialtyBmobQuery.setSQL(sql);
        specialtyBmobQuery.doSQLQuery(new SQLQueryListener<Specialty>() {
            @Override
            public void done(BmobQueryResult<Specialty> bmobQueryResult, BmobException e) {
                if (e == null) {
                    List<Specialty> list = (List<Specialty>) bmobQueryResult.getResults();
                    if (list != null && list.size() >= 0) {
                       // Log.i("list",list.toString());
                        for (int i = 0; i < list.size(); i++) {

                                   str += list.get(i).getSpecialtyId() + "  " + list.get(i).getSpecialtyName() + "  " + list.get(i).getSpecialtyPrice() +
                                    "  " + list.get(i).getSpecialtySort() + "  " + list.get(i).getSuserNumber() + "  " + list.get(i).getSpecialtyDate()+"\n"+"\n";
                        }
                        textView_scorllview.setText(str);
                    } else {
                        Toast.makeText(MySpecialtyActivity.this, "查询失败！！！", Toast.LENGTH_SHORT).show();
                    }//else
                }
            }
        });

    }//FindAll
}
