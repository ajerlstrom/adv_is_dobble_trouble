package controller;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.dobbletrouble.MultiplayerLobbyActivity;
import com.example.dobbletrouble.StartDobbleActivity;

public class SwipeListener implements View.OnTouchListener{
    private final GestureDetector gestureDetector;
    Context context;
    StartDobbleActivity Act;
    MultiplayerLobbyActivity LobyAct;

    public SwipeListener(View mainView, StartDobbleActivity st) {
        this.Act = st;
        context = Act.getBaseContext();
        gestureDetector = new GestureDetector(context, new GestureListener());
        mainView.setOnTouchListener(this);
    }

    public SwipeListener(View mainView, MultiplayerLobbyActivity mpa){
        this.LobyAct = mpa;
        context = mpa.getBaseContext();
        gestureDetector = new GestureDetector(context, new GestureListener());
        mainView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    public class GestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            if(Act.getSelected()) return true;
            else return false;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                }
                else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                    result = true;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }
    void onSwipeRight() {
        Toast.makeText(context, "Wrong Swipe", Toast.LENGTH_LONG).show();
        this.onSwipe.swipeRight();
    }
    void onSwipeLeft() {
        Toast.makeText(context, "Wrong Swipe", Toast.LENGTH_LONG).show();
        this.onSwipe.swipeLeft();
    }
    void onSwipeTop() {
        Toast.makeText(context, "Nice Job !", Toast.LENGTH_LONG).show();
        this.Act.changeCards();
        this.onSwipe.swipeTop();

    }
    void onSwipeBottom() {
        Toast.makeText(context, "Meh", Toast.LENGTH_LONG).show();
        this.onSwipe.swipeBottom();
    }
    interface onSwipeListener {
        void swipeRight();
        void swipeTop();
        void swipeBottom();
        void swipeLeft();
    }
    onSwipeListener onSwipe;
}

