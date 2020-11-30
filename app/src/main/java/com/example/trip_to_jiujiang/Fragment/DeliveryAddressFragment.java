package com.example.trip_to_jiujiang.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.trip_to_jiujiang.R;

public class DeliveryAddressFragment extends Fragment {
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view;
        view = inflater.inflate(R.layout.deliveryaddress_fragment,container,false);
        return view;
    }
}
