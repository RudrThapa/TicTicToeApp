package com.rudroid.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2 ,btn3 ,btn4 ,btn5 ,btn6 ,btn7 ,btn8 ,btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag = 0;
    int count = 0;
    TextView exitbtn, resetbtn;
    Animation clickon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();

    }

    public void init(){
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        resetbtn = findViewById(R.id.resetbtn);
        exitbtn = findViewById(R.id.exitbtn);

        clickon = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clickonbtn);

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetbtn.startAnimation(clickon);
                newGame();
            }
        });

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitbtn.startAnimation(clickon);
                finishAffinity();
            }
        });
    }

    public void Check(View view) {
        Button btnCurr = (Button) view;

        if (btnCurr.getText().toString().isEmpty()) {

            count++;

            if (flag == 0) {
                btnCurr.setText("X");
                flag = 1;
            } else {
                btnCurr.setText("O");
                flag = 0;
            }

            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();


                if (b1.equals(b2) && b2.equals(b3) && !b1.isEmpty()) {
//                    Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_SHORT).show();
                    winnerPage(b1);
                    newGame();

                } else if (b4.equals(b5) && b5.equals(b6) && !b4.isEmpty()) {
//                    Toast.makeText(this, "Winner is: " + b4, Toast.LENGTH_SHORT).show();
                    winnerPage(b4);
                    newGame();

                } else if (b7.equals(b8) && b8.equals(b9) && !b7.isEmpty()) {
//                    Toast.makeText(this, "Winner is: " + b7, Toast.LENGTH_SHORT).show();
                    winnerPage(b7);
                    newGame();

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.isEmpty()) {
//                    Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_SHORT).show();
                    winnerPage(b1);
                    newGame();

                } else if (b2.equals(b5) && b5.equals(b8) && !b2.isEmpty()) {
//                    Toast.makeText(this, "Winner is: " + b2, Toast.LENGTH_SHORT).show();
                    winnerPage(b2);
                    newGame();

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.isEmpty()) {
//                    Toast.makeText(this, "Winner is: " + b3, Toast.LENGTH_SHORT).show();
                    winnerPage(b3);
                    newGame();

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.isEmpty()) {
//                    Toast.makeText(this, "Winner is: " + b1, Toast.LENGTH_SHORT).show();
                    winnerPage(b1);
                    newGame();

                } else if (b3.equals(b5) && b5.equals(b7) && !b3.isEmpty()) {
//                    Toast.makeText(this, "Winner is: " + b3, Toast.LENGTH_SHORT).show();
                    winnerPage(b3);
                    newGame();

                } else if(!b1.isEmpty() && !b2.isEmpty() && !b3.isEmpty() &&
                        !b4.isEmpty() && !b5.isEmpty() && !b6.isEmpty() &&
                        !b7.isEmpty() && !b8.isEmpty() && !b9.isEmpty()){
                    winnerPage("-1");
                    newGame();
                }

            }
        }
    }
    public void newGame(){
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        count = 0;
        flag = 0;
    }

    public void winnerPage(String str){

        Intent winPage = new Intent(getApplicationContext(), WinnerPage.class);
        winPage.putExtra("winnerP",str);
        startActivity(winPage);
    }
}