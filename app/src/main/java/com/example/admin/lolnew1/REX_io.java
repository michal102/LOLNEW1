package com.example.admin.lolnew1;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.Window;

public class REX_io extends AppCompatActivity {

    RexPaint podgladRysowania;

    public Point size = new Point();
    public int width2 ;
    public int height2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_rex_io);

         Display display = getWindowManager().getDefaultDisplay();

         display.getSize(size);
         width2 = size.x;
        height2 = size.y;

        podgladRysowania = new RexPaint(this);
        setContentView(podgladRysowania);
        podgladRysowania.requestFocus();
    }



}
