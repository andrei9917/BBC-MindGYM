package com.example.andrei.bbc_mindgym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class GamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        ImageButton imageButton1 = findViewById(R.id.game_button_1);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGame1();
            }
        });

        ImageButton imageButton2 = findViewById(R.id.game_button_2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGame2();
            }
        });

        ImageButton imageButton3 = findViewById(R.id.game_button_3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGame3();
            }
        });

        ImageButton imageButton4 = findViewById(R.id.game_button_4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGame4();
            }
        });

        ImageButton imageButton5 = findViewById(R.id.game_button_5);
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGame5();
            }
        });

    }

    public void openGame1() {
        startActivity(new Intent(GamesActivity.this, GameActivity1.class));
    }

    public void openGame2() {
        startActivity(new Intent(GamesActivity.this, GameActivity2.class));
    }

    public void openGame3() {
        startActivity(new Intent(GamesActivity.this, GameActivity3.class));
    }

    public void openGame4() {
        startActivity(new Intent(GamesActivity.this, GameActivity4.class));
    }

    public void openGame5() {
        startActivity(new Intent(GamesActivity.this, GameActivity5.class));
    }

}
