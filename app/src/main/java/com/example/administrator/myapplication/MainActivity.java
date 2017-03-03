package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout image;
    private ImageView image1;
    private ImageView image2;
//    private ImageView testimage;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        image = (LinearLayout)findViewById(R.id.image);
//        testimage = (ImageView)findViewById(testimage);
        image1 = (ImageView) findViewById(R.id.image1);
        textView = (TextView) findViewById(R.id.text1);
        image2 = (ImageView)findViewById(R.id.image2);


        // 当你点击分享 做下面操作, 吧需要的图片和 时间 或是moment
        // 都设置到 你写的布局对应的组件中 ,我这个布局只是为了试验截图的 , 你到时候按照图片要求来写布局 , 或是拷贝一个过来
        image1.setImageResource(R.mipmap.ic_launcher);
        textView.setText("this is test");
        image2.setImageResource(R.mipmap.ic_launcher);

        //设置完成后 就可以用下面的方法获取截图了
        //convertViewToBitmap(TestActivity.this , image ,500 , 700)  这是你要分享的图 , 宽高自己设置, 我这边实验写死le
        // 能够获取到图 并且显示到 撑满屏幕的imageview上面 , 图片也是对的

        // 下面要用post 否则刚设置图片和文字 获取不到图片n , 你可以 按照下面来写 , 不用延时10秒 ,我测试用延时10秒来看
//        image.post(new Runnable() {
//            @Override
//            public void run() {
//                testimage.setImageBitmap(convertViewToBitmap(MainActivity.this , image ,500 , 700));
//            }
//        });


        image.postDelayed(new Runnable() {
            @Override
            public void run() {
//                testimage.setImageBitmap(convertViewToBitmap(MainActivity.this , image ,500 , 700));
            }
        } , 10000);




    }



    public Bitmap convertViewToBitmap(Context context, View view, int bitmapWidth, int bitmapHeight) {
        Bitmap bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.GRAY);

        view.draw(canvas);
        return bitmap;
    }

}
