package com.example.admin.lolnew1;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by admin on 17.06.2017.
 */

public class Points {
    public int promien;
    public int promienKwadrat;
    public int ilosc;
    public int pozycjaX;
    public int pozycjaY;
    public int kolor;

    Points(RexPaint rexPaint)
    {
        Random random=new Random();
        promien=random.nextInt(15)+10;
        promienKwadrat=promien*promien;
        ilosc=promien*20;
        pozycjaX=random.nextInt(rexPaint.mapaWidth*rexPaint.ileCzesciMapyX);
        pozycjaY=random.nextInt(rexPaint.mapaHeight*rexPaint.ileCzesciMapyY);
        kolor=random.nextInt();
    }
}
