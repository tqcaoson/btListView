package com.example.listviewbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonAn;
    Button btnAdd, btnUpdate, btnDelete;
    EditText edtMonAn;
    ArrayList<String> monAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        monAn = new ArrayList<>();
        monAn.add("Cánh gà rán");
        monAn.add("Nước lọc");
        monAn.add("Cơm Chiên");
        monAn.add("Phở");
        monAn.add("Phồng tôm");
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, R.layout.support_simple_spinner_dropdown_item, monAn);
        lvMonAn.setAdapter(adapter);
        lvMonAn.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("dl", monAn.get(position));
                intent.putExtras(bundle);
                startActivity(intent);
                return false;
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten = edtMonAn.getText().toString();
                monAn.add(ten);
                adapter.notifyDataSetChanged();
            }
        });
        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                edtMonAn.setText(monAn.get(position));
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        monAn.set(position, edtMonAn.getText().toString());
                        adapter.notifyDataSetChanged();
                    }
                });
                btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        monAn.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });

    }
    void anhXa(){
        lvMonAn = findViewById(R.id.lvMonAn);
        edtMonAn = findViewById(R.id.edtMonAn);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
    }
}
