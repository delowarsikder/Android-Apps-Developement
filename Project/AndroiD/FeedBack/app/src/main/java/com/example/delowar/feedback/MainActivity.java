package com.example.delowar.feedback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.feedbackID) {
            Toast.makeText(getApplicationContext(), "feed back  is selected", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,FeedBack.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.shareId)
        {
            Toast.makeText(getApplicationContext(),"Shared is selected ",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getApplicationContext(),FeedBack.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}
