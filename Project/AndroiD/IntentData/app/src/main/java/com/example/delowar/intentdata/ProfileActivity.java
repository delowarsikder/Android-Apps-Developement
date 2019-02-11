package com.example.delowar.intentdata;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends Activity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        textView=(TextView)findViewById(R.id.tv);
        Bundle bundle=getIntent().getExtras();

        if(bundle!=null)
        {
            String value=bundle.getString("tag");
            textView.setText(value);
        }
    }
}
