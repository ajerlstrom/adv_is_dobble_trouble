package com.example.dobbletrouble;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import controller.SwipeListener;
import model.DobbleCard;
import model.DobbleSymbol;

public class StartDobbleActivity extends AppCompatActivity {
    int remaining_cards;
    boolean selectedCorrect;

    DobbleCard dc = new DobbleCard(0);
    DobbleCard player = new DobbleCard(1, dc);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        selectedCorrect = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_dobble);
        SwipeListener sl = new SwipeListener(findViewById(R.id.constraintLayout), this);
        initGame();
    }

    private void initGame(){
        remaining_cards = 6;

        init_player();
        init_deck();

    }

    private void init_player(){
        int i = 0;
        ImageButton b;
        for(DobbleSymbol s : player.getCard()) {
            switch (i) {
                case 0:
                    b = (ImageButton) findViewById(R.id.imageButton);
                    b.setImageResource(getImgId(s.symbolToInt()));
                    b.setTag(Integer.toString(s.symbolToInt()));
                    break;
                case 1:
                    b = (ImageButton) findViewById(R.id.imageButton1);
                    b.setImageResource(getImgId(s.symbolToInt()));
                    b.setTag(Integer.toString(s.symbolToInt()));
                    break;
                case 2:
                    b = (ImageButton) findViewById(R.id.imageButton2);
                    b.setImageResource(getImgId(s.symbolToInt()));
                    b.setTag(Integer.toString(s.symbolToInt()));
                    break;
                case 3:
                    b = (ImageButton) findViewById(R.id.imageButton3);
                    b.setImageResource(getImgId(s.symbolToInt()));
                    b.setTag(Integer.toString(s.symbolToInt()));
                    break;
                case 4:
                    b = (ImageButton) findViewById(R.id.imageButton4);
                    b.setImageResource(getImgId(s.symbolToInt()));
                    b.setTag(Integer.toString(s.symbolToInt()));
                    break;
                case 5:
                    b = (ImageButton) findViewById(R.id.imageButton5);
                    b.setImageResource(getImgId(s.symbolToInt()));
                    b.setTag(Integer.toString(s.symbolToInt()));
                    break;
                case 6:
                    b = (ImageButton) findViewById(R.id.imageButton6);
                    b.setImageResource(getImgId(s.symbolToInt()));
                    b.setTag(Integer.toString(s.symbolToInt()));
                    break;
                case 7:
                    b = (ImageButton) findViewById(R.id.imageButton7);
                    b.setImageResource(getImgId(s.symbolToInt()));
                    b.setTag(Integer.toString(s.symbolToInt()));
                    break;
            }
            i++;
        }
    }

    private void init_deck(){
        int i = 0;
        ImageView iv;
        for(DobbleSymbol s : dc.getCard()) {
            switch (i) {
                case 0:
                    initImv(R.id.imageView, s.symbolToInt());
                    break;
                case 1:
                    initImv(R.id.imageView1, s.symbolToInt());
                    break;
                case 2:
                    initImv(R.id.imageView2, s.symbolToInt());
                    break;
                case 3:
                    initImv(R.id.imageView3, s.symbolToInt());
                    break;
                case 4:
                    initImv(R.id.imageView4, s.symbolToInt());
                    break;
                case 5:
                    initImv(R.id.imageView5, s.symbolToInt());
                    break;
                case 6:
                    initImv(R.id.imageView6, s.symbolToInt());
                    break;
                case 7:
                    initImv(R.id.imageView7, s.symbolToInt());
                    break;
            }
            i++;
        }
    }

    public void checkDeck(View V){
        switch (V.getId()) {

            case (R.id.imageButton):
                checkContains(R.id.imageButton);
                break;

            case (R.id.imageButton1):
                checkContains(R.id.imageButton1);
                break;

            case (R.id.imageButton2):
                checkContains(R.id.imageButton2);
                break;

            case (R.id.imageButton3):
                checkContains(R.id.imageButton3);
                break;

            case (R.id.imageButton4):
                checkContains(R.id.imageButton4);
                break;

            case (R.id.imageButton5):
                checkContains(R.id.imageButton5);
                break;

            case (R.id.imageButton6):
                checkContains(R.id.imageButton6);
                break;

            case (R.id.imageButton7):
                checkContains(R.id.imageButton7);
                break;
        }

    }


    private void checkContains(int id){
        ImageButton b = (ImageButton) findViewById(id);

        if(dc.containsSymbol( b.getTag().toString())){
            System.out.println("Good move");
            selectedCorrect = true;
        }
        else{
            selectedCorrect = false;
            System.out.println("Task failed successfully !");
        }


    }

    public boolean getSelected(){
        return this.selectedCorrect;
    }

    private int getImgId(int i) {
        String sprite = "drawable/"+"icon__"+i+"_";
        return getResources().getIdentifier(sprite, null, getPackageName());
    }

    private void initImv(int id, int symb){
        ImageView iv;
        iv = (ImageView) findViewById(id);
        iv.setImageResource(getImgId(symb));
        iv.setTag(Integer.toString(symb));
    }

    public void changeCards(){
        this.dc.copyCard(player.getCard());
        this.player = new DobbleCard(1, dc);
        this.selectedCorrect = false;

        init_deck();
        init_player();
    }
}