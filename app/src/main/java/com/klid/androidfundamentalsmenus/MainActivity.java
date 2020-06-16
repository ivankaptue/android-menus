package com.klid.androidfundamentalsmenus;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.PopupMenu;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ActionMode mActionMode;

    private ActionMode.Callback mCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.actionmode_context_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.actionModelMenu1:
                    Toast.makeText(MainActivity.this, "Action mode 1 clicked", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.actionModelMenu2:
                    Toast.makeText(MainActivity.this, "Action mode 2 clicked", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.actionModelMenu3:
                    Toast.makeText(MainActivity.this, "Action mode 3 clicked", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.txtTitle);
        registerForContextMenu(tv);

        Button button = findViewById(R.id.btnActionModeMenu);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });
        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null) {
                    return false;
                }

                mActionMode = startSupportActionMode(mCallback);
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        item.setChecked(!item.isChecked());

        switch (item.getItemId()) {
            case R.id.menuItem1:
                Toast.makeText(this, "Menu item 1 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuItem2:
                Toast.makeText(this, "Menu item 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuItem3:
                Toast.makeText(this, "Menu item 3 clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.floating_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.contextMenu1:
                Toast.makeText(this, "Contextual Menu 1 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contextMenu2:
                Toast.makeText(this, "Contextual Menu 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.contextMenu3:
                Toast.makeText(this, "Contextual Menu 3 clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.popupMenu1:
                Toast.makeText(this, "Popup Menu 1 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popupMenu2:
                Toast.makeText(this, "Popup Menu 2 clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.popupMenu3:
                Toast.makeText(this, "Popup Menu 3 clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }
}