package com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class KhoahocActivity extends AppCompatActivity {

    private ListView lvkhoahoc;
    String[] arr = new String[] {"Lập trình Mobile \n Thời gian đào tạo: 2 năm 4 tháng",
            "Lập trình Web \n Thời gian đào tạo: 2 năm 4 tháng",
            "Ứng dụng phần mềm \n Thời gian đào tạo: 2 năm 4 tháng",
            "Thiết kế đồ họa \n Thời gian đào tạo: 2 năm 4 tháng",
            "Digital Marketing \n Thời gian đào tạo: 2 năm 4 tháng"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoahoc);
        lvkhoahoc = findViewById(R.id.lvkhoahoc);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(KhoahocActivity.this, android.R.layout.simple_list_item_1, arr);

        lvkhoahoc.setAdapter(adapter);

        lvkhoahoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(KhoahocActivity.this, MonhocActivity.class);
                intent.putExtra("dangkikhoahoc", arr[i] );
                startActivity(intent);
            }
        });

    }
}