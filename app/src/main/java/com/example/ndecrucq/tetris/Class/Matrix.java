package com.example.ndecrucq.tetris.Class;

public class Matrix {
    private int m_height;
    private int m_width;
    private int[][] m_table;

    public Matrix(int height,int width) {
        m_height = height;
        m_width = width;
        m_table = new int[height][width];
    }

    public Matrix(int [][]table) {
        m_height = table.length;
        m_width = table[0].length;
        m_table = new int[m_height][m_width];
        for (int i = 0; i < m_height; i++)
            for (int j = 0; j < m_width; j++)
                m_table[i][j] = table[i][j];
    }

    private Matrix(Matrix A) { this(A.m_table); }

    public int values(int i,int j){
        return m_table[i][j];
    }

    public void setValues(int i,int j, int val){
        m_table[i][j] = val;
    }

    public boolean eq(Matrix B) {
        Matrix A = this;
        if (B.m_height != A.m_height || B.m_width != A.m_width);
        for (int i = 0; i < m_height; i++)
            for (int j = 0; j < m_width; j++)
                if (A.m_table[i][j] != B.m_table[i][j]) return false;
        return true;
    }

    public int getM_height() {
        return m_height;
    }

    public void setM_height(int m_height) {
        this.m_height = m_height;
    }

    public int getM_width() {
        return m_width;
    }

    public void setM_width(int m_width) {
        this.m_width = m_width;
    }

    public int[][] getM_table() {
        return m_table;
    }

    public void setM_table(int[][] m_table) {
        this.m_table = m_table;
    }
}
