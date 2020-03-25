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
    public int IF_SIGN;
    public int getIF_SIGN(){
        return IF_SIGN;
    }
    public void setIF_SIGN(int if_sign){
        this.IF_SIGN=if_sign;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        setIF_RENT(0);
        setIF_SIGN(0);
    }

}
