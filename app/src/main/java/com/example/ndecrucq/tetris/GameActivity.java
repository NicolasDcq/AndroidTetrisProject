package com.example.ndecrucq.tetris;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;

import com.example.ndecrucq.tetris.Class.MatrixAdapter;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_game);

        ArrayList<Integer> imageIdList = new ArrayList<Integer>();

        final Point size = getDisplayContentDimensions();

        int rows = 20;
        int columns = 10;

        GridView grid = (GridView) findViewById(R.id.grid_game);
        grid.setNumColumns(columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                imageIdList.add(R.drawable.demo);
            }
        }

        MatrixAdapter adapter = new MatrixAdapter(getApplicationContext(), imageIdList, size.x, size.y);
        grid.setAdapter(adapter);


    }
}
