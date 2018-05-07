package com.myapplication;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ShortcutManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("ddd","不错");
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N_MR1){
                manager=getSystemService(ShortcutManager.class);
                getMangerInfo();
        }
    }
    @RequiresApi(api=Build.VERSION_CODES.N_MR1)
    private void getMangerInfo(){
        ShortcutInfo shortcut=new ShortcutInfo.Builder(this,"id1").setShortLabel("Web site")
                .setLongLabel("第一个")
                .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setIntent(new Intent(Intent.ACTION_MAIN,Uri.EMPTY,this,
                        MainActivity.class))
                .build();
        ShortcutInfo shortcut2 = new ShortcutInfo.Builder(this, "id2")
                .setShortLabel("Web site")
                .setLongLabel("第二个")
                .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.csdn.com/")))
                .build();
        ShortcutInfo shortcut3 = new ShortcutInfo.Builder(this, "id3")
                .setShortLabel("Web site")
                .setLongLabel("第三个")
                .setIcon(Icon.createWithResource(this, R.mipmap.ic_launcher))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.github.com/")))
                .build();
        manager.setDynamicShortcuts(Arrays.asList(shortcut, shortcut2, shortcut3));
    }
}
