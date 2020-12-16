package com.example.trip_to_jiujiang.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.trip_to_jiujiang.R;
import com.example.trip_to_jiujiang.Utils.MyImageButton;
import com.squareup.picasso.Picasso;

public class XunYangGongLieActivity extends AppCompatActivity {
    String [] message = new String[]{"梦里寻他千百度，醉美庐山真面目。","遍种西方莲，哪一朵是你？",
            "“百慕大”之名擦亮了老爷庙","不幸刺纹双颊，那堪配在江州。他年若得抱冤仇，血染浔阳江口。",
            "八百里鄱阳风光美，一千年湖口最风情。"};
    String[] imageAddress = new String[]{"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608043889073&di=44f54102d6503dffab638d9db87e6116&imgtype=0&src=http%3A%2F%2Fn1-q.mafengwo.net%2Fs16%2FM00%2F2D%2F2E%2FCoUBUl8MH7KADsKsAAb81IOTUjA48.jpeg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608047643822&di=f10a7b6cd3ab52a9b0128cba7777683e&imgtype=0&src=http%3A%2F%2Fimage.m.95hq.cn%2FUploads%2F20180622%2F152966392468378.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608116294517&di=d7d20a7340bd46cdfc49e20e4d652d41&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fq_mini%2Cc_zoom%2Cw_640%2Fupload%2F20161229%2F0e7c8eb42f254f6081b409920f26f011_th.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608047824367&di=1ce70d035f66e20b1d49054ffaf52604&imgtype=0&src=http%3A%2F%2Fimages.tuniucdn.com%2Fimages%2F2011-08-15%2F2%2F2iLLAocGGvYMMB3d.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1608047917871&di=789ad60110ca5817aa86260c1ff969be&imgtype=0&src=http%3A%2F%2Fpic4.40017.cn%2Fscenery%2Fdestination%2F2016%2F11%2F14%2F15%2F5LrMOJ.jpg"};
    private ListView listView;
    private MyAdapter myAdapter;
    private ImageView imageView_back;
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.xunyanggonglieactivity_layout);
        listView = findViewById(R.id.listview_xunyanggonglie);
        imageView_back = findViewById(R.id.xunyangonglie_backArrow);
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XunYangGongLieActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });//imageView_back
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              switch (position){
                  case 0:{
                      Intent intent = new Intent(XunYangGongLieActivity.this,GongLieLuShanActivity.class);
                      startActivity(intent);

                  }break;
                  case 1:{
                      Intent intent = new Intent(XunYangGongLieActivity.this,GongLieDongLinSiActivity.class);
                      startActivity(intent);
                  }break;
                  case 2:{
                      Intent intent = new Intent(XunYangGongLieActivity.this,GongLieBaiMuDaActivity.class);
                      startActivity(intent);
                  }break;
                  case 3:{
                      Intent intent = new Intent(XunYangGongLieActivity.this,GongLieXunYangLouActivity.class);
                      startActivity(intent);
                  }break;
                  case 4:{
                      Intent intent = new Intent(XunYangGongLieActivity.this,GongLieShiZhongShanActivity.class);
                      startActivity(intent);
                  }break;
              }//switch
            }
        });//listView事件监听
    }
    /***************添加设配器************/
    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imageAddress.length;
        }

        @Override
        public Object getItem(int position) {
            return imageAddress[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(XunYangGongLieActivity.this,R.layout.xunyanggonglie_item_layout,null);
            TextView textView = view.findViewById(R.id.textview_xunyangonglie);
            textView.setText(message[position]);
            ImageView myImageButton = view.findViewById(R.id.imagebutton_item_xunyangonglie);
            Picasso.with(XunYangGongLieActivity.this).load(imageAddress[position]).resize(1000,500).into(myImageButton);
            return view;
        }
    }//MyAdapter
}
