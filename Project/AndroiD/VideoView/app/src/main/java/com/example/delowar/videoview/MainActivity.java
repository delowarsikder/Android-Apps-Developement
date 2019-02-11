package com.example.delowar.videoview;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.concurrent.atomic.AtomicReference;

import static java.lang.String.*;

public class MainActivity extends Activity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=(VideoView)findViewById(R.id.vv);
        Uri uri=Uri.parse(format("android.resource://" + getPackageName() + R.raw.i_am_gpa.mp4));
        videoView.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
