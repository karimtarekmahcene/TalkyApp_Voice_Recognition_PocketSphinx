package com.example.acer.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by acer on 16/03/2018.
 */

public class ListViewAdpter extends ArrayAdapter<categorie> {
    Animation anim1,anim2;

    RelativeLayout r;
    CircleImageView vi;
    ImageView n;

    public ListViewAdpter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v =convertView;


        if(v==null){
            LayoutInflater inflater =(LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.list_item, null);
        }

        anim1= AnimationUtils.loadAnimation(getContext(),R.anim.righttoleft);
        anim2=AnimationUtils.loadAnimation(getContext(),R.anim.righttoleft);
        r=(RelativeLayout)v.findViewById(R.id.itemlayout);
        vi=(CircleImageView)v.findViewById(R.id.imageView);
        n=(ImageView)v.findViewById(R.id.star);
        categorie categorie =getItem(position);
        if(position==0){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setAnimation(anim1);
            r.setBackgroundResource(R.drawable.backlistitem);
            vi.setImageResource(R.drawable.animalsicon);
            n.setImageResource(R.drawable.scoree);

        }else if(position==1){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setAnimation(anim2);
            r.setBackgroundResource(R.drawable.backlistitem);
            vi.setImageResource(R.drawable.artt);
            n.setImageResource(R.drawable.scoree);

        }else if(position==3){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setBackgroundResource(R.drawable.backlistitem);
            r.setAnimation(anim1);
            vi.setImageResource(R.drawable.geographyicon);
            n.setImageResource(R.drawable.scoree);

        }else if(position==2){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setBackgroundResource(R.drawable.backlistitem);
            r.setAnimation(anim1);
            vi.setImageResource(R.drawable.fastfood);
            n.setImageResource(R.drawable.scoree);
        }else if(position==4){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setBackgroundResource(R.drawable.backlistitem);
            r.setAnimation(anim1);
            vi.setImageResource(R.drawable.medicon);
            n.setImageResource(R.drawable.scoree);
        }
        else if(position==5){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setBackgroundResource(R.drawable.backlistitem);
            r.setAnimation(anim1);
            vi.setImageResource(R.drawable.objectt);
            n.setImageResource(R.drawable.scoree);
        } else if(position==6){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setBackgroundResource(R.drawable.backlistitem);
            r.setAnimation(anim1);
            vi.setImageResource(R.drawable.sporticon);
            n.setImageResource(R.drawable.scoree);
        }
        else if(position==7){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setBackgroundResource(R.drawable.backlistitem);
            r.setAnimation(anim1);
            vi.setImageResource(R.drawable.techicon);
            n.setImageResource(R.drawable.scoree);
        }
        else if(position==8){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setBackgroundResource(R.drawable.backlistitem);
            r.setAnimation(anim1);
            vi.setImageResource(R.drawable.publictransport);
            n.setImageResource(R.drawable.scoree);
        }else if(position==9){
            vi=(CircleImageView)v.findViewById(R.id.imageView);
            n=(ImageView)v.findViewById(R.id.star);
            r=(RelativeLayout)v.findViewById(R.id.itemlayout);
            r.setBackgroundResource(R.drawable.rounded_for_prev);
            r.setAnimation(anim1);
            vi.setImageResource(R.drawable.revise);
            n.setImageResource(R.drawable.star);
        }



        TextView titre = v.findViewById(R.id.titre);
        TextView description = v.findViewById(R.id.txdescription);



        titre.setText(categorie.getTitle());
        description.setText(categorie.getDescription());
        return v;

    }
}
