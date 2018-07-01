package com.example.admin.lolnew1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Date;
import java.util.Random;

public class ubdate_activity extends AppCompatActivity {
    Button uplus2;
    int wartosc;
    SharedPreferences preferences;
    TextView scoreupdate;
    int coin;
    Button exit;
    Button minigry_b;
    Button minigry_p;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubdate_activity);



        uplus2 = (Button) findViewById(R.id.uplus2);
        exit = (Button) findViewById(R.id.exit);
        minigry_b = (Button) findViewById(R.id.minigry_b);
        minigry_p = (Button) findViewById(R.id.minigry_p);

        preferences = getSharedPreferences("save", Activity.MODE_PRIVATE);

        wartosc = preferences.getInt("punkty", 0);
        coin = preferences.getInt("coin", 1);
        if(preferences.getBoolean("minigry", false))
        {
            minigry_p.setVisibility(View.VISIBLE);
        }
        else
        {
            minigry_p.setVisibility(View.INVISIBLE);
        }



        scoreupdate = (TextView) findViewById(R.id.scoreupdate);

        scoreupdate.setText(Integer.toString(wartosc));


        Date date = new Date();

        uplus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                uplus2.setBackgroundColor(random.nextInt());
                if (wartosc >= 100) {
                    wartosc = wartosc - 100;
                    coin = coin + 2;
                    scoreupdate.setText(Integer.toString(wartosc));
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("punkty", wartosc);
                    preferencesEditor.commit();
                    preferencesEditor.putInt("coin", coin);
                    preferencesEditor.commit();
                }
            }

        });
        minigry_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                minigry_b.setBackgroundColor(random.nextInt());
                if (wartosc >= 1000) {
                    wartosc = wartosc - 1000;

                    scoreupdate.setText(Integer.toString(wartosc));
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("punkty", wartosc);
                    preferencesEditor.commit();
                    preferencesEditor.putBoolean("minigry",true);
                    preferencesEditor.commit();
                    minigry_p.setVisibility(View.VISIBLE);

                }
            }

        });

        minigry_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), minigry.class);
                startActivityForResult(intent,0);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ubdate_activity Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
