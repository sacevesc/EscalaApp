package mx.iteso.escalaapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityJudging extends AppCompatActivity {
    int triesCounter = 0, bonusCounter = 0, time = 300, last;
    boolean top = false;
    TextView topV, triesV, bonusV, timerV, resultsV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judging);
        topV = findViewById(R.id.activity_judging_topCounter);
        bonusV = findViewById(R.id.activity_judging_bonusCounter);
        triesV = findViewById(R.id.activity_judging_triesCounter);
        timerV = findViewById(R.id.activity_judging_timer);
        resultsV = findViewById(R.id.activity_judging_results);
        resultsV.setText("t0-b0");
    }

    public void startTimer(){
        new CountDownTimer(300000, 1000) {

            public void onTick(long millisUntilFinished) {
                if(!top) {
                    timerV.setText(formatTime(time));
                    time--;
                }
            }

            public void onFinish() {
                timerV.setText("try again");
            }

        }.start();
    }

    public String formatTime(int totalSecs){
        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void addTry(View v){
        if(!top) {
            if (triesCounter == 0)
                startTimer();
            last = 0;
            triesCounter++;
            triesV.setText(String.valueOf(triesCounter));
        }
    }

    public void setTop(View v){
        if(!top) {
            last = 1;
            top = true;
            topV.setText(String.valueOf(triesCounter));
            resultsV.setText("t" + (top ? triesCounter : "0") + "-b" + bonusCounter);
        }
    }

    public void setBonus(View v){
        if(!top) {
            last = 2;
            bonusCounter = triesCounter;
            bonusV.setText(String.valueOf(bonusCounter));
            resultsV.setText("t" + (top ? triesCounter : "0") + "-b" + bonusCounter);
        }
    }
    public void undo(View v){
        switch(last){
            case 0:
                triesCounter --;
                triesV.setText(String.valueOf(triesCounter));
                break;
            case 1:
                top = false;
                topV.setText("");
                resultsV.setText("t" + (top ? triesCounter : "0") + "-b" + bonusCounter);

                break;
            case 2:
                bonusCounter = 0;
                bonusV.setText("");
                resultsV.setText("t0-b0");
                break;
        }

    }
}
