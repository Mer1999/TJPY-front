package l_m_p.tongji.tjpy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //切换登录-主页面
        Button btn=findViewById(R.id.button7);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(login.this,MainActivity.class);
                startActivity(i);
            }
        });

        //切换注册-注册成功页面
        Button btn2=findViewById(R.id.button6);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(login.this,signinsuccess.class);
                startActivity(i);
            }
        });
    }
}
