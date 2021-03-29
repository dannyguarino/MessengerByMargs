package com.margsapp.messenger.dp_view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.margsapp.messenger.MainActivity;
import com.margsapp.messenger.R;
import com.margsapp.messenger.groupclass.group_infoActivity;

import java.util.Objects;

public class main_dpActivity extends AppCompatActivity {

    ImageView dpView;

    String imageurl;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_main_dp);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_dpActivity.this, MainActivity.class);
                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(dpView, "imageTransition");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(main_dpActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        });

        dpView = findViewById(R.id.dpview);

        intent = getIntent();
        imageurl = intent.getStringExtra("data");

        if(imageurl.equals("default"))
        {
            dpView.setImageResource(R.drawable.user);

        }
        else {
            Glide.with(getApplicationContext()).load(imageurl).into(dpView);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(main_dpActivity.this, MainActivity.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(dpView, "imageTransition");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(main_dpActivity.this, pairs);
        startActivity(intent, options.toBundle());
    }
}