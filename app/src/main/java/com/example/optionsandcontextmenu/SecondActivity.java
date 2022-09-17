package com.example.optionsandcontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView imageViewOne;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initViews();
        initListeners();

        registerForContextMenu(imageViewOne);
    }

    private void initViews(){
        imageViewOne = findViewById(R.id.imageViewOne);
        btnBack = findViewById(R.id.btnBack);
    }

    private void initListeners(){
        btnBack.setOnClickListener(new BtnBackClickListener());
    }

    private class BtnBackClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            finish();
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.download_menu,menu);
        menu.setHeaderTitle("Context Menu");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.save:
                makeToast("Save");
                break;

            case R.id.saveAs:
                makeToast("Save As");
                break;

            case R.id.copy:
                makeToast("Copy");
                break;

            case R.id.open:
                makeToast("Open");
                break;

            case R.id.saveImageUrl:
                makeToast("Save Image URL");
                break;
        }

        return super.onContextItemSelected(item);
    }

    private void makeToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }
}