package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
/**
 * @author Judy & Chahed
 * DA393A
 */
public class MainActivity4 extends AppCompatActivity  {
	
	private MaterialButton newGameBtn;
	private TextView first_place;
	
	
	
	@Override
	protected synchronized void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main4);
		first_place = (TextView) findViewById(R.id.first_place);
		
		newGameBtn = findViewById(R.id.newGameBtn);
		newGameBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity4.this, MainActivity.class);
				startActivity(intent);
				//uppdatera listan
			}
		});
	}
	
	/*@Override
	public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
		
		//first_place.setText((String) propertyChangeEvent.getNewValue());
		//first_place.setText(sender.score);
		
	}*/
}


