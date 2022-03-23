package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    // 0 - o
    // 1 - x
    int activeplayer = 0;
    int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
    /*
    State meaning
    0 - o
    1 - x
    2 - null
     */
    // deside winer position (array)
    int[][] winPosition = {{0,1,2}, {3,4,5}, {6,7,8},
                           {0,3,6}, {1,4,7}, {2,5,8},
                           {0,4,8}, {2,4,6}};
    public void playertap(View view){
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            gameReset(view);
        }
        if(gamestate[tappedimage] == 2){
            gamestate[tappedimage] =  activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer == 0){
                img.setImageResource(R.drawable.x);
                activeplayer = 1;                                                         
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");

            }

            img.animate().translationXBy(1000f).setDuration(300);
        }
        // check any player has won
        for(int[] winPosition: winPosition) {
            if (gamestate[winPosition[0]] == gamestate[1] &&
                    gamestate[winPosition[1]] == gamestate[winPosition[2]] &&
                    gamestate[winPosition[0]] != 2) {
                // Somebody is won! - find out who!
                String winnerstr; // this is String that tell who is winner
                if (gamestate[winPosition[0]] == 0) {
                    winnerstr = "X has won";
                } else {
                    winnerstr = "O has won";
                }                                                                           
                // Update the status bar for winner
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);

            }

        public void gameReset(View view){
                gameActive = true;
                activeplayer = 0;
                for(int i=0; i< gamestate.length; i++){
                    gamestate[i] = 2;
                }
                ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
                ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
                
            }

        @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
            }
}





























