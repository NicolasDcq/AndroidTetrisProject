package com.example.ndecrucq.tetris.Class;

import android.graphics.Color;

import com.example.ndecrucq.tetris.Interface.Movement;
import com.example.ndecrucq.tetris.Interface.Possible_Movement;

/**
 * Created by ndecrucq on 04/06/18.
 */

public class Piece_O extends Piece implements Movement,Possible_Movement {

    public Piece_O() {
        hauteur = 2;
        largeur = 2;
        matrice = new Matrix(new int[][]{{1,1},{1,1}});
        pos_i = 0;
        pos_j = 5;
        color = Color.YELLOW;
    }

    @Override
    public void rotate() {

    }

}
