package com.rudroid.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
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

import com.airbnb.lottie.LottieAnimationView;

public class WinnerPage extends AppCompatActivity {

    MediaPlayer clap, lose;
    TextView txtWinner, playAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_winner_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        txtWinner = findViewById(R.id.txtWinner);
        playAgain = findViewById(R.id.playAgain);

        clap = MediaPlayer.create(getApplicationContext(), R.raw.clapping);
        lose = MediaPlayer.create(getApplicationContext(), R.raw.fart);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clickablebtn);

        String str = getIntent().getStringExtra("winnerP");

        if ("X".equals(str)) {
            clap.start();
            String string = "Winner is Player 1";
            txtWinner.setText(string);
        } else if ("O".equals(str)) {
            clap.start();
            String string = "Winner is Player 2";
            txtWinner.setText(string);
        } else {
            lose.start();
            txtWinner.setText("Draw!");
        }

        txtWinner.startAnimation(anim);
        playAgain.startAnimation(anim);


        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WinnerPage.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    protected void onPause() {
        super.onPause();
        if (clap != null && clap.isPlaying()) {
            clap.pause();
        }
        if (lose != null && lose.isPlaying()) {
            lose.pause();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (clap != null) {
            clap.release();
            clap = null;
        }
        if (lose != null) {
            lose.release();
            lose = null;
        }
    }

}
