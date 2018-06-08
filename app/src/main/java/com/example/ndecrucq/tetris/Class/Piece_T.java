package com.example.ndecrucq.tetris.Class;

import android.graphics.Color;

import com.example.ndecrucq.tetris.Interface.Movement;
import com.example.ndecrucq.tetris.Interface.Possible_Movement;

/**
 * Created by ndecrucq on 04/06/18.
 */

public class Piece_T extends Piece implements Movement, Possible_Movement {

    Piece_T() {
        hauteur = 2;
        largeur = 3;
        matrice = new int[][]{{1,1,1},{0,1,0}};
        pos_i = 1;
        pos_j = 5;
        color = Color.MAGENTA;
    }

    @Override
    public void rotate() {

    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void down() {

    }
}
