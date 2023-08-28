package com.example.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "FirstActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
        Log.d(TAG, "onCreate");
    }
    public void click(View view) {
        showToastFor10Seconds("Thông báo tự động biến mất sau 10 giây", Toast.LENGTH_LONG, 10000);
    }

    private void showToastFor10Seconds(String message, int duration, long delayMillis) {
        final Toast toast = Toast.makeText(this, message, duration);

        // Hiển thị thông báo toast
        toast.show();

        // Sử dụng Handler để ẩn thông báo sau 10 giây
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel(); // Ẩn thông báo toast
            }
        }, delayMillis);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}