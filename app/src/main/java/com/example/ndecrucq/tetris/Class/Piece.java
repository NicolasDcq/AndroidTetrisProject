package com.example.ndecrucq.tetris.Class;

import com.example.ndecrucq.tetris.Interface.Movement;
import com.example.ndecrucq.tetris.Interface.Possible_Movement;

/**
 * Created by ndecrucq on 04/06/18.
 */

public abstract class Piece implements Movement,Possible_Movement {

    protected int hauteur;
    protected int largeur;
    protected Matrix matrice;
    protected int pos_i;
    protected int pos_j;
    protected int color;

    @Override
    public void left() {
        if((this.getPos_j()-1) >= 0) {
            this.setPos_j(this.getPos_j() - 1);
        }
    }

    @Override
    public void right() {
        if((this.getPos_j()+ 1) <= ( 10- this.getLargeur())) {
            this.setPos_j(this.getPos_j() + 1);
        }
    }

    @Override
    public void down() {
        if((this.getPos_i()+ 1) <= (20 - this.getHauteur())){
            this.setPos_i(this.getPos_i()+1);
        }
    }

    @Override
    public void canMove() {

    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public Matrix getMatrice() {
        return matrice;
    }

    public void setMatrice(Matrix matrice) {
        this.matrice = matrice;
    }

    public int getPos_i() {
        return pos_i;
    }

    public void setPos_i(int pos_i) {
        this.pos_i = pos_i;
    }

    public int getPos_j() {
        return pos_j;
    }

    public void setPos_j(int pos_j) {
        this.pos_j = pos_j;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

}
