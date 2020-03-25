package l_m_p.tongji.tjpy;

import android.app.Application;
//Global variable class
public class MyApp extends Application {
    public int IF_RENT;
    public int getIF_RENT(){
        return IF_RENT;
    }
    public void setIF_RENT(int if_rent){
        this.IF_RENT=if_rent;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        setIF_RENT(0);
    }

}
