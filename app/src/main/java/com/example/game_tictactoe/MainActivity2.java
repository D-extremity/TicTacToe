package com.example.game_tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {
ImageView imageView4 , imageView5,imageView6,imageView7,imageView8,imageView9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle("About me");
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);
    imageView4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            github();
        }
    });
    imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                instagram();
            }
        });
    imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinkedIn();
            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gmail();
            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gmail2();
            }
        });
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                discord();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    public void instagram()
    {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://instagram.com/the_extremity?igshid=MzRlODBiNWFlZA=="));
        startActivity(intent);
    }
    public void LinkedIn()
    {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.linkedin.com/in/satyam-shrivastav-217688254"));
        startActivity(intent);

    }
    public void github()
    {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://github.com/D-extremity"));
        startActivity(intent);

    }
    public void gmail()
    {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("mysatyam99@gmail.com"));
        startActivity(intent);

    }
    public void gmail2()
    {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("isatyam9211@gmail.com"));
        startActivity(intent);

    }
    public void discord()
    {
        Intent intent =new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://discordapp.com/users/836898582375825428"));
        startActivity(intent);

    }
}