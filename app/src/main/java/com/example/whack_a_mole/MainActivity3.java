package com.example.whack_a_mole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.Locale;
/**
 * @author Judy & Chahed
 * DA393A
 */
public class MainActivity3 <mTextViewCountDown> extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 30000; //30000 ;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = START_TIME_IN_MILLIS;
    private boolean timerRunning;
    private TextView mTextViewCountDown;
    private MaterialButton stopBtn;
    
   
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        stopBtn = findViewById(R.id.stopBtn);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
                //Skicka ett nolla till server
            }
        });
    
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            
            @Override
            public void onFinish() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        timerRunning = false;
                        System.out.println("Timer finished");
                        Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                        startActivity(intent);
                        
                    }
                }, 1);
                
            }
        }.start();
        timerRunning = true;
    }
    
    private void stopTimer(){
        countDownTimer.cancel();
        timeLeftInMillis= START_TIME_IN_MILLIS;
        updateCountDownText();
        
        timerRunning = false;
        Intent intent= new Intent(MainActivity3.this, MainActivity.class);
        startActivity(intent);
    }
    
    
    private void updateCountDownText(){
        int minutes= (int) (timeLeftInMillis/1000) / 60;
        int seconds= (int) (timeLeftInMillis/1000) % 60;
        String timeLeftFormatted= String.format(Locale.getDefault(),"%01d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
        
    }
}


