package l_m_p.tongji.tjpy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import l_m_p.tongji.tjpy.MyApp;
public class signinsuccess extends AppCompatActivity {
    private TextView datetext2;
    MyApp myApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinsuccess);
        //切换注册成功-主页面
        Button btn=findViewById(R.id.toMine);
        myApp=(MyApp)getApplication();
        datetext2=(TextView)findViewById(R.id.sign_date);
        datetext2.setText(""+System.currentTimeMillis());
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myApp.setIF_SIGN(1);
                Intent i=new Intent(signinsuccess.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
