package com.example.ndecrucq.tetris;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.ndecrucq.tetris.Class.Matrix;
import com.example.ndecrucq.tetris.Class.MatrixAdapter;
import com.example.ndecrucq.tetris.Class.Piece;
import com.example.ndecrucq.tetris.Class.Piece_I;
import com.example.ndecrucq.tetris.Class.Piece_J;
import com.example.ndecrucq.tetris.Class.Piece_L;
import com.example.ndecrucq.tetris.Class.Piece_O;
import com.example.ndecrucq.tetris.Class.Piece_S;
import com.example.ndecrucq.tetris.Class.Piece_T;
import com.example.ndecrucq.tetris.Class.Piece_Z;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Piece> pieceList = new ArrayList<Piece>();
    ArrayList<Integer> imageIdList = new ArrayList<Integer>();

    int rows = 20;
    int columns = 10;
    int speed = 250;
    GridView grid;
    Point size;
    MatrixAdapter adapter;
    Piece currentPiece;
    Integer currentPieceId = 0;

    Integer score = 0;


    public Piece pieceAlea() {
        Piece piece = new Piece_I();
        Random r = new Random();
        int p = r.nextInt(7);
        switch (p) {
            case 0:
                piece = new Piece_I();
                break;
            case 1:
                piece = new Piece_J();
                break;
            case 2:
                piece = new Piece_L();
                break;
            case 3:
                piece = new Piece_O();
                break;
            case 4:
                piece = new Piece_S();
                break;
            case 5:
                piece = new Piece_T();
                break;
            case 6:
                piece = new Piece_Z();
                break;
            default:
                break;
        }
        return piece;
    }

    public void getPointForScore(String event) {
        switch (event) {
            case "new_piece":
                score += 50;
                break;
            case "broke_1_line":
                score += 100;
                break;
            case "broke_2_line":
                score += 300;
                break;
            case "broke_3_line":
                score += 900;
                break;
            case "broke_4_line":
                score += 1200;
                break;
            default:
                break;
        }
    }

    Handler timerHandler = new Handler();
    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {

            if (!EndGame()) {
                if (!currentPiece.canMove(imageIdList)) {
                    currentPieceId++;
                    currentPiece = pieceAlea();
                    getPointForScore("new_piece");
                    pieceList.add(currentPiece);
                    adapter = new MatrixAdapter(getApplicationContext(), imageIdList, size.x, size.y);
                    grid.setAdapter(adapter);
                }
                update();
                pieceList.get(currentPieceId).setPos_i(pieceList.get(currentPieceId).getPos_i() + 1);
                adapter.notifyDataSetChanged();
                timerHandler.postDelayed(this, speed);

                Log.i("ok", String.valueOf(pieceList.get(currentPieceId).getPos_i()));

            }
            else{
                Intent intent = new Intent(GameActivity.this, EndActivity.class);
                intent.putExtra("score", Integer.toString(score));
                startActivity(intent);
            }
        }
    };

    public Point getDisplayContentDimensions() {
        final WindowManager windowManager = getWindowManager();
        final Point size = new Point();
        int screenHeight = 0, actionBarHeight = 0;

        if (getActionBar() != null) {
            actionBarHeight = getActionBar().getHeight();
        }

        int contentTop = ((ViewGroup) findViewById(android.R.id.content)).getTop();
        windowManager.getDefaultDisplay().getSize(size);
        screenHeight = size.y;
        size.y = screenHeight - contentTop - actionBarHeight;
        return size;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove top panel
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_game);

        final ImageButton left = (ImageButton) findViewById(R.id.btn_left);
        final ImageButton right = (ImageButton) findViewById(R.id.btn_right);
        final ImageButton down = (ImageButton) findViewById(R.id.btn_bottom);
        final ImageButton rotate = (ImageButton) findViewById(R.id.btn_rotate);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        down.setOnClickListener(this);
        rotate.setOnClickListener(this);

        size = getDisplayContentDimensions();

        grid = (GridView) findViewById(R.id.grid_game);
        grid.setNumColumns(columns);

        resetImageList();

        currentPiece = pieceAlea();
        pieceList.add(currentPiece);
        update();
        adapter = new MatrixAdapter(getApplicationContext(), imageIdList, size.x, size.y);
        grid.setAdapter(adapter);

        timerHandler.postDelayed(timerRunnable, speed);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    protected void resetImageList() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                imageIdList.add(0);
            }
        }
    }

    protected void update() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                imageIdList.set((i * columns) + j, 0);
            }
        }
        for (Piece item : pieceList) {
            for (int i = 0; i < item.getHauteur(); i++) {
                for (int j = 0; j < item.getLargeur(); j++) {
                    if (item.getMatrice().getM_table()[i][j] != 0) {
                        imageIdList.set((item.getPos_i() * columns) + item.getPos_j() + (i * columns) + j, item.getColor());
                    }
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                    pieceList.get(currentPieceId).left();
                break;
            case R.id.btn_bottom:
                if (currentPiece.canMove(imageIdList)) {
                    pieceList.get(currentPieceId).down();
                }
                break;
            case R.id.btn_right:
                    pieceList.get(currentPieceId).right();
                break;
            case R.id.btn_rotate:
                    pieceList.get(currentPieceId).rotate();
                break;
        }
        update();
        adapter.notifyDataSetChanged();
    }

    private boolean EndGame()
    {
        boolean endGame = false;
        if(currentPiece.getPos_i() == 1 && !currentPiece.canMove(imageIdList)){
            endGame=true;
        }
        return endGame;
    }


}
