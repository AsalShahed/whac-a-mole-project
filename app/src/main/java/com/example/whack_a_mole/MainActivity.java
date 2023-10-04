package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
/**
 * @author Judy & Chahed
 * DA393A
 */
public class MainActivity extends AppCompatActivity implements sendmetod{
    
    
    private TextView username;
    private MaterialButton startBtn;
    private MaterialButton historyBtn;
    private RadioButton easyBtn;
    private RadioButton mediumBtn;
    private RadioButton hardBtn;
    private String level="0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        username= (TextView) findViewById (R.id.username);
        startBtn= (MaterialButton) findViewById (R.id.startBtn);
        historyBtn= (MaterialButton) findViewById (R.id.historyBtn);
        
        easyBtn=(RadioButton) findViewById(R.id.easyBtn);
        mediumBtn= (RadioButton) findViewById(R.id.mediumBtn);
        hardBtn= (RadioButton) findViewById(R.id.hardBtn);
        
        
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String name = username.getText().toString();
                if (!name.isEmpty() && (easyBtn.isChecked() || mediumBtn.isChecked() || hardBtn.isChecked() )){
                    Toast.makeText(MainActivity.this, "After a few  seconds start the game", Toast.LENGTH_SHORT).show();
                    startBtn.setVisibility(View.GONE);
                   new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent= new Intent(MainActivity.this, MainActivity3.class);
                            startActivity(intent);
                            send(view);
                        }
                    }, 6000);
    
                   
                }else
                    Toast.makeText(MainActivity.this, "PLEASE ENTER BOTH NAME & LEVEL", Toast.LENGTH_SHORT).show();
            }
        });
        
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        
        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (easyBtn.isChecked()){
                    level="1";
                }
            }
        });
        
        mediumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediumBtn.isChecked()){
                    level="2";
                }
            }
        });
        
        hardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hardBtn.isChecked()){
                    level="3";
                }
            }
        });
        
    }
    
    @Override
    public void send(View v) {
        String message = username.getText().toString();
        MessageSender ms = new MessageSender();
        ms.execute(message,level);
    }
}
