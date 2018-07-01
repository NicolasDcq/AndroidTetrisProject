package com.example.ndecrucq.tetris.Class;

import android.graphics.Color;

import com.example.ndecrucq.tetris.Interface.Movement;
import com.example.ndecrucq.tetris.Interface.Possible_Movement;

/**
 * Created by ndecrucq on 04/06/18.
 */

public class Piece_L extends Piece implements Movement,Possible_Movement {

    public Piece_L() {
        hauteur = 2;
        largeur = 3;
        matrice = new Matrix(new int[][]{{1,1,1},{1,0,0}});
        pos_i = 0;
        pos_j = 5;
        color = Color.LTGRAY;
    }

    @Override
    public void rotate() {
        Matrix matrix_1 = new Matrix(new int[][]{{1,1,1},{1,0,0}});
        Matrix matrix_2 = new Matrix(new int[][]{{1,1}, {0,1}, {0,1}});
        Matrix matrix_3 = new Matrix(new int[][]{{0,0,1}, {1,1,1}});
        Matrix matrix_4 = new Matrix(new int[][]{{1,0}, {1,0}, {1,1}});


        if (this.matrice.eq(matrix_1)) {
            this.matrice = matrix_2;
        } else if (this.matrice.eq(matrix_2)) {
            this.matrice = matrix_3;
        }
        else if (this.matrice.eq(matrix_3)) {
            this.matrice = matrix_4;
        }
        else if (this.matrice.eq(matrix_4)) {
            this.matrice = matrix_1;
        }

        int temp = this.hauteur;
        this.hauteur = this.largeur;
        this.largeur = temp;

    }

}
