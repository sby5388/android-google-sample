package com.example.android.actionbarcompat.listpopupmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class TempActivity extends AppCompatActivity {
    private Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        findViewById(R.id.button_1).setOnClickListener(this::showPopupMenu);
        findViewById(R.id.button_2).setOnClickListener(this::showSupportPopupMenu);
    }


    private void showPopupMenu(View view) {
        final android.widget.PopupMenu popupMenu = new android.widget.PopupMenu(this, view);
        // TODO: 2020/2/26 调用的是 popupMenu.getMenuInflater()
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new android.widget.PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.popup_menu) {
                    toast(item.getTitle().toString());
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();

    }

    private void showSupportPopupMenu(View view) {
        final PopupMenu popupMenu = new PopupMenu(this, view);
        // TODO: 2020/2/26 调用的是 popupMenu.getMenuInflater()
        popupMenu.getMenuInflater().inflate(R.menu.menu_support_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.support_popup_menu) {
                    toast(item.getTitle().toString());
                    return true;
                }
                return false;
            }
        });
        popupMenu.show();

    }

    private void toast(String s) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        mToast.show();
    }
}
