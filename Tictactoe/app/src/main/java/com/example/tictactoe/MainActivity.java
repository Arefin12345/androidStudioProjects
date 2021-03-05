package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameactive = true;

//    0 = x
//    1 = O
//    2 = NULL

    int activeplayer = 0;

    int gamestate[] = {2,2,2,2,2,2,2,2,2};
    int winpositions[][] = {
                           {0,1,2},{3,4,5},{6,7,8},
                           {0,3,6},{1,4,7},{2,5,8},
                           {0,4,8},{2,4,6}

                      };


    public void playertap(View view){
        ImageView img  = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(!gameactive){
            gameReset(view);
        }

        if(gamestate[tappedImage] == 2 && gameactive){
            gamestate[tappedImage] = activeplayer;
            img.setTranslationY(-1000f);

            if(activeplayer == 0){
                img.setImageResource(R.drawable.xu);
                activeplayer = 1;

                //To print the turn
                TextView status = findViewById(R.id.status);

                //To change the turn of player
                status.setText("O's turn tap to play");
            }
            else {
                img.setImageResource(R.drawable.ou);
                activeplayer = 0;

                //To print the turn
                TextView status = findViewById(R.id.status);

                //To change the turn of player
                status.setText("X's turn tap to play");
            }

            img.animate().translationYBy(1000f).setDuration(100);
        }

//        Check if any player has won
        for(int winposition[] : winpositions){
            if(gamestate[winposition[0]] == gamestate[winposition[1]] &&
                    gamestate[winposition[1]] == gamestate[winposition[2]] &&
                    gamestate[winposition[0]] != 2
            )
            {
               //Somebody has won

                String winnerStr;
                gameactive = false;
                if(gamestate[winposition[0]] == 0){
                    winnerStr = "X Has Won";
                }

                else {
                    winnerStr = "Y Has Won";
                }

             //Update the status bar for winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }

        }


    }

    public void gameReset(View view) {
        gameactive = true;
        activeplayer = 0;
        for(int i = 0; i<gamestate.length;i++){
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

        //To print the turn
        TextView status = findViewById(R.id.status);

        //To change the turn of player
        status.setText("X's turn tap to play");

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
