package com.example.delowar.searchmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import static java.lang.String.format;

public class MainActivity extends Activity {

    ListView listView;
    String[] varsityName;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView1);
        varsityName = getResources().getStringArray(R.array.varsity_name);
        arrayAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.temp,R.id.textView,varsityName);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick (AdapterView < ? > adapterView, View view, int position, long id){
//        String name = varsityName[position];
        String name = arrayAdapter.getItem(position);
        Toast.makeText(MainActivity.this, format("Your selected varsity %s", name), Toast.LENGTH_SHORT).show();

        }
    });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        MenuItem menuItem=menu.findItem(R.id.searchId);

        final SearchView searchView= (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayAdapter.getFilter().filter(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }
}
