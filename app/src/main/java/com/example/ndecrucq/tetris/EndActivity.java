package com.example.ndecrucq.tetris;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        final Button btn_play= (Button) findViewById(R.id.return_menu);
        btn_play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        final TextView score = (TextView)findViewById(R.id.score);
        score.setText(intent.getStringExtra("score"));


    }
}
