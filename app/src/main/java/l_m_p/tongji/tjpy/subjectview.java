package l_m_p.tongji.tjpy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class subjectview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjectview);

        //切换返回主页面
        Button btn=findViewById(R.id.button10);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(subjectview.this,MainActivity.class);
                startActivity(i);
            }
        });

        //切换租赁页面
        Button btn2=findViewById(R.id.button9);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(subjectview.this,rent.class);
                startActivity(i);
            }
        });
    }
}
