package com.vishnu.memoryclean;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {
AlphaAnimation alphaAnimation = null;
 ActivityManager activityManager;
    PackageManager packageManager;
    List<ActivityManager.RunningAppProcessInfo> ll;
    List<PackageInfo>l;
    TextView totalmemory ,availablememory;
    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView v =  (ImageView) findViewById(R.id.imageView);
packageManager = getPackageManager();
activityManager = (ActivityManager)getSystemService(ACTIVITY_SERVICE);
        ll=  activityManager.getRunningAppProcesses();
        final ScaleAnimation scaleAnimation  =  new ScaleAnimation(1f,0.5f,1f,0.5f,v.getX()+200f,v.getY()+200f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setInterpolator(new BounceInterpolator());
        scaleAnimation.setRepeatCount(5);
        scaleAnimation.setFillAfter(true);
l = packageManager.getInstalledPackages( PackageManager.GET_UNINSTALLED_PACKAGES);
        Intent i = new Intent(this,MainActivity2Activity.class);
        Myclass my = new Myclass(2,"tert", Arrays.asList("hello1","hello2"));
        Serial ss = new Serial(1,"uyit");
        System.out.println(my.hashCode());
        i.putExtra("parc",my);
        i.putExtra("serial",ss);
        startActivity(i);

        activityManager.getMemoryInfo(memoryInfo);
totalmemory = (TextView)findViewById(R.id.textView);
        availablememory = (TextView) findViewById(R.id.textView2);
        totalmemory.setText("Total memory"+memoryInfo.totalMem);
        availablememory.setText("Available memory"+ memoryInfo.availMem);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                activityManager.getMemoryInfo(memoryInfo);
                totalmemory.setText("Total memory" + memoryInfo.totalMem);
                availablememory.setText("Available memory" + memoryInfo.availMem);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.setImageDrawable(getResources().getDrawable(R.drawable.circle));
         alphaAnimation = new AlphaAnimation(1,0);
        alphaAnimation.setDuration(1500);
        alphaAnimation.setRepeatMode(AlphaAnimation.REVERSE);
        alphaAnimation.setRepeatCount(7);
       // alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

        // v.startAnimation(alphaAnimation);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            System.out.println("gdffh");

            view.startAnimation(scaleAnimation);
                for(PackageInfo info : l){
                    activityManager.killBackgroundProcesses(info.packageName);
                    System.out.println(info.packageName + " "+ll.size()+" "+ l.size());

                }
                //view.clearAnimation();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
