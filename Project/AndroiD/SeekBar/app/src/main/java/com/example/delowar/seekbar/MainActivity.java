package com.example.delowar.seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    SeekBar seekBar1;
    TextView textView;
    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar1=(SeekBar)findViewById(R.id.sB1);
        textView=(TextView) findViewById(R.id.tv1);
        aSwitch=(Switch) findViewById(R.id.sW1);

        textView.setText("Volume : "+seekBar1.getProgress()+"/"+seekBar1.getMax());

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b)
                {
                    Toast.makeText(MainActivity.this,"searching Networikg",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"to show network ,turn on",Toast.LENGTH_SHORT).show();
                }

            }
        });
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setText("Volume : "+i+"/"+seekBar1.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

                Toast.makeText(MainActivity.this,"onStartTracking",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"onStopTracking",Toast.LENGTH_SHORT).show();
            }

        });
    }
}
