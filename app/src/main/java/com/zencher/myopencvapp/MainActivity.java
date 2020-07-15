package com.zencher.myopencvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class MainActivity extends AppCompatActivity {

    static {
        if (!OpenCVLoader.initDebug()) {
            Log.d("zencher","Error opencv");
        }else {
            Log.d("zencher","OK OpenCV");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] r = getArray3d(2,1);
                Log.d("zencher", "result is "+r[1]);
                String message = "Hello";
                try {
                    Mat img = Utils.loadResource(MainActivity.this,R.drawable.swift, CvType.CV_8UC4);
                    message = "b:"+img.get(100,100)[0]+"g:"+img.get(100,100)[1]+"r:"+img.get(100,100)[2];
                    Log.d("zencher","channel "+img.size());
                } catch (Exception e) {
                    Log.d("zencher",""+e);
                }

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });



    }

    int[] getArray3d(int x, int y ){
        int[][][] array3d = new int[5][5][5];
        // initialization
        for (int i = 0 ; i < 5 ; i++) {
            for (int j = 0 ; j < 5  ; j++) {
                for (int k = 0 ; k < 5 ; k++){
                    array3d[i][j][k] = i+j+k;
                }
            }
        }
        return array3d[x][y];
    }
}
