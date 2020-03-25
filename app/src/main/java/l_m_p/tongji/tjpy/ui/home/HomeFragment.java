package l_m_p.tongji.tjpy.ui.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import org.w3c.dom.Text;

import l_m_p.tongji.tjpy.MainActivity;
import l_m_p.tongji.tjpy.MyApp;
import l_m_p.tongji.tjpy.R;
import l_m_p.tongji.tjpy.publish;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private TextView if_rent;
    MyApp myApp;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    if_rent.setText("已租");
                    if_rent.setTextColor(Color.RED);
                    break;
                default:
                    break;
            }
        }
    };
//    public int IF_RENT;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        myApp=(MyApp)getActivity().getApplication();
        if_rent=(TextView)root.findViewById(R.id.item_if_rent);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message=new Message();
                message.what = myApp.getIF_RENT();
                handler.sendMessage(message);
            }
        }).start();
        return root;
    }

}
