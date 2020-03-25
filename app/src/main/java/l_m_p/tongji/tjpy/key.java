package l_m_p.tongji.tjpy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class key extends AppCompatActivity {
    TextView dateText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);
        dateText=(TextView)findViewById(R.id.item_date);
        dateText.setText(""+System.currentTimeMillis());
        Button btn=findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(key.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}
