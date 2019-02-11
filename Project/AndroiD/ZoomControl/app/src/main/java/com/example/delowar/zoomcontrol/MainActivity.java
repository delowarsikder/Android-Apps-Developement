package com.example.delowar.zoomcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends Activity {

    ImageView imageView;
    ZoomControls zoomControls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.im);
        zoomControls=(ZoomControls)findViewById(R.id.zm);

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Zoom in",Toast.LENGTH_SHORT).show();
                float x=imageView.getScaleX();
                float y=imageView.getScrollY();
                imageView.setScaleX((float) x+1);
                imageView.setScaleY((float) y+1);
            }
        });
        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Zoom out",Toast.LENGTH_SHORT).show();
                float x=imageView.getScaleX();
                float y=imageView.getScrollY();

                    imageView.setScaleX((float) x-1);
                    imageView.setScaleY((float) y-1);

            }
        });
    }
}
