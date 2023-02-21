package com.example.acer.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class Sign_up extends Activity {
    TextView et1,et2,et3;
    EditText pass,login,pass_conf;
    Button ok,annuler;
    My_helper database;
    public static String nom,password;
    public static boolean x=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        pass=(EditText)findViewById(R.id.pass_insc);
        login=(EditText)findViewById(R.id.login_insc);
        pass_conf=(EditText)findViewById(R.id.pass_conf);
        ok=(Button)findViewById(R.id.ok);

        database = new My_helper(this);


        final String etV = "<font color=#39ac33> * </font>";

        final String etR = "<font color=#c93037> * </font>";

        et1=(TextView)findViewById(R.id.etoile1);
        et2=(TextView)findViewById(R.id.etoile2);
        et3=(TextView)findViewById(R.id.etoile3);


        if(!(login.getText().toString().equals(""))){
            et1.setText(Html.fromHtml(etV));
        }
        ok.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if(!(login.getText().toString().equals(""))&&(pass.getText().toString().equals(pass_conf.getText().toString()))&&!(pass.getText().toString().equals(""))&&!(pass_conf.getText().toString().equals(""))){
                    if(database.userExists(login.getText().toString(),pass.getText().toString())){
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup)findViewById(R.id.toast_layout));
                        ImageView imagetoast = layout.findViewById(R.id.imageView3);
                        imagetoast.setImageResource(R.drawable.userexists);
                        //toasttext = layout.findViewById(R.id.textView3);
                        //toasttext.setText("something else");


                        final Toast user_exists_toast = new Toast(getApplicationContext());
                        user_exists_toast.setGravity(Gravity.RIGHT,0,0);
                        user_exists_toast.setView(layout);
                        user_exists_toast.show();
                    }else {

                        nom = login.getText().toString();
                        password = pass.getText().toString();
                        x = true;
//database.createuser(new user(login.getText().toString(),pass.getText().toString()),
                        et1.setText(Html.fromHtml(etV));
                        et2.setText(Html.fromHtml(etV));
                        et3.setText(Html.fromHtml(etV));


                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast_for_welcome, (ViewGroup)findViewById(R.id.toast_layout));
                        ImageView imagetoast = layout.findViewById(R.id.imageView3);
                        imagetoast.setImageResource(R.drawable.welcometoast);
                        //toasttext = layout.findViewById(R.id.textView3);
                        //toasttext.setText("something else");


                        final Toast welcometoast = new Toast(getApplicationContext());
                        welcometoast.setDuration(Toast.LENGTH_SHORT);
                        welcometoast.setView(layout);
                        welcometoast.show();


                        Intent i = new Intent(Sign_up.this, login_activite.class);
                        startActivity(i);

                    }
                }else{
                    if((login.getText().toString().equals(""))){
                        et1.setText(Html.fromHtml(etR));
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast_for_emptychamps, (ViewGroup)findViewById(R.id.toast_layout));
                        ImageView imagetoast = layout.findViewById(R.id.imageView3);
                        imagetoast.setImageResource(R.drawable.emptychamps);
                        //toasttext = layout.findViewById(R.id.textView3);
                        //toasttext.setText("something else");


                        final Toast logintoast = new Toast(getApplicationContext());
                        logintoast.setDuration(Toast.LENGTH_SHORT);
                        logintoast.setView(layout);
                        logintoast.show();
                    }else if(!(pass.getText().toString().equals(pass_conf.getText().toString()))){
                        et3.setText(Html.fromHtml(etR));
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast_for_password, (ViewGroup)findViewById(R.id.toast_layout));
                        ImageView imagetoast = layout.findViewById(R.id.imageView3);
                        imagetoast.setImageResource(R.drawable.checkpsw);
                        //toasttext = layout.findViewById(R.id.textView3);
                        //toasttext.setText("something else");


                        final Toast passwordtoast = new Toast(getApplicationContext());
                        passwordtoast.setDuration(Toast.LENGTH_SHORT);
                        passwordtoast.setView(layout);
                        passwordtoast.show();
                    }else if((pass.getText().toString().equals(""))){
                        et2.setText(Html.fromHtml(etR));
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast_for_emptychamps, (ViewGroup)findViewById(R.id.toast_layout));
                        ImageView imagetoast = layout.findViewById(R.id.imageView3);
                        imagetoast.setImageResource(R.drawable.emptychamps);
                        //toasttext = layout.findViewById(R.id.textView3);
                        //toasttext.setText("something else");


                        final Toast empty_champs_toast = new Toast(getApplicationContext());
                        empty_champs_toast.setDuration(Toast.LENGTH_SHORT);
                        empty_champs_toast.setView(layout);
                        empty_champs_toast.show();
                    }else if(pass_conf.getText().toString().equals("")){
                        et3.setText(Html.fromHtml(etR));
                        LayoutInflater inflater = getLayoutInflater();
                        View layout = inflater.inflate(R.layout.custom_toast_for_emptychamps, (ViewGroup)findViewById(R.id.toast_layout));
                        ImageView imagetoast = layout.findViewById(R.id.imageView3);
                        imagetoast.setImageResource(R.drawable.emptychamps);
                        //toasttext = layout.findViewById(R.id.textView3);
                        //toasttext.setText("something else");


                        final Toast empty_champs_toast = new Toast(getApplicationContext());
                        empty_champs_toast.setDuration(Toast.LENGTH_SHORT);
                        empty_champs_toast.setGravity(Gravity.BOTTOM,0,0);
                        empty_champs_toast.setGravity(Gravity.RIGHT,0,0);
                        empty_champs_toast.setView(layout);
                        empty_champs_toast.show();
                    }

                }
            }
        });



    }
}
