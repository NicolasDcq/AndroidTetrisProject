package com.example.ndecrucq.tetris.Class;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.ndecrucq.tetris.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ndecrucq on 04/06/18.
 */

public class MatrixAdapter extends BaseAdapter {
    Context m_context;
    ArrayList<Integer> matrixList;

    Integer m_width;
    Integer m_height;

    public MatrixAdapter(Context context, ArrayList matrixList ,Integer width, Integer height) {
        this.m_context = context;
        this.matrixList = matrixList;
        this.m_width = width;
        this.m_height = height;
    }

    @Override
    public int getCount() {
        return matrixList.size();
    }

    @Override
    public Object getItem(int i) {
        return matrixList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {

        ImageView imageview;
        if(convertView == null){
            imageview = new ImageView(m_context);
            imageview.setLayoutParams(new GridView.LayoutParams(m_width/10, (m_width+240)/20));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        else{
            imageview = (ImageView) convertView;
        }
        imageview.setImageResource(matrixList.get(i));

        /*View v = View.inflate(context, R.layout.activity_game,null);*/
        return imageview;
    }
}
