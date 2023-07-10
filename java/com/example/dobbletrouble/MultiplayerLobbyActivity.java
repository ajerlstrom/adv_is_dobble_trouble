package com.example.dobbletrouble;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MultiplayerLobbyActivity extends AppCompatActivity {
    private GestureDetector gestureDetector;
    ArrayList<TextView> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer_lobby);
        View view = findViewById(R.id.constraintLayout);
        this.gestureDetector = new GestureDetector(this.getBaseContext(), new GestureDetector.SimpleOnGestureListener() {
            public void onLongPress(MotionEvent e) {
                System.out.println("Longpress detected");
                //launchMultiplayerGame();
            }

            public boolean onTouchEvent(MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            };
        });

        initLobby();
    }

    private void initLobby(){
        int nbPlayersConnected = players.size();
        TextView tv;
        switch(nbPlayersConnected){
            case 0:
                tv = findViewById(R.id.textView4);
                tv.setText("YOU");
                players.add(tv);
                break;
            case 1:
                tv = findViewById(R.id.textView3);
                tv.setText("YOU");
                players.add(tv);
                break;
            case 2:
                tv = findViewById(R.id.textView2);
                tv.setText("YOU");
                players.add(tv);
                break;

            case 3:
                tv = findViewById(R.id.textView);
                tv.setText("YOU");
                players.add(tv);
                break;
        }
    }

    private void launchMultiplayerGame(){

    }
}
