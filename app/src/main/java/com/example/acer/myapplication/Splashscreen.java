package com.example.acer.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Splashscreen extends Activity {


    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    /** Called when the activity is first created. */
    Thread splashTread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        StartAnimations();
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);


        anim.reset();
        ImageView iv1 = (ImageView) findViewById(R.id.splash);
        TextView t1 = (TextView) findViewById((R.id.T1));
        TextView t2 = (TextView) findViewById((R.id.T2));
        //ImageView iv2 = (ImageView) findViewById(R.id.splash2);
        //ImageView iv3 = (ImageView) findViewById(R.id.splash3);
        //ImageView iv4 = (ImageView) findViewById(R.id.splash4);
        iv1.clearAnimation();
        //iv2.clearAnimation();
        //iv3.clearAnimation();
        //iv4.clearAnimation();
        iv1.startAnimation(anim);
        t1.startAnimation(anim);
        t2.startAnimation(anim);
        //iv2.startAnimation(anim);
        //iv3.startAnimation(anim);
        // iv4.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 5000) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Splashscreen.this,
                            login_activite.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    Splashscreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splashscreen.this.finish();
                }

            }
        };
        splashTread.start();

    }

}
