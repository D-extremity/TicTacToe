package com.example.game_tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

import java.util.Objects;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
String s1, s2, s3, s4, s5, s6, s7, s8, s9;
LottieAnimationView laview;
Toolbar toolbar;
MediaPlayer mediaplayer;
TextView textView;
int moves=0 , splay=1;
boolean game_over=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Animation layout=AnimationUtils.loadAnimation(this,R.anim.layout);
        Animation celeb=AnimationUtils.loadAnimation(this,R.anim.celebration);
        TableLayout table=findViewById(R.id.tableLayout);
        table.setAnimation(layout);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        laview=findViewById(R.id.celebratelayout);
        laview.setAnimation(R.raw.cele);
        laview.setAnimation(celeb);
mediaplayer=MediaPlayer.create(this,R.raw.win);
toolbar=findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
Objects.requireNonNull(getSupportActionBar()).setTitle("TicTacToe");
textView=findViewById(R.id.textView);

    }
    public void soundoff()
    {
        splay=0;
        textView.setText(R.string.volumeoff);
        Toast.makeText(this, "Game Sound is off", Toast.LENGTH_SHORT).show();
    }
    public void soundon()
    {
        splay=1;
        textView.setText(R.string.volumeon);
        Toast.makeText(this, "Game Sound is on", Toast.LENGTH_SHORT).show();

    }
    public void soundplay()
    {
        if(splay==1)
        {
            mediaplayer.start();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid=item.getItemId();
        if(itemid==R.id.volumeoff)
        {
            soundoff();

        }
        else if(itemid==R.id.volumeon)
        {
            soundon();

        }
        else
        {
            Intent intent=new Intent(this,MainActivity2.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

    public void result(View view)
    {
        if(!game_over) {
            Animation blink= AnimationUtils.loadAnimation(this,R.anim.scale);
            Button thisButton = (Button) view;
            //thisbutton knows which button is pressed
            if (thisButton.getText().toString().length() != 0) {
                Toast.makeText(this, "play your turn on unfilled checks", Toast.LENGTH_SHORT).show();
            } else {
                if (moves % 2 == 0) {
                    thisButton.setText("X");
                } else {
                    thisButton.setText("0");
                }
                moves++;
                if (moves > 4) {

                    s1 = b1.getText().toString();
                    s2 = b2.getText().toString();
                    s3 = b3.getText().toString();
                    s4 = b4.getText().toString();
                    s5 = b5.getText().toString();
                    s6 = b6.getText().toString();
                    s7 = b7.getText().toString();
                    s8 = b8.getText().toString();
                    s9 = b9.getText().toString();

                    if (s1.equals(s2) && s2.equals(s3) && s1.length() != 0) {
                        Toast.makeText(this, "Person " + s1 + " wins ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        laview.playAnimation();
//                        mediaplayer.start();
                        soundplay();
                        b1.startAnimation(blink);
                        b2.startAnimation(blink);
                        b3.startAnimation(blink);
                        replay();
                    }
                    else if (s1.equals(s5) && s5.equals(s9) && s1.length() != 0) {
                        Toast.makeText(this, "Person " + s1 + " wins ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        soundplay();
                        laview.playAnimation();

                        b1.startAnimation(blink);
                        b5.startAnimation(blink);
                        b9.startAnimation(blink);
                        replay();
                    }
                   else  if (s1.equals(s4) && s4.equals(s7) && s1.length() != 0) {
                        Toast.makeText(this, "Person " + s1 + " wins ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        soundplay();
                        laview.playAnimation();

                        b1.startAnimation(blink);
                        b4.startAnimation(blink);
                        b7.startAnimation(blink);
                        replay();

                    }
                    else if (s5.equals(s2) && s2.equals(s8) && s2.length() != 0) {
                        Toast.makeText(this, "Person " + s2 + " wins ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        soundplay();
                        laview.playAnimation();

                        b5.startAnimation(blink);
                        b2.startAnimation(blink);
                        b8.startAnimation(blink);
                        replay();

                    }
                    else if (s6.equals(s3) && s3.equals(s9) && s3.length() != 0) {
                        Toast.makeText(this, "Person " + s6 + " wins ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        soundplay();
                        laview.playAnimation();

                        b6.startAnimation(blink);
                        b3.startAnimation(blink);
                        b9.startAnimation(blink);
                        replay();

                    }
                    else if (s4.equals(s5) && s5.equals(s6) && s4.length() != 0) {
                        Toast.makeText(this, "Person " + s4 + " wins ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        soundplay();
                        laview.playAnimation();

                        b4.startAnimation(blink);
                        b5.startAnimation(blink);
                        b6.startAnimation(blink);
                        replay();

                    }
                    else if (s7.equals(s8) && s8.equals(s9) && s9.length() != 0) {
                        Toast.makeText(this, "Person " + s7 + " wins ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        soundplay();
                        laview.playAnimation();

                        b7.startAnimation(blink);
                        b8.startAnimation(blink);
                        b9.startAnimation(blink);
                        replay();

                    }
                    else if (s7.equals(s5) && s5.equals(s3) && s3.length() != 0) {
                        Toast.makeText(this, "Person " + s7 + " wins ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        soundplay();
                        laview.playAnimation();

                        b7.startAnimation(blink);
                        b5.startAnimation(blink);
                        b3.startAnimation(blink);
                        replay();
                    }
                    else if (moves == 9) {
                        Toast.makeText(this, "Match Drew ", Toast.LENGTH_LONG).show();
                        game_over=true;
                        b1.startAnimation(blink);
                        b2.startAnimation(blink);
                        b3.startAnimation(blink);
                        b4.startAnimation(blink);
                        b5.startAnimation(blink);
                        b6.startAnimation(blink);
                        b7.startAnimation(blink);
                        b8.startAnimation(blink);
                        b9.startAnimation(blink);
                        replay();
                    }
                }
            }
        }
    }


    public void replay()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                b1.setText("");
                b2.setText("");
                b3.setText("");
                b4.setText("");
                b5.setText("");
                b6.setText("");
                b7.setText("");
                b8.setText("");
                b9.setText("");
                moves=0;
                game_over=false;
            }
        },4000);


    }
}