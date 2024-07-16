package com.rudroid.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TicTacToeStartScreen extends AppCompatActivity {


    TextView btnstartscreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tic_tac_toe_start_screen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnstartscreen = findViewById(R.id.btnstartscreen);

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clickablebtn);
        btnstartscreen.startAnimation(anim);

        btnstartscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clickonbtn);
                btnstartscreen.startAnimation(anim2);

                Intent iHome = new Intent(TicTacToeStartScreen.this, MainActivity.class);
                startActivity(iHome);
            }
        });

    }
}