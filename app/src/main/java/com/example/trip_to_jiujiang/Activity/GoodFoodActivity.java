package com.example.trip_to_jiujiang.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.trip_to_jiujiang.DataBase.GoodFoodAdapter;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.model.GoodFood;

import java.util.ArrayList;
import java.util.List;

//吕明骏
public class GoodFoodActivity extends Activity {

    private List<GoodFood> foodList=new ArrayList<>();
//    private String[] data={"Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple",
//            "Strawberry","Cherry","Mango","Apple","Banana","Orange","Watermelon","Pear","Grape"
//            ,"Pineapple","Strawberry","Cherry","Mango"};
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.goodfood_layout);
        initGoodFood();
        GoodFoodAdapter adapter=new GoodFoodAdapter(this,R.layout.goodfood_item,foodList);
        ImageView imageView=findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent();
                x.setClass(GoodFoodActivity.this,IndexActivity.class);
                startActivity(x);
            }
        });
        ListView listview=(ListView)findViewById(R.id.list_view);
        listview.setAdapter(adapter);
    }

    private void initGoodFood(){
        GoodFood apple=new GoodFood("老街旧巷\n"+"地址：南昌县紫阳大道1216号新力高新都荟广场3楼\n" +
                "电话：17770864363\n" +
                "营业时间：周一至周日 10:00-22:00","https://img.meituan.net/msmerchant/93160e6024f56e21af2a53e8b51aeeaf43714.jpg@220w_125h_1e_1c");
        foodList.add(apple);
        GoodFood orange=new GoodFood("一把手南派烤小串\n"+"地址：新建区长棱镇解放路95号3楼（四平电器旁）\n" +
                "电话：0791-83779398\n" +
                "营业时间：周一至周日 09:30-23:00","https://img.meituan.net/600.600/msmerchant/734edaee45ea55232f21e9cc41821b0647621.jpg@220w_125h_1e_1c");
        foodList.add(orange);
        GoodFood banana=new GoodFood("川府烤全羊\n"+"地址：青山湖区上海路699号\n" +
                "电话：18970932783/13755628226\n" +
                "营业时间：周一至周日 17:30-02:30","https://img.meituan.net/msmerchant/510cc0995e4faa03d780fcf537ac987c124091.jpg@380w_214h_1e_1c");
        foodList.add(banana);
        GoodFood waterlenmo=new GoodFood("牛太郎时尚自助烧烤\n"+"地址：青山湖区南昌市青山湖区北京东路1588号世纪风情二号地块商铺一楼\n" +
                "电话：0791-88335766/82285188\n" +
                "营业时间：周一至周日 09:00-21:00","https://img.meituan.net/msmerchant/5febdb0b728d591de020af8f87f078301158598.png@380w_214h_1e_1c");
        foodList.add(waterlenmo);
        GoodFood pear=new GoodFood( "军山湖清水大闸蟹（南京东路店）\n"+
                "地址：青山湖区南京东路湖滨花苑2号军山湖大闸蟹店\n" +
                "电话：18942225285\n" +
                "营业时间：周一至周日 08:00-18:00","https://img.meituan.net/msmerchant/0c5d31611de00d9a0de353112a2f2690119262.jpg@220w_125h_1e_1c");
        foodList.add(pear);
        GoodFood grape=new GoodFood("哈姆西克披萨（枫林店）\n"+"地址：青山湖区经济技术开发区紫荆路步行街东4、5栋01-12室\n" +
                "电话：18079135608\n" +
                "营业时间：周一至周日 10:00-22:30","https://img.meituan.net/msmerchant/8f8ad1648b9cddd1906cb0de0619e40664772.jpg@380w_214h_1e_1c");
        foodList.add(grape);
        GoodFood pineapple=new GoodFood("盛世经典牛排自助餐厅（南昌奥体天虹店）\n"+"地址：南昌县紫阳大道988号奥体天虹5层5011\n" +

                "电话：0791-87368086\n" +
                "营业时间：周一至周日 10:30-21:00","https://img.meituan.net/msmerchant/66c5bdd5895587e7fe7f8c964cd92c2d205278.jpg@380w_214h_1e_1c");
        foodList.add(pineapple);
        GoodFood strawberry=new GoodFood("灰大狼爱着羊\n"+"地址：青山湖区京东大道和京安路口世纪风情三期\n" +

                "电话：0791-88561173/13694882284\n" +
                "营业时间：周一至周日 10:00-14:00 16:00-23:00","https://img.meituan.net/msmerchant/307985d8c1f44f39603c7152ff09ee60171220.jpg@220w_125h_1e_1c");
        foodList.add(strawberry);
        GoodFood cherry=new GoodFood("紫菜包饭寿司（南京西路店）\n"+"地址：东湖区南京西路13号（出租总公司斜对面）\n" +

                "电话：13064107436\n" +
                "营业时间：周一至周日 09:00-21:00","https://img.meituan.net/msmerchant/43d4c1bba61c5d420bfda5a003652e3248318.jpg@380w_214h_1e_1c");
        foodList.add(cherry);
        GoodFood mango=new GoodFood("玉林串串香（经开乐盈广场店）\n"+"地址：青山湖区桂苑大道经开IM乐盈广场1层\n" +

                "电话：18685320392\n" +
                "营业时间：周一至周日 10:00-23:00","https://p0.meituan.net/bbia/a912aa59ac3d2a884b63af4da88ac0e8179783.jpg@380w_214h_1e_1c");
        foodList.add(mango);
    }
}
