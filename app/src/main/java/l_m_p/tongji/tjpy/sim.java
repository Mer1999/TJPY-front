package l_m_p.tongji.tjpy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import android.graphics.Bitmap;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import static org.opencv.imgproc.Imgproc.INTER_CUBIC;
import static org.opencv.imgproc.Imgproc.cvtColor;
import static org.opencv.imgproc.Imgproc.resize;

public class sim extends AppCompatActivity {

    private ImageView photo1;
    private ImageView photo2;
    private Bitmap bm1;
    private Bitmap bm2;
    /**
     * 用于保存拍照图片的uri
     */
    private Uri mCameraUri;
    /**
     * 用于保存图片的文件路径，Android 10以下使用图片路径访问图片
     */
    private String mCameraImagePath;
    /**
     *  是否是Android 10以上手机
     */
    private boolean isAndroidQ = Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q;
    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            // TODO Auto-generated method stub
            switch (status){
                case BaseLoaderCallback.SUCCESS:
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "成功加载！", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    break;
                default:
                    super.onManagerConnected(status);
                    Toast toast1 = Toast.makeText(getApplicationContext(),
                            "加载失败！", Toast.LENGTH_LONG);
                    toast1.setGravity(Gravity.CENTER, 0, 0);
                    toast1.show();
                    break;
            }

        }
    };
    @Override
    public void onResume()
    {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim);

        //下一步键--切换到订单结束页面
        Button btn=findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(sim.this,returnback.class);
                startActivity(i);
            }
        });

        Intent intent=getIntent();
        String imgUri = intent.getStringExtra("imageUri");
//        Toast.makeText(SimActivity.this,imgUri,Toast.LENGTH_SHORT).show();
        photo1=(ImageView)findViewById(R.id.photo_1);
        photo2=(ImageView)findViewById(R.id.photo_2);
        final ImageView photo3=(ImageView)findViewById(R.id.photo_3);
        final ImageView photo4=(ImageView)findViewById(R.id.photo_4);
        final Button sim=(Button)findViewById(R.id.cal);
        sim.setVisibility(View.INVISIBLE);
        if (isAndroidQ) {
            // Android 10 使用图片uri加载
            mCameraUri = Uri.parse((String)imgUri);
//            photo2.setImageURI(mCameraUri);
        } else {
            // 使用图片路径加载
            mCameraImagePath=imgUri;
            photo2.setImageBitmap(BitmapFactory.decodeFile(mCameraImagePath));
        }
        String url = "http://tjlzt98.cn/basketball.png";
//        photo1.setDrawingCacheEnabled(true);
//        photo2.setDrawingCacheEnabled(true);
//        Glide.with(this).load(url).into(photo1);
        Glide.with(getApplicationContext()).load(url).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }
            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                Bitmap bm1 =((BitmapDrawable) ((ImageView) photo1).getDrawable()).getBitmap();
                sim.setVisibility(View.VISIBLE);
                return false;
            }
        }).into(photo1);
        Glide.with(getApplicationContext()).load(mCameraUri).listener(new RequestListener<Drawable>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                return false;
            }
            @Override
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                return false;
            }
        }).into(photo2);
//        Glide.with(getApplicationContext()).load(mCameraUri).listener(new RequestListener<Drawable>() {
//            @Override
//            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                return false;
//            }
//            @Override
//            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//
//                return false;
//            }
//        }).into(photo3);
        sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                photo4.setImageBitmap(bm2);
                bm1 = ((BitmapDrawable) photo1.getDrawable()).getBitmap();
                bm2 = ((BitmapDrawable) photo2.getDrawable()).getBitmap();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        HashCompare(bm1,bm2);
                    }
                }, 2000);//3秒后执行Runnable中的run方法

            }
        });


//        photo1.setDrawingCacheEnabled(true);
//        Bitmap bitmap = Bitmap.createBitmap(photo1.getDrawingCache());
//        photo1.setDrawingCacheEnabled(false);
//        photo3.setImageBitmap(bitmap);


//        View view = SimActivity.getWindow().getDecorView();
//        view.setDrawingCacheEnabled(true);
//        view.buildDrawingCache();
//        Bitmap bm1 = Bitmap.createBitmap(view.getDrawingCache());
//        photo3.setImageBitmap(bm1);
//        Glide.with(SimActivity.this).load(url).into(photo3);
//        Bitmap bm1 = photo1.getDrawingCache();
//        Bitmap bm2 = photo2.getDrawingCache();
//        photo3.setImageBitmap(bm1);
//        photo4.setImageBitmap(bm2);
////        Bitmap bm1 = ((BitmapDrawable)photo1.getDrawable()).getBitmap();
//        Bitmap bm2 = ((BitmapDrawable)photo2.getDrawable()).getBitmap();
//        HashCompare(bm1,bm2);
    }



    /**
     * pHash 算法
     * @param Bp1 原图
     * @param Bp2 拍照
     */
    private void HashCompare(Bitmap Bp1, Bitmap Bp2) {
        //数据定义导入部分
        Mat src1 = new Mat();
        Mat dst1 = new Mat();
        Mat src2 = new Mat();
        Mat dst2 = new Mat();
        //读取位图到MAT
        Utils.bitmapToMat(Bp1, src1);
        Utils.bitmapToMat(Bp2, src2);
        //变ARGB变灰度图，四通道变一通道
        cvtColor(src1, dst1, Imgproc.COLOR_BGR2GRAY);
        cvtColor(src2, dst2, Imgproc.COLOR_BGR2GRAY);
        //把灰度图图缩成8*8
        resize(dst1, dst1,new Size(8,8) , 0, 0,  INTER_CUBIC);
        resize(dst2, dst2,new Size(8,8) , 0, 0,  INTER_CUBIC);

        //核心算法部分
        //这里变成二维数组才可以用Mat.get(row,cul)去获取，二维是因为每个像素点里面可能有很多属性（ARGB）
        // 变成灰度之后就只有一个G了，这个G是Gray，前面那个G是Green。
        double[][] data1 = new double[64][1];
        double[][] data2 = new double[64][1];
        //iAvg 记录平均像素灰度值，arr记录像素灰度值，data是个跳板。
        int iAvg1 = 0, iAvg2 = 0;
        double[] arr1 = new double[64];
        double[] arr2 = new double[64];
        //get灰度给data，用data给arr充值，算平均灰度值iAvg。
        for (int i = 0; i < 8; i++)
        {
            int tmp = i * 8;
            for (int j = 0; j < 8; j++)
            {
                int tmp1 = tmp + j;
                data1[tmp1] = dst1.get(i,j);
                data2[tmp1] = dst2.get(i,j);
                arr1[tmp1] = data1[tmp1][0];
                arr2[tmp1] = data2[tmp1][0];
                iAvg1 += arr1[tmp1];
                iAvg2 += arr2[tmp1];
            }
        }
        iAvg1 /= 64;
        iAvg2 /= 64;
        //比对每个像素灰度值和平均灰度值大小
        for (int i = 0; i < 64; i++)
        {
            arr1[i] = (arr1[i] >= iAvg1) ? 1 : 0;
            arr2[i] = (arr2[i] >= iAvg2) ? 1 : 0;
        }
        //计算差异值
        int iDiffNum = 0;
        for (int i = 0; i < 64; i++)
            if (arr1[i] != arr2[i])
                ++iDiffNum;
        //输出什么看个人喜好
        double Diff=1-iDiffNum/64.0;
        Toast.makeText(sim.this, "Similarity is "+Diff, Toast.LENGTH_LONG).show();
    }

}
