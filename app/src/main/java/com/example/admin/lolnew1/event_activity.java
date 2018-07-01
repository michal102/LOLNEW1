package com.example.admin.lolnew1;

import android.app.Activity;
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

public class event_activity extends AppCompatActivity {
    int wartosc;
    SharedPreferences preferences;
    TextView p_1000;
    int coin;
    Button exit;
    Button heart;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_activity);

        preferences = getSharedPreferences("save", Activity.MODE_PRIVATE);

        wartosc = preferences.getInt("punkty", 0);
        coin = preferences.getInt("coin", 1);


        heart = (Button) findViewById(R.id.heart_u);
        exit = (Button) findViewById(R.id.exit2);
        p_1000 = (TextView) findViewById(R.id.textViewp1000);
        heart.setVisibility(View.INVISIBLE);
        p_1000.setVisibility(View.INVISIBLE);

        Date date = new Date();

        if(date.getMonth()==1 && (date.getDate()>=6 && date.getDate()<=26))
        //if(date.getMonth()==2 && (date.getDate()>=1 && date.getDate()<=31))
        {
            heart.setVisibility(View.VISIBLE);
            p_1000.setVisibility(View.VISIBLE);
        }

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wartosc >= 1000) {
                    wartosc = wartosc - 1000;

                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("punkty", wartosc);
                    preferencesEditor.commit();
                    preferencesEditor.putBoolean("heart_view", true);
                    preferencesEditor.commit();
                }
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
