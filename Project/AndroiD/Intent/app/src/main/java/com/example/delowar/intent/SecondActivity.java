package com.example.delowar.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
EditText editText;
Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		button=(Button)findViewById(R.id.bt);
		editText=(EditText)findViewById(R.id.et);
		button.setOnClickListener(new View.OnClickListener() {
				 @Override
				public void onClick(View view) {
						Intent intent=new Intent(SecondActivity.this,MainActivity.class);
						String value=editText.getText().toString();
						intent.putExtra("key",value);
						setResult(1,intent);
						//startActivity(intent);
					 finish();
				}
		}
		);
	}
}
