package com.example.myapplication;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SwitchDayNight {
    ImageView img_moon;
    ImageView img_sun;
    RelativeLayout lo_s;
    RelativeLayout lo_m;
    RelativeLayout lo_bg_ma;
    AppCompatActivity ct;
    View.OnClickListener dayEnd;
    View.OnClickListener nightEnd;
    CardView v_sun_moon;
    CardView view_click;
    boolean nights=false;
    int time1=1000;
    int ps1=110;
    int ps2=160;
    int ps3=120;


    TranslateAnimation anim1 = new TranslateAnimation(0, ps1,0, 0);
    TranslateAnimation anim2 = new TranslateAnimation(ps1, 0, 0, 0);

    TranslateAnimation anim3 = new TranslateAnimation(0, ps2,0, 0);
    TranslateAnimation anim4 = new TranslateAnimation(ps2, 0, 0, 0);

    TranslateAnimation anim5 = new TranslateAnimation(0, 0,0, ps3);
    TranslateAnimation anim6 = new TranslateAnimation(0, 0, -ps3, 0);

    TranslateAnimation anim7 = new TranslateAnimation(0, 0,0, -ps3);
    TranslateAnimation anim8 = new TranslateAnimation(0, 0, ps3, 0);

    TranslateAnimation anim9 = new TranslateAnimation(-ps1, ps1,0, 0);
    TranslateAnimation anim10 = new TranslateAnimation(ps1, -ps1, 0, 0);

    public  SwitchDayNight(AppCompatActivity ct, View.OnClickListener day, View.OnClickListener night){
        this.ct=ct;
        this.dayEnd=day;
        this.nightEnd=night;
        map();
        lo_bg_ma.setTranslationX(-ps1);
    }
    private void map(){
        ps2=ct.getResources().getInteger(R.integer.rong)*4;
        view_click= ct.findViewById(R.id.view_click);
        lo_bg_ma= ct.findViewById(R.id.lo_bg_ma);
        lo_s= ct.findViewById(R.id.lo_s);
        lo_m= ct.findViewById(R.id.lo_m);
        img_moon= ct.findViewById(R.id.img_moon);
        img_sun= ct.findViewById(R.id.img_sun);
        v_sun_moon= ct.findViewById(R.id.v_sun_moon);
        anim1.setDuration(time1);
        anim2.setDuration(time1);
        anim3.setDuration(time1);
        anim4.setDuration(time1);
        anim5.setDuration(time1);
        anim6.setDuration(time1);
        anim7.setDuration(time1);
        anim8.setDuration(time1);
        anim9.setDuration(time1);
        anim10.setDuration(time1);
        view_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nights=!nights;
                if(nights){
                    goToNight();
                    dayEnd.onClick(view);
                }else{
                    nightEnd.onClick(view);
                    goToDay();
                }
            }
        });
    }
    private void goToNight(){
        img_moon.setTranslationX(0);
        img_sun.setTranslationX(0);
        v_sun_moon.setTranslationX(0);
        lo_m.setTranslationY(0);
        lo_s.setTranslationY(0);
        lo_bg_ma.setTranslationX(0);
        v_sun_moon.startAnimation(anim3);
        img_moon.startAnimation(anim2);
        img_sun.startAnimation(anim1);
        lo_s.startAnimation(anim5);
        lo_m.startAnimation(anim6);
        lo_bg_ma.startAnimation(anim9);
        new CountDownTimer(time1,100){
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                img_moon.setTranslationX(0);
                img_sun.setTranslationX(ps1);
                v_sun_moon.setTranslationX(ps2);
                lo_m.setTranslationY(0);
                lo_s.setTranslationY(ps3);
                lo_bg_ma.setTranslationX(ps1);
            }
        }.start();
    }

    private void goToDay(){
        img_moon.setTranslationX(0);
        img_sun.setTranslationX(0);
        v_sun_moon.setTranslationX(0);
        lo_m.setTranslationY(0);
        lo_s.setTranslationY(0);
        lo_bg_ma.setTranslationX(0);
        v_sun_moon.startAnimation(anim4);
        img_moon.startAnimation(anim1);
        img_sun.startAnimation(anim2);
        lo_m.startAnimation(anim7);
        lo_s.startAnimation(anim8);
        lo_bg_ma.startAnimation(anim10);
        new CountDownTimer(time1,100){
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                img_moon.setTranslationX(ps1);
                img_sun.setTranslationX(0);
                v_sun_moon.setTranslationX(0);
                lo_s.setTranslationY(0);
                lo_m.setTranslationY(ps3);
                lo_bg_ma.setTranslationX(-ps1);
            }
        }.start();
    }

}
