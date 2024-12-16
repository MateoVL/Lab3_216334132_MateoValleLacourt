package org.example;


import java.util.Arrays;

public class Board {
    //Atributos
    String[][] tablero;
    String p1;
    String p2;


    //Metodos
    //Constructores
    public Board() {
        this.tablero = new String[][]{
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"}};
    }

    public Board(String[][] tablero, String p1, String p2) {
        this.tablero = tablero;
        this.p1 = p1;
        this.p2 = p2;
    }


    //Selectores
    public String[][] getTablero() {
        return tablero;
    }

    public String getP1() {
        return p1;
    }

    public String getP2() {
        return p2;
    }


    //modificadores
    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }


    //otros
    public void mostrarTablero() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (j==0){
                    System.out.print("| ");
                }
                System.out.print(tablero[i][j] + " ");
                if (j==6){
                System.out.print("|");}
            }
            System.out.print("\n");
            if (i==5){
                System.out.print("|-----------------------------|");
            }
        }
    }


    @Override
    public String toString() {
        return "Board{" +
                "tablero=" + Arrays.toString(tablero) +
                ", p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }

}
