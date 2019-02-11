package com.example.delowar.countryprofile;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.ActionBar;

public class ProfileCountry extends Activity {

    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_country);
        imageView=(ImageView)findViewById(R.id.im);
        textView=(TextView)findViewById(R.id.tv);

        //create  a action bar it will only work on AppCompactActivity but my app crash appcompactactivity
        
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        */
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            String countryName=bundle.getString("name");

            showDetails(countryName);
        }
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
*/
    void showDetails(String countryName)
    {
        if (countryName.equals("Bangladesh"))
        {
            imageView.setImageResource(R.mipmap.bd);
            textView.setText(R.string.Bd_txt);

        }
        if (countryName.equals("India"))
        {
            imageView.setImageResource(R.mipmap.in);
            textView.setText(R.string.In_txt);

        }
        if (countryName.equals("Pakistan"))
        {
            imageView.setImageResource(R.mipmap.pk);
            textView.setText(R.string.pak_text);

        }
    }
}
