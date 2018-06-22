package com.example.kitaro.informationcentertistr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView cardViewRobot,cardViewFood,cardViewAg,cardViewMat,cardViewHerb,cardViewEN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add image in toolbar
       

        //Binding widget
        cardViewAg = (CardView) findViewById(R.id.id_innoag);
        cardViewEN = (CardView) findViewById(R.id.id_innoen);
        cardViewFood = (CardView) findViewById(R.id.id_innofood);
        cardViewHerb = (CardView) findViewById(R.id.id_innoherb);
        cardViewMat = (CardView) findViewById(R.id.id_innomat);
        cardViewRobot = (CardView) findViewById(R.id.id_innorobot);

        //On click to Other windows(food,herb,mat ...)
        cardViewAg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,MainInnoAg.class));
                myIntent(0);
            }
        });
        cardViewEN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,MainInnoEN.class));
                myIntent(1);
            }
        });
        cardViewFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,MainInnoFood.class));
                myIntent(2);
            }
        });
        cardViewHerb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,MainInnoHerb.class));
                myIntent(3);
            }
        });
        cardViewMat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,MainInnoMat.class));
                myIntent(4);
            }
        });
        cardViewRobot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,MainInnoRobot.class));
                myIntent(5);
            }
        });


    }// Main Method

    private void myIntent(int index) {

        Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
        intent.putExtra("Index", index);
        startActivity(intent);
        //finish();

    }

    @Override
    public void onClick(View v) {
        Intent intent;

           }

}//Main Class
