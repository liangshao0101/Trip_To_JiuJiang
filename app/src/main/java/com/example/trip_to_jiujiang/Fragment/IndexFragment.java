package com.example.trip_to_jiujiang.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import androidx.fragment.app.Fragment;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.example.trip_to_jiujiang.R;
import java.util.ArrayList;

public class IndexFragment extends Fragment {
    ConvenientBanner convenientBanner;
    SearchView searchView;
    private ArrayList<Integer> localImages = new ArrayList<Integer>();
    private int[] images = {R.drawable.eight, R.drawable.first, R.drawable.five, R.drawable.four, R.drawable.second};

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.index_fragment, container, false);
        searchView = root.findViewById(R.id.searchciew);
        userBanner(root);
        return root;
    }

    void userBanner(View view) {
        //获取轮播图控件
        convenientBanner = view.findViewById(R.id.convenientBanner);
        //加载图片
        loadTImageDatas();
        //呈现图片
        convenientBanner.setPages(
                new CBViewHolderCreator() {
                    @Override
                    public LocalImageHolderView createHolder(View itemView) {
                        return new LocalImageHolderView(itemView);
                    }

                    @Override
                    public int getLayoutId() {
                        return R.layout.item_localimage;
                    }
                }, localImages);
    }

    private void loadTImageDatas() {
        //本地图片集合
        for (int position = 0; position < 5; position++)
            localImages.add(images[position]);
    }

    class LocalImageHolderView extends Holder<Integer> {
        private ImageView imageView;

        public LocalImageHolderView(View itemView) {
            super(itemView);
        }

        @Override
        protected void initView(View itemView) {
            imageView = itemView.findViewById(R.id.ivPost);
        }

        @Override
        public void updateUI(Integer data) {
            imageView.setImageResource(data);
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
}
