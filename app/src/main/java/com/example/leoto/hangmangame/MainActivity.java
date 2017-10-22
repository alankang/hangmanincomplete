package com.example.leoto.hangmangame;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ButtonsFragment.ButtonsFragmentListener {
    private static final String MyFlag = "Hangman_Game";
    Button btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ, btnNew;
    private boolean[] correctInput;
    Button btnClicked;
    String btnValue;
    Button[] btnlist;
    boolean[] alreadyClicked;
    private TextView txtInput0;
    private TextView txtInput1;
    private TextView txtInput2;
    private TextView txtInput3;
    private TextView txtInput4;
    private TextView txtDash0;
    private TextView txtDash1;
    private TextView txtDash2;
    private TextView txtDash3;
    private TextView txtDash4;
    private TextView hint;

    private int count = 0;
    private int score = 0;

    private ImageView hangman;






    private String[]words = {"APPLE","SHARK","DREAM","WHITE","EAGLE"};
    private String[]hints = {"FRUIT","SEA CREATURE","SLEEP", "COLOR", "BIRD"};
    Random A = new Random();
    int index = A.nextInt(5);
    String preSelectedWord = words[index];
    String preSelectedHint = hints[index];






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtInput0 = (TextView)findViewById(R.id.txtInput0);
        txtInput1 = (TextView)findViewById(R.id.txtInput1);
        txtInput2 = (TextView)findViewById(R.id.txtInput2);
        txtInput3 = (TextView)findViewById(R.id.txtInput3);
        txtInput4 = (TextView)findViewById(R.id.txtInput4);
        txtDash0 = (TextView)findViewById(R.id.txtDash0);
        txtDash1 = (TextView)findViewById(R.id.txtDash1);
        txtDash2 = (TextView)findViewById(R.id.txtDash2);
        txtDash3 = (TextView)findViewById(R.id.txtDash3);
        txtDash4 = (TextView)findViewById(R.id.txtDash4);
        hint = (TextView)findViewById(R.id.hint);
        if (hint != null) {
            hint.setText("Hint: " + preSelectedHint);
        }
        hangman = (ImageView)findViewById(R.id.hangman);

        correctInput = new boolean[preSelectedWord.length()+1];
        for(int i = 0;i<preSelectedWord.length();i++){
            correctInput[i]=false;
        }
        alreadyClicked = new boolean[26];
        for(int i = 0;i<26;i++){
            alreadyClicked[i] = false;
        }
//        Button btnA = (Button) findViewById(R.id.btnA);
//        Button btnB = (Button) findViewById(R.id.btnB);
//        Button btnC = (Button) findViewById(R.id.btnC);
//        Button btnD = (Button) findViewById(R.id.btnD);
//        Button btnE = (Button) findViewById(R.id.btnE);
//        Button btnF = (Button) findViewById(R.id.btnF);
//        Button btnG = (Button) findViewById(R.id.btnG);
//        Button btnH = (Button) findViewById(R.id.btnH);
//        Button btnI = (Button) findViewById(R.id.btnI);
//        Button btnJ = (Button) findViewById(R.id.btnJ);
//        Button btnK = (Button) findViewById(R.id.btnK);
//        Button btnL = (Button) findViewById(R.id.btnL);
//        Button btnM = (Button) findViewById(R.id.btnM);
//        Button btnN = (Button) findViewById(R.id.btnN);
//        Button btnO = (Button) findViewById(R.id.btnO);
//        Button btnP = (Button) findViewById(R.id.btnP);
//        Button btnQ = (Button) findViewById(R.id.btnQ);
//        Button btnR = (Button) findViewById(R.id.btnR);
//        Button btnS = (Button) findViewById(R.id.btnS);
//        Button btnT = (Button) findViewById(R.id.btnT);
//        Button btnU = (Button) findViewById(R.id.btnU);
//        Button btnV = (Button) findViewById(R.id.btnV);
//        Button btnW = (Button) findViewById(R.id.btnW);
//        Button btnX = (Button) findViewById(R.id.btnX);
//        Button btnY = (Button) findViewById(R.id.btnY);
//        Button btnZ = (Button) findViewById(R.id.btnZ);
//
//        Button btnNew = (Button) findViewById(R.id.btnNew);
//
//        btnA.setOnClickListener(onClickListener);
//        btnB.setOnClickListener(onClickListener);
//        btnC.setOnClickListener(onClickListener);
//        btnD.setOnClickListener(onClickListener);
//        btnE.setOnClickListener(onClickListener);
//        btnF.setOnClickListener(onClickListener);
//        btnG.setOnClickListener(onClickListener);
//        btnH.setOnClickListener(onClickListener);
//        btnI.setOnClickListener(onClickListener);
//        btnJ.setOnClickListener(onClickListener);
//        btnK.setOnClickListener(onClickListener);
//        btnL.setOnClickListener(onClickListener);
//        btnM.setOnClickListener(onClickListener);
//        btnN.setOnClickListener(onClickListener);
//        btnO.setOnClickListener(onClickListener);
//        btnP.setOnClickListener(onClickListener);
//        btnQ.setOnClickListener(onClickListener);
//        btnR.setOnClickListener(onClickListener);
//        btnS.setOnClickListener(onClickListener);
//        btnT.setOnClickListener(onClickListener);
//        btnU.setOnClickListener(onClickListener);
//        btnV.setOnClickListener(onClickListener);
//        btnW.setOnClickListener(onClickListener);
//        btnX.setOnClickListener(onClickListener);
//        btnY.setOnClickListener(onClickListener);
//        btnZ.setOnClickListener(onClickListener);
//
//        btnNew.setOnClickListener(onClickListener);
//
//        btnlist = new Button[]{
//                btnA, btnB, btnC, btnD, btnE, btnF, btnG, btnH, btnI, btnJ, btnK, btnL, btnM, btnN, btnO, btnP, btnQ, btnR, btnS, btnT, btnU, btnV, btnW, btnX, btnY, btnZ
//        };
    }


    public int showCorrectInput(String x){
        int o_flag = 0;
        Log.i(MyFlag, "preSelectedWord: " + preSelectedWord);
        if(preSelectedWord.contains(x)){
            Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
            o_flag = 1;
            for (int i = 0; i < preSelectedWord.length(); i++) {
                if (x.equals(String.valueOf(preSelectedWord.charAt(i)))) {
                    switch(i) {
                        case 0:
                            txtInput0.setText(String.valueOf(x));
                            break;
                        case 1:
                            txtInput1.setText(String.valueOf(x));
                            break;
                        case 2:
                            txtInput2.setText(String.valueOf(x));
                            break;
                        case 3:
                            txtInput3.setText(String.valueOf(x));
                            break;
                        case 4:
                            txtInput4.setText(String.valueOf(x));
                            break;
                    }
                }
            }
            score++;
            if (score == 5) {
                Toast.makeText(getApplicationContext(), "Win!", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Play Again?", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
        }
        Log.i(MyFlag, "o_flag: " + String.valueOf(o_flag));
        return o_flag;
    }


    public final View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            int done_flag = 0;
            Log.i(MyFlag, "count: " + String.valueOf(count));
            if (v.getId() == R.id.btnNew) {
                Toast.makeText(getApplicationContext(), "Starting new game", Toast.LENGTH_SHORT).show();
                Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
            if (count < 6) {
                btnClicked = (Button) v;
                btnValue = btnClicked.getText().toString();
                for (int i = 0; i < 26; i++) {
                    if (v == btnlist[i]) {
                        alreadyClicked[i] = true;

                    }
                }
                btnClicked.setClickable(false);
                btnClicked.setEnabled(false);
                btnClicked.setBackgroundColor(Color.WHITE);

                if (showCorrectInput(btnValue) != 1) {
                    switch(count) {
                        case 0:
                            hangman.setImageResource(R.drawable.h1);
                            break;
                        case 1:
                            hangman.setImageResource(R.drawable.h2);
                            break;
                        case 2:
                            hangman.setImageResource(R.drawable.h3);
                            break;
                        case 3:
                            hangman.setImageResource(R.drawable.h4);
                            break;
                        case 4:
                            hangman.setImageResource(R.drawable.h5);
                            break;
                        case 5:
                            hangman.setImageResource(R.drawable.h6);
                            break;
                    }
                    count ++;
                    Log.i(MyFlag, "count++");
                    if (score == 5) {
                        done_flag = 1;
                        Toast.makeText(getApplicationContext(), "Play Again? Hit NEW", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (done_flag != 0){
                Toast.makeText(getApplicationContext(), "Lost", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Play Again? Hit NEW", Toast.LENGTH_SHORT).show();
                Log.i(MyFlag, "count :" + String.valueOf(count) + " is above  6");
                Log.i(MyFlag, "done_flag: " + String.valueOf(done_flag));
                done_flag = 1;
            } else {
                Toast.makeText(getApplicationContext(), "Play Again? Hit NEW", Toast.LENGTH_SHORT).show();
            }
        }

    };

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(MyFlag, "Retrieving our saved state from before... ");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(MyFlag, "Bundling State of our views before they get destroyed");
        super.onSaveInstanceState(outState);
    }
}
