package com.example.admin.lolnew1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Debug;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Random;

public class LolActivity extends AppCompatActivity {

    //Deklaracja zmiennych
    Button store;
    //Button przycisk1;
    Button heart_plus;
    Button event_s;
    SharedPreferences preferences;
    TextView score;
    TextView heart_i;
    TextView heart_ti;
    ImageView hearthImage;
    EditText cheatLine;

    int wartosc = 0;
    int i_heart = 0;
    int coin = 1;

    Button reset;


    //Metoda uruchamiana przy starcie aplikacji
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lol);

        store = (Button) findViewById(R.id.store);
        event_s = (Button) findViewById(R.id.event_s);
        //przycisk1=(Button) findViewById(R.id.button);
        score = (TextView) findViewById(R.id.cliker);
        reset = (Button) findViewById(R.id.reset);

        heart_i = (TextView) findViewById(R.id.heart_i);
        heart_ti = (TextView) findViewById(R.id.heart_ti);
        heart_plus = (Button) findViewById(R.id.heart_plus);
        hearthImage = (ImageView) findViewById(R.id.heartimage);

        cheatLine = (EditText) findViewById(R.id.editText);


        preferences = getSharedPreferences("save", Activity.MODE_PRIVATE);

        loadData();

        //cheatLine.set


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                reset.setBackgroundColor(random.nextInt());

                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog alert = new AlertDialog.Builder(LolActivity.this).create();

                // 2. Chain together various setter methods to set the dialog characteristics
                alert.setMessage("jesteś pewny aby usunąć twój wynik?");
                alert.setTitle("reset_alert");

                alert.setButton(AlertDialog.BUTTON_POSITIVE, "tak",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                wartosc = 0;
                                i_heart = 0;
                                score.setText(Integer.toString(wartosc));
                                heart_i.setText(Integer.toString(i_heart));
                                coin = 1;


                                SharedPreferences.Editor preferencesEditor = preferences.edit();
                                preferencesEditor.putInt("punkty", wartosc);
                                preferencesEditor.putInt("coin", coin);
                                preferencesEditor.putInt("il_heart", i_heart);
                                preferencesEditor.commit();
                            }
                        });

                alert.setButton(AlertDialog.BUTTON_NEGATIVE, "nie",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });


                alert.show();


            }
        });

        heart_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int rand = random.nextInt() % 5;
                switch (rand) {
                    case 0:
                        heart_plus.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                        break;
                    case 1:
                        heart_plus.setBackgroundColor(getResources().getColor(R.color.pink1));
                        break;
                    case 2:
                        heart_plus.setBackgroundColor(getResources().getColor(R.color.pink2));
                        break;
                    case 3:
                        heart_plus.setBackgroundColor(getResources().getColor(R.color.pink3));
                        break;
                    case 4:
                        heart_plus.setBackgroundColor(getResources().getColor(R.color.pink4));
                        break;
                }

                i_heart += 1;
                heart_i.setText(Integer.toString(i_heart));

                SharedPreferences.Editor preferencesEditor = preferences.edit();
                preferencesEditor.putInt("il_heart", i_heart);
                preferencesEditor.commit();
            }
        });

        /*przycisk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random =new Random();
                przycisk1.setBackgroundColor(random.nextInt());
                wartosc=wartosc+coin;
                score.setText(Integer.toString(wartosc));

                SharedPreferences.Editor preferencesEditor = preferences.edit();
                preferencesEditor.putInt("punkty", wartosc);
                preferencesEditor.commit();
            }
        });*/
        store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ubdate_activity.class);
                startActivityForResult(intent, 0);
            }
        });
        event_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), event_activity.class);
                startActivityForResult(intent, 0);
            }
        });

        /*przycisk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random =new Random();
                przycisk1.setBackgroundColor(random.nextInt());
                wartosc=wartosc+coin;
                score.setText(Integer.toString(wartosc));

                SharedPreferences.Editor preferencesEditor = preferences.edit();
                preferencesEditor.putInt("punkty", wartosc);
                preferencesEditor.commit();
            }
        });*/
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            Random random = new Random();

            wartosc = wartosc + coin;
            score.setText(Integer.toString(wartosc));

            SharedPreferences.Editor preferencesEditor = preferences.edit();
            preferencesEditor.putInt("punkty", wartosc);
            preferencesEditor.commit();
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        loadData();

        //Toast toast = Toast.makeText(getApplicationContext(), "jesteś pewny aby usunąć twój wynik" ,Toast.LENGTH_LONG);
        //toast.show();
    }

    private void loadData() {
        Date date = new Date();
        wartosc = preferences.getInt("punkty", 0);
        coin = preferences.getInt("coin", 1);
        i_heart = preferences.getInt("il_heart", 0);
        if (preferences.getBoolean("heart_view", false) == true &&
                //( date.getMonth()==2 && (date.getDate()>=1 && date.getDate()<=31)))
                (date.getMonth() == 1 && (date.getDate() >= 6 && date.getDate() <= 26))) {
            heart_plus.setVisibility(View.VISIBLE);
            heart_i.setVisibility(View.VISIBLE);
            heart_ti.setVisibility(View.VISIBLE);
            hearthImage.setVisibility(View.VISIBLE);

        } else {
            heart_plus.setVisibility(View.INVISIBLE);
            heart_i.setVisibility(View.INVISIBLE);
            heart_ti.setVisibility(View.INVISIBLE);
            hearthImage.setVisibility(View.INVISIBLE);
        }
        score.setText(Integer.toString(wartosc));
        heart_i.setText(Integer.toString(i_heart));

    }
}
