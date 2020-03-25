package l_m_p.tongji.tjpy.ui.mine;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import l_m_p.tongji.tjpy.MyApp;
import l_m_p.tongji.tjpy.R;

public class mineFragment extends Fragment {

    private MineViewModel mViewModel;
    private TextView if_sign;
    private TextView public_key;
    private TextView token;
    MyApp myApp;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    if_sign.setText("Mer.");
                    public_key.setText("7tNjnqN8tngaBnJRsdKXbBcKDV1tVCFgPLPoQGC99X2Cy4kCq5");
                    token.setText("3.0");
                    break;
                default:
                    break;
            }
        }
    };
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(MineViewModel.class);
        View root = inflater.inflate(R.layout.mine_fragment, container, false);
        myApp=(MyApp)getActivity().getApplication();
        if_sign=(TextView)root.findViewById(R.id.user_if_sign);
        public_key=(TextView)root.findViewById(R.id.user_public_key);
        token=(TextView)root.findViewById(R.id.user_token);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message=new Message();
                message.what = myApp.getIF_SIGN();
                handler.sendMessage(message);
            }
        }).start();
        return root;
    }

}
