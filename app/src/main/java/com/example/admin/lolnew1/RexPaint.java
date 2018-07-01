package com.example.admin.lolnew1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RexPaint extends View implements View.OnTouchListener {


    List<Points> punktyNaMapie = new ArrayList<Points>();
    Paint pedzel = new Paint();
    Bitmap rexHead;
    Bitmap pasekE;
    Bitmap pasekF;
    Bitmap rexWater;
    Bitmap[][] mapaCz;
    //Bitmap mapaCz2;
    Bitmap joysticksmall;
    Bitmap joystickbig;
    Punkty punkt1 = new Punkty();

    Punkty pozycjaJS = new Punkty();
    Punkty pozycjaJB = new Punkty();
    Punkty pozycjeRex=new Punkty();;
    Punkty pozycjeMapa=new Punkty();

    double speedRexX;
    double speedRexY;

    int ileCzesciMapyX;
    int ileCzesciMapyY;

    int width ;
    int height;

    int mapaWidth;
    int mapaHeight;

    int rexWidth;
    int rexHeight;

    int widthJoystickbig;
    int heightJoystickbig;

    boolean joystickAktywny=false;

    int counter;

    int obr;

    int ktoraMapaXOstatnia;
    int ktoraMapaYOstatnia;

    boolean animacjaXPrawo=false;

    int ilePoints=0;
    int ktoryLevel=1;
    int ilePointsDoLvl=10000;
    int ilePointsDoLvlPoprzedni=0;



    Handler timerHandler = new Handler() ;
    Runnable timerRunnable = new Runnable() {


        @Override
        public void run() {

            //int seconds = (int) (millis / 1000);
            //int minutes = seconds / 60;
            //seconds = seconds % 60;

//            if( speedRexX>0 ) {
//                pozycjeRex.x += speedRexX;
//                if(pozycjeRex.x>width-rexWidth)
//                {
//
//                    pozycjeMapa.x+=width-rexWidth;
//                    if(pozycjeMapa.x>(ileCzesciMapyX-1)*1920-10)
//                    {
//                        pozycjeRex.x=width-rexWidth;
//                        pozycjeMapa.x=(ileCzesciMapyX-1)*1920-10;
//
//                    }
//                    else
//                    {
//                        pozycjeRex.x=0;
//                    }
//
//                }
//                //pozycjeMapa.x+= speedRexX;
//            }
//            else
//            {
//                pozycjeRex.x += speedRexX;
//                if(pozycjeRex.x<0)
//                {
//
//                    pozycjeMapa.x-=width-rexWidth;
//                    if(pozycjeMapa.x<0)
//                    {
//                        pozycjeRex.x=0;
//                        pozycjeMapa.x=0;
//
//                    }
//                    else
//                    {
//                        pozycjeRex.x=width-rexWidth;
//                    }
//
//                }
//            }

            /*if( speedRexX>0 ) {
                pozycjeRex.x += speedRexX;
                if(animacjaXPrawo==true)
                {
                    animacjaXPrawo=true;

                    pozycjeMapa.x+=15;
                    pozycjeRex.x -=15;
                    if(pozycjeMapa.x>(ileCzesciMapyX-1)*1920-10)
                    {
                        pozycjeRex.x=width-rexWidth;
                        pozycjeMapa.x=(ileCzesciMapyX-1)*1920-10;

                    }
                    else
                    {
                        //pozycjeRex.x=0;
                    }
                }
                else
                {
                    if(pozycjeRex.x>width-rexWidth)
                    {
                        animacjaXPrawo=true;

                        pozycjeMapa.x+=15;
                        pozycjeRex.x -=15;
                        if(pozycjeMapa.x>(ileCzesciMapyX-1)*1920-10)
                        {
                            pozycjeRex.x=width-rexWidth;
                            pozycjeMapa.x=(ileCzesciMapyX-1)*1920-10;

                        }
                        else
                        {
                            //pozycjeRex.x=0;
                        }

                    }
                }



                //pozycjeMapa.x+= speedRexX;
            }
            else if( speedRexX<0 )
            {
                pozycjeRex.x += speedRexX;
                if(pozycjeRex.x<0)
                {

                    pozycjeMapa.x-=width-rexWidth;
                    if(pozycjeMapa.x<0)
                    {
                        pozycjeRex.x=0;
                        pozycjeMapa.x=0;

                    }
                    else
                    {
                        pozycjeRex.x=width-rexWidth;
                    }

                }
            }
            else
            {
                animacjaXPrawo=false;
            }*/

            if((pozycjeRex.x>width/2-rexWidth && speedRexX>0)|| (pozycjeRex.x<width/2-rexWidth && speedRexX<0)) {

                if(speedRexX>0)
                {
                    if(pozycjeMapa.x+speedRexX>(ileCzesciMapyX - 1) * width - 10)
                    {
                        pozycjeMapa.x=(ileCzesciMapyX - 1) * width - 10;
                        if(pozycjeRex.x+speedRexX<width-rexWidth)
                        {
                            pozycjeRex.x+= speedRexX;
                        }
                        else
                        {
                            pozycjeRex.x=width-rexWidth;
                        }
                    }
                    else
                    {
                        pozycjeMapa.x += speedRexX;
                    }
                }
                if(speedRexX<0)
                {
                    if(pozycjeMapa.x+speedRexX<0)
                    {
                        if(pozycjeRex.x+speedRexX>0)
                        {
                            pozycjeRex.x+= speedRexX;
                        }
                        else
                        {
                            pozycjeRex.x=0;
                        }
                    }
                    else
                    {
                        pozycjeMapa.x += speedRexX;
                    }
                }
                else
                {

                }


            }
            else
            {
                if(speedRexX>0)
                {
                    if(pozycjeRex.x+speedRexX<width )
                    {
                        pozycjeRex.x+= speedRexX;
                    }
                    else
                    {
                        pozycjeRex.x=width;
                    }
                }
                else if(speedRexX<0)
                {
                    if(pozycjeRex.x+speedRexX>0 )
                    {
                        pozycjeRex.x+= speedRexX;
                    }
                    else
                    {
                        pozycjeRex.x=0;
                    }
                }
                else
                {

                }

            }
            //tutaj y

            if((pozycjeRex.y>height/2-rexHeight && speedRexY>0)|| (pozycjeRex.y<height/2-rexHeight && speedRexY<0)) {

                if(speedRexY>0)
                {
                    if(pozycjeMapa.y+speedRexY>(ileCzesciMapyY - 1) * height - 10)
                    {
                        if(pozycjeRex.y+speedRexY<height-rexHeight*1.75)
                        {
                            pozycjeRex.y+= speedRexY;
                        }
                        else
                        {
                            pozycjeRex.y=height-rexHeight*1.75f;
                        }
                    }
                    else
                    {
                        pozycjeMapa.y += speedRexY;
                    }
                }
                if(speedRexY<0)
                {
                    if(pozycjeMapa.y+speedRexY<0)
                    {
                        if(pozycjeRex.y+speedRexY>0)
                        {
                            pozycjeRex.y+= speedRexY;
                        }
                        else
                        {
                            pozycjeRex.y=0;
                        }
                    }
                    else
                    {
                        pozycjeMapa.y += speedRexY;
                    }
                }
                else
                {

                }


            }
            else
            {
                if(speedRexY>0)
                {
                    if(pozycjeRex.y+speedRexY<height )
                    {
                        pozycjeRex.y+= speedRexY;
                    }
                    else
                    {
                        pozycjeRex.y=height;
                    }
                }
                else if(speedRexY<0)
                {
                    if(pozycjeRex.y+speedRexY>0 )
                    {
                        pozycjeRex.y+= speedRexY;
                    }
                    else
                    {
                        pozycjeRex.y=0;
                    }
                }
                else
                {

                }

            }

            float pozycjaRexNaMapieX=pozycjeRex.x+pozycjeMapa.x+rexWidth/2;
            float pozycjaRexNaMapieY=pozycjeRex.y+pozycjeMapa.y+rexHeight/2;

            for(int i=0;i<punktyNaMapie.size();i++)
            {
                if(Math.pow( pozycjaRexNaMapieX-punktyNaMapie.get(i).pozycjaX,2.0)
                        +Math.pow( pozycjaRexNaMapieY-punktyNaMapie.get(i).pozycjaY,2.0)<punktyNaMapie.get(i).promienKwadrat+7000)
                {
                    ilePoints=ilePoints+punktyNaMapie.get(i).ilosc;

                    punktyNaMapie.remove(i);
                }
            }

            if(ilePoints>ilePointsDoLvl)
            {
                int tymczasowaIlePointsToLvl=ilePointsDoLvl;

                ilePointsDoLvl=ilePointsDoLvl+((ilePointsDoLvl-ilePointsDoLvlPoprzedni)+1500);

                ilePointsDoLvlPoprzedni=tymczasowaIlePointsToLvl;

                ktoryLevel++;
            }




            counter++;
            invalidate();

            timerHandler.postDelayed(this, 17);
        }
    };

    Handler timerHandlerpunkty = new Handler() ;
    Runnable timerRunnablepunkty = new Runnable() {


        @Override
        public void run() {

            for (int i=0;i<5;i++)
            {
                Points points=new Points(rexPaint);
                punktyNaMapie.add(points);
            }

            timerHandlerpunkty.postDelayed(this, 5000);
        }
    };

    RexPaint rexPaint;

    public RexPaint(Context context){
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);

        this.setOnTouchListener(this);

        ktoraMapaXOstatnia=0;
        ktoraMapaYOstatnia=0;

        obr=0;
        ileCzesciMapyX=4;
        ileCzesciMapyY=4;

        rexPaint=this;

        mapaCz=new Bitmap[ileCzesciMapyX][ileCzesciMapyY];
        //mapaCz=new Bitmap[2][2];

        pedzel.setColor(Color.YELLOW);
        pedzel.setAntiAlias(true);


        counter=0;

        width = this.getResources().getDisplayMetrics().widthPixels;
        height = this.getResources().getDisplayMetrics().heightPixels;

        pozycjaJS.x= (float)(width*0.781);
        pozycjaJS.y=(float)(height*0.55555);
        pozycjaJB.x= (float)(width*0.781);
        pozycjaJB.y=(float)(height*0.55555);

        widthJoystickbig= (int)(width*0.182);
        heightJoystickbig=(int)(height*0.324);

        //
        pozycjeRex.x=0;
        pozycjeRex.y=0;
        //pozycjeRex.x=(int)(width*0.5)-(int)(width*0.035);
        //pozycjeRex.y=(int)(height*0.5)-(int)(height*0.035);

        pozycjeMapa.x=0;
        pozycjeMapa.y=0;

        rexHeight=(int)(height*0.10);
        rexWidth=(int)(width*0.07);

        mapaWidth=(int)(width);
        mapaHeight=(int)(height);

        rexHead= BitmapFactory.decodeResource(getResources(),R.drawable.rex_io_paint_all);
        rexWater= BitmapFactory.decodeResource(getResources(),R.drawable.rex_water);
        joysticksmall= BitmapFactory.decodeResource(getResources(),R.drawable.joysticksmall);
        joystickbig= BitmapFactory.decodeResource(getResources(),R.drawable.joystickbig);
        pasekE= BitmapFactory.decodeResource(getResources(),R.drawable.pasek_e);
        pasekF= BitmapFactory.decodeResource(getResources(),R.drawable.pasek_f);
        rexHead=Bitmap.createScaledBitmap(rexHead,rexWidth,rexHeight,true);
        pasekE=Bitmap.createScaledBitmap(pasekE,(int)(width*0.6f),(int)(height*0.15f),true);
        pasekF=Bitmap.createScaledBitmap(pasekF,(int)(width*0.6f),(int)(height*0.15f),true);
        rexWater=Bitmap.createScaledBitmap(rexWater,rexWidth,rexHeight,true);
        joysticksmall=Bitmap.createScaledBitmap(joysticksmall,(int)(width*0.182),(int)(height*0.324),true);
        joystickbig=Bitmap.createScaledBitmap(joystickbig,widthJoystickbig,heightJoystickbig,true);
        mapaCz[0][0]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_1);
        mapaCz[0][0]=Bitmap.createScaledBitmap(mapaCz[0][0],mapaWidth,mapaHeight,true);
        mapaCz[1][0]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_2);
        mapaCz[1][0]=Bitmap.createScaledBitmap(mapaCz[1][0],mapaWidth,mapaHeight,true);
        mapaCz[2][0]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_3);
        mapaCz[2][0]=Bitmap.createScaledBitmap(mapaCz[2][0],mapaWidth,mapaHeight,true);
        mapaCz[3][0]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_4);
        mapaCz[3][0]=Bitmap.createScaledBitmap(mapaCz[3][0],mapaWidth,mapaHeight,true);

        /*for(int i=3;i<ileCzesciMapyX;i++)
        {
            mapaCz[i][0]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_3);
            mapaCz[i][0]=Bitmap.createScaledBitmap(mapaCz[i][0],mapaWidth,mapaHeight,true);
        }
        for(int i=3;i<ileCzesciMapyX;i++)
        {
            mapaCz[i][1]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_3);
            mapaCz[i][1]=Bitmap.createScaledBitmap(mapaCz[i][1],mapaWidth,mapaHeight,true);
        }
        for(int i=0;i<ileCzesciMapyX;i++)
        {
            for(int j=2;j<ileCzesciMapyY;j++)
            {
                mapaCz[i][j]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_3);
                mapaCz[i][j]=Bitmap.createScaledBitmap(mapaCz[i][j],mapaWidth,mapaHeight,true);
            }

        }*/


        mapaCz[0][1]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_5);
        mapaCz[0][1]=Bitmap.createScaledBitmap(mapaCz[0][1],mapaWidth,mapaHeight,true);
        mapaCz[1][1]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_6);
        mapaCz[1][1]=Bitmap.createScaledBitmap(mapaCz[1][1],mapaWidth,mapaHeight,true);
        mapaCz[2][1]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_7);
        mapaCz[2][1]=Bitmap.createScaledBitmap(mapaCz[2][1],mapaWidth,mapaHeight,true);
        mapaCz[3][1]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_8);
        mapaCz[3][1]=Bitmap.createScaledBitmap(mapaCz[3][1],mapaWidth,mapaHeight,true);

        mapaCz[0][2]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_9);
        mapaCz[0][2]=Bitmap.createScaledBitmap(mapaCz[0][2],mapaWidth,mapaHeight,true);
        mapaCz[1][2]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_10);
        mapaCz[1][2]=Bitmap.createScaledBitmap(mapaCz[1][2],mapaWidth,mapaHeight,true);
        mapaCz[2][2]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_11);
        mapaCz[2][2]=Bitmap.createScaledBitmap(mapaCz[2][2],mapaWidth,mapaHeight,true);
        mapaCz[3][2]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_12);
        mapaCz[3][2]=Bitmap.createScaledBitmap(mapaCz[3][2],mapaWidth,mapaHeight,true);

        mapaCz[0][3]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_13);
        mapaCz[0][3]=Bitmap.createScaledBitmap(mapaCz[0][3],mapaWidth,mapaHeight,true);
        mapaCz[1][3]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_14);
        mapaCz[1][3]=Bitmap.createScaledBitmap(mapaCz[1][3],mapaWidth,mapaHeight,true);
        mapaCz[2][3]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_15);
        mapaCz[2][3]=Bitmap.createScaledBitmap(mapaCz[2][3],mapaWidth,mapaHeight,true);
        mapaCz[3][3]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_16);
        mapaCz[3][3]=Bitmap.createScaledBitmap(mapaCz[3][3],mapaWidth,mapaHeight,true);

        Random random=new Random();
        int ilePunktow=random.nextInt(100)+100;
        for (int i=0;i<ilePunktow;i++)
        {
            Points points=new Points(this);
            punktyNaMapie.add(points);
        }


        timerHandler.postDelayed(timerRunnable, 0);
        timerHandlerpunkty.postDelayed(timerRunnablepunkty, 0);
    }

    @Override
    public void onDraw(Canvas canvas){
        /*Punkty punkt2;
        int i=0;
        if(punkty.size()!=0) {
            punkt2 = punkty.get(0);
            for (Punkty pedzel : punkty) {
                canvas.drawLine(pedzel.x, pedzel.y, punkt2.x, punkt2.y, pedzel);


                punkt2 = punkty.get(i);
                i++;
            }
        }*/

        //DisplayMetrics metrics = context.getResources().getDisplayMetrics();
       // int width = metrics.widthPixels;
        //int height = metrics.heightPixels;

        //DisplayMetrics metrics = new DisplayMetrics();
        //this.GetWindowManager().getDefaultDisplay().getRealMetrics(metrics);

        pedzel.setColor(Color.YELLOW);

        int ktoraMapaX=(int)(pozycjeMapa.x/(mapaWidth));
        int ktoraMapaY=(int)(pozycjeMapa.y/(mapaHeight));

        /*if(ktoraMapaXOstatnia!=ktoraMapaX)
        {
            if(ktoraMapaXOstatnia>ktoraMapaX)
            {
                mapaCz[1][0].recycle();
                mapaCz[1][1].recycle();
                mapaCz[1][0]=null;
                mapaCz[1][1]=null;
                mapaCz[1][0]=mapaCz[0][0];
                mapaCz[1][1]=mapaCz[0][1];
                mapaCz[0][0]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_1);
                mapaCz[0][0]=Bitmap.createScaledBitmap(mapaCz[0][0],mapaWidth,mapaHeight,true);
                mapaCz[0][1]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_5);
                mapaCz[0][1]=Bitmap.createScaledBitmap(mapaCz[0][1],mapaWidth,mapaHeight,true);

            }
            else
            {
                mapaCz[0][0].recycle();
                mapaCz[0][1].recycle();
                mapaCz[0][0]=null;
                mapaCz[0][1]=null;
                mapaCz[0][0]=mapaCz[1][0];
                mapaCz[0][1]=mapaCz[1][1];
                mapaCz[1][0]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_3);
                mapaCz[1][0]=Bitmap.createScaledBitmap(mapaCz[1][0],mapaWidth,mapaHeight,true);
                mapaCz[1][1]= BitmapFactory.decodeResource(getResources(),R.drawable.mapa_cz_7);
                mapaCz[1][1]=Bitmap.createScaledBitmap(mapaCz[1][1],mapaWidth,mapaHeight,true);
            }
            ktoraMapaXOstatnia=ktoraMapaX;
        }*/


        canvas.drawBitmap(mapaCz[ktoraMapaX][ktoraMapaY],
                //canvas.drawBitmap(mapaCz[0][0],
                new Rect((int)pozycjeMapa.x-(mapaWidth*ktoraMapaX),
                        (int)pozycjeMapa.y-(mapaHeight*ktoraMapaY),
                        width,
                        height),
                new Rect(0,
                        0,
                        width-((int)pozycjeMapa.x-(mapaWidth*ktoraMapaX)),
                        height-((int)pozycjeMapa.y-(mapaHeight*ktoraMapaY))),null);
        canvas.drawBitmap(mapaCz[ktoraMapaX+1][ktoraMapaY+1],
                //canvas.drawBitmap(mapaCz[1][1],
                new Rect(0,
                        0,
                        (int)pozycjeMapa.x-(mapaWidth*ktoraMapaX),
                        (int)pozycjeMapa.y-(mapaHeight*ktoraMapaY)),
                new Rect(width-((int)pozycjeMapa.x-(mapaWidth*ktoraMapaX)),
                        height-((int)pozycjeMapa.y-(mapaHeight*ktoraMapaY)),
                        width,
                        height),null);

        canvas.drawBitmap(mapaCz[ktoraMapaX+1][ktoraMapaY],
                //canvas.drawBitmap(mapaCz[1][0],
                new Rect(0,
                        (int)pozycjeMapa.y-(mapaHeight*ktoraMapaY),
                        (int)pozycjeMapa.x-(mapaWidth*ktoraMapaX),
                        height),
                new Rect(width-((int)pozycjeMapa.x-(mapaWidth*ktoraMapaX)),
                        0,
                        width,
                        height-((int)pozycjeMapa.y-(mapaHeight*ktoraMapaY))),null);
        canvas.drawBitmap(mapaCz[ktoraMapaX][ktoraMapaY+1],
                //canvas.drawBitmap(mapaCz[0][1],
                new Rect((int)pozycjeMapa.x-(mapaWidth*ktoraMapaX),
                        0,
                        width,
                        (int)pozycjeMapa.y-(mapaHeight*ktoraMapaY)),
                new Rect(0,
                        height-((int)pozycjeMapa.y-(mapaHeight*ktoraMapaY)),
                        width-((int)pozycjeMapa.x-(mapaWidth*ktoraMapaX)),
                        height),null);


        for(int i=0;i<punktyNaMapie.size();i++)
        {
            if(punktyNaMapie.get(i).pozycjaX<pozycjeMapa.x+width
            && punktyNaMapie.get(i).pozycjaX>pozycjeMapa.x
            && punktyNaMapie.get(i).pozycjaY<pozycjeMapa.y+height
                    && punktyNaMapie.get(i).pozycjaY>pozycjeMapa.y
                    )
            {
                canvas.drawCircle(punktyNaMapie.get(i).pozycjaX-pozycjeMapa.x,
                        punktyNaMapie.get(i).pozycjaY-pozycjeMapa.y
                ,punktyNaMapie.get(i).promien, pedzel);
            }

        }


        pedzel.setColor(Color.BLUE);
        pedzel.setAlpha(255);
        pedzel.setTextSize(30);
        canvas.drawText(Integer.toString(ilePoints),width/2,height*3/4, pedzel);

        //canvas.drawBitmap(pasekE,width*0.2f,height*4/5,pedzel);
        canvas.drawBitmap(pasekE, new Rect(0,0,(int)(getWidth()),getHeight()),new Rect((int)(width*0.2f),(int)(height*4/5),(int)(width*0.8),height*95/100),pedzel);

        pedzel.setAlpha(128);

        float procent=(float)(ilePoints-ilePointsDoLvlPoprzedni)/(float)(ilePointsDoLvl-ilePointsDoLvlPoprzedni);
        //canvas.drawBitmap(pasekF, null,new Rect((int)(width*0.2f),(int)(height*4/5),(int)(width*0.8f),height),pedzel);
        //canvas.drawBitmap(pasekF, new Rect(0,0,pasekF.getWidth(),pasekF.getHeight()),new Rect((int)(width*0.2f),(int)(height*4/5),(int)(width*0.8f),height),pedzel);
        canvas.drawText("LVL.",width/3,height*3/4, pedzel);
        pedzel.setTextSize(50);
        canvas.drawText(Integer.toString(ktoryLevel),width/3+width*5/100,height*3/4, pedzel);
        //canvas.drawBitmap(pasekF,width*0.2f,height*4/5,pedzel);
        canvas.drawBitmap(pasekF, new Rect(0,0,(int)(getWidth()*procent),getHeight()),new Rect((int)(width*0.2f),(int)(height*4/5),(int)(width*0.2+width*0.6f*procent),height*95/100),pedzel);
        //canvas.drawOval(100,100,1600,150,pedzel);

        //
        if(speedRexX<0) {
            Matrix m = new Matrix();
// Mirror is basically a rotation
            m.setScale(-1, 1);
// so you got to move your bitmap back to it's place. otherwise you will not see it
            m.postTranslate(pozycjeRex.x+(float)rexWidth*1.0f, pozycjeRex.y);
            if(pozycjeMapa.x>5748)
            {
                canvas.drawBitmap(rexWater, m, null);
            }
            else
                canvas.drawBitmap(rexHead, m, null);
        }
        else if(speedRexX>0)
        {
            if(pozycjeMapa.x>5748)
            {
                canvas.drawBitmap(rexWater,pozycjeRex.x,pozycjeRex.y,null);
            }
            else
            canvas.drawBitmap(rexHead,pozycjeRex.x,pozycjeRex.y,null);
        }
        else{
            if(obr==0)
            {
                if(pozycjeMapa.x>5748)
                {
                    canvas.drawBitmap(rexWater,pozycjeRex.x,pozycjeRex.y,null);
                }
                else
                canvas.drawBitmap(rexHead,pozycjeRex.x,pozycjeRex.y,null);
            }
            else
            {
                Matrix m = new Matrix();
// Mirror is basically a rotation
                m.setScale(-1, 1);
// so you got to move your bitmap back to it's place. otherwise you will not see it
                m.postTranslate(pozycjeRex.x+(float)rexWidth*1.0f, pozycjeRex.y);
                if(pozycjeMapa.x>57480)
                {
                    canvas.drawBitmap(rexWater, m, null);
                }
                else
                canvas.drawBitmap(rexHead, m, null);
            }

        }



        canvas.drawBitmap(joystickbig,pozycjaJB.x,pozycjaJB.y,null);
        canvas.drawBitmap(joysticksmall,pozycjaJS.x,pozycjaJS.y,null);
        //canvas.drawText(Integer.toString(ktoraMapaX),200,100,pedzel);
        //canvas.drawText(Float.toString(pozycjeMapa.x)+" "+Float.toString(mapaWidth),200,100, pedzel);

       // canvas.drawText(Integer.toString(int),100,100,pedzel);
    }

    public boolean onTouch(View view, MotionEvent event){
       // Punkty punkt1 = new Punkty();
        punkt1.x = event.getX();
        punkt1.y = event.getY();

        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            if(pozycjaJB.x-(event.getX()-widthJoystickbig/2)<widthJoystickbig/2 && (event.getX()-widthJoystickbig/2)-pozycjaJB.x<widthJoystickbig/2
                    && pozycjaJB.y-(event.getY()-widthJoystickbig/2)<widthJoystickbig/2 && (event.getY()-widthJoystickbig/2)-pozycjaJB.y<widthJoystickbig/2 )
            {
                joystickAktywny=true;
                pozycjaJS.x=event.getX()-widthJoystickbig/2;
                pozycjaJS.y=event.getY()-widthJoystickbig/2;

                speedRexX=(pozycjaJS.x-pozycjaJB.x)/25;
                speedRexY=(pozycjaJS.y-pozycjaJB.y)/25;

                if(speedRexX>0)
                {
                    obr=0;
                }
                else
                {
                    obr=1;
                }
            }
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE)
        {
            if(joystickAktywny==true && pozycjaJB.x-(event.getX()-widthJoystickbig/2)<widthJoystickbig/2 && (event.getX()-widthJoystickbig/2)-pozycjaJB.x<widthJoystickbig/2
                    && pozycjaJB.y-(event.getY()-widthJoystickbig/2)<widthJoystickbig/2 && (event.getY()-widthJoystickbig/2)-pozycjaJB.y<widthJoystickbig/2 &&
            (pozycjaJB.x-(event.getX()-widthJoystickbig/2))*(pozycjaJB.x-(event.getX()-widthJoystickbig/2)) +
                    (pozycjaJB.y-(event.getY()-widthJoystickbig/2))*(pozycjaJB.y-(event.getY()-widthJoystickbig/2))<=((float)widthJoystickbig/2)*((float)widthJoystickbig/2))
            {

                pozycjaJS.x=event.getX()-widthJoystickbig/2;
                pozycjaJS.y=event.getY()-widthJoystickbig/2;

                speedRexX=(pozycjaJS.x-pozycjaJB.x)/25;
                speedRexY=(pozycjaJS.y-pozycjaJB.y)/25;

                if(speedRexX>0)
                {
                    obr=0;
                }
                else
                {
                    obr=1;
                }
            }

            if(joystickAktywny==true &&( pozycjaJB.x-(event.getX()-widthJoystickbig/2)>widthJoystickbig/2 || (event.getX()-widthJoystickbig/2)-pozycjaJB.x>widthJoystickbig/2
                    || pozycjaJB.y-(event.getY()-widthJoystickbig/2)>widthJoystickbig/2 || (event.getY()-widthJoystickbig/2)-pozycjaJB.y>widthJoystickbig/2 ))
            {
                double a=pozycjaJB.y+widthJoystickbig/2 -event.getY();
                double b=pozycjaJB.x+widthJoystickbig/2 -event.getX();
                double przecwProstokatna=Math.sqrt(a*a+b*b);
                double sinus=-a/przecwProstokatna;
                double cosinus=-b/przecwProstokatna;

                pozycjaJS.x=pozycjaJB.x+(int)(cosinus*((double)widthJoystickbig/2));
                pozycjaJS.y=pozycjaJB.y+(int)(sinus*((double)widthJoystickbig/2));

                speedRexX=(pozycjaJS.x-pozycjaJB.x)/25;
                speedRexY=(pozycjaJS.y-pozycjaJB.y)/25;

                if(speedRexX>0)
                {
                    obr=0;
                }
                else
                {
                    obr=1;
                }

            }
        }
        if (event.getAction() == MotionEvent.ACTION_UP)
        {
            joystickAktywny=false;
            pozycjaJS.x= (float)(width*0.781);
            pozycjaJS.y=(float)(height*0.55555);

            speedRexX=0;
            speedRexY=0;
        }




        //punkty.add(punkt1);

       // Log.d(TAG, "pedzel: " + punkt1);
        return true;
    }

    class Punkty extends Paint {
        float x,y;

        @Override
        public String toString(){
            return x + ", " + y;
        }
    }

}