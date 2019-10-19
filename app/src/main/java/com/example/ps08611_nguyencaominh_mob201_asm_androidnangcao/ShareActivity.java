package com.example.ps08611_nguyencaominh_mob201_asm_androidnangcao;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Button b1 = (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri screenshotUri = Uri.parse("android.resource://comexample.sairamkrishna.myapplication/*");

                try {
                    InputStream stream = getContentResolver().openInputStream(screenshotUri);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, screenshotUri);
                startActivity(Intent.createChooser(sharingIntent, "Share image using"));
            }
        });
    }

    public void backlich(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}