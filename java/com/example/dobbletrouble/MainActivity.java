package com.example.dobbletrouble;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.dobbletrouble.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   public void playGame(View view){
        Intent intent = new Intent(this, StartDobbleActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "YOU PRESSED PLAY");
        startActivity(intent);
    }
/*
    public void playMultiplayer(View view){
        Intent multi = new Intent(this, MultiplayerLobbyActivity.class);
        multi.putExtra(EXTRA_MESSAGE, "YOU PRESSED MULTIPLAYER");
        startActivity(multi);
    }

 */
}