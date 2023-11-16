package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edt_hoten;
    Button btn_nhap;
    ListView listView;

    ArrayList<String> ds_hoten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_hoten = findViewById(R.id.edt_hoten);
        btn_nhap = findViewById(R.id.btn_Nhaphoten);
        listView = findViewById(R.id.lv_dsHoten);

        ds_hoten = new ArrayList<>();
        ds_hoten.add("Hoang Duy");
        ds_hoten.add("CNTT");

        Adapter_Listview adapterListview = new Adapter_Listview(MainActivity.this,R.layout.item_listview,ds_hoten);
        listView.setAdapter(adapterListview);

        btn_nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ds_hoten.add(edt_hoten.getText().toString());
                adapterListview.notifyDataSetChanged();

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Đã xóa '"+ ds_hoten.get(i)+"'",Toast.LENGTH_SHORT).show();
                ds_hoten.remove(i);
                adapterListview.notifyDataSetChanged();
                return false;
            }
        });
    }
}