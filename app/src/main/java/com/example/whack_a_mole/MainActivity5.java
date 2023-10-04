package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * @author Judy & Chahed
 * DA393A
 */
public class MainActivity5 extends AppCompatActivity {
	TextView second_place;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main5);
		second_place = (TextView) findViewById (R.id.second_place);
	}
}