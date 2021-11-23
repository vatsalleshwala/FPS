package com.tanna.fps;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CpuUsageInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import com.ms_square.debugoverlay.DebugOverlay;
import com.ms_square.debugoverlay.Position;
import com.ms_square.debugoverlay.modules.CpuFreqModule;
import com.ms_square.debugoverlay.modules.CpuUsageModule;
import com.ms_square.debugoverlay.modules.FpsModule;

public class MainActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(),btn);
                popupMenu.getMenuInflater().inflate(R.menu.menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.topleft:
                                new DebugOverlay.Builder(getApplication())
                                        .modules(new FpsModule(),new CpuUsageModule(),new CpuFreqModule())
                                        .textColor(Color.RED)
                                        .bgColor(Color.TRANSPARENT)
                                        .position(Position.TOP_START)
                                        .build()
                                        .install();
                                return true;
                            case R.id.topright:
                                new DebugOverlay.Builder(getApplication())
                                        .modules(new FpsModule(),new CpuUsageModule(),new CpuFreqModule())
                                        .textColor(Color.RED)
                                        .bgColor(Color.TRANSPARENT)
                                        .position(Position.TOP_END)
                                        .build()
                                        .install();
                                return true;
                            case R.id.bottomleft:
                                new DebugOverlay.Builder(getApplication())
                                        .modules(new FpsModule(),new CpuUsageModule(),new CpuFreqModule())
                                        .textColor(Color.RED)
                                        .bgColor(Color.TRANSPARENT)
                                        .position(Position.BOTTOM_START)
                                        .build()
                                        .install();
                                return true;
                            case R.id.bottomright:
                                new DebugOverlay.Builder(getApplication())
                                        .modules(new FpsModule(),new CpuUsageModule(),new CpuFreqModule())
                                        .textColor(Color.RED)
                                        .bgColor(Color.TRANSPARENT)
                                        .position(Position.BOTTOM_END)
                                        .build()
                                        .install();
                                return true;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}