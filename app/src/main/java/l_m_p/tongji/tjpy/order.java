package l_m_p.tongji.tjpy;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;


public class order extends AppCompatActivity {
    TextView datetext;
    MyApp myApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        datetext=(TextView)findViewById(R.id.order_date);
        datetext.setText(""+System.currentTimeMillis());
        myApp=(MyApp)getApplication();
        //切换主页面
        Button btn=findViewById(R.id.button12);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myApp.setIF_RENT(1);
                Intent i=new Intent(order.this,MainActivity.class);
                i.putExtra("ifRent", true);//Boolean类
//                myApp.setIF_RENT(1);
//                IF_RENT=1;
                startActivity(i);
            }
        });
    }
}
