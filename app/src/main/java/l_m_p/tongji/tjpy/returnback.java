package l_m_p.tongji.tjpy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class returnback extends AppCompatActivity {
    TextView dateText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_returnback);
        dateText=(TextView)findViewById(R.id.return_date);
        dateText.setText(""+System.currentTimeMillis());
        //切换信用钱包确认页面
        Button btn=findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(returnback.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
