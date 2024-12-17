package org.example;

import java.util.Arrays;

public class Board {
    //Atributos
    String[][] tablero;
    String p1;
    String p2;


    //Metodos
    //Constructores
    //RF05
    public Board() {
        this.tablero = new String[][]{
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"},
                {"( )", "( )", "( )", "( )", "( )", "( )", "( )"}};
    }


    //Selectores



    //modificadores
    public void setP1(String p1) {
        this.p1 = p1;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    //RF07
    // malas coordenadas o columna llena se rompe, verificar en game_jugar
    public void play_piece(int columna, Piece pieza){
        for (int i = 0; i < 6; i++) {
            if (i==5 && tablero[i][columna].equals("( )")){
                tablero[i][columna] = pieza.pieza;
                break;
            }
            if (!tablero[i + 1][columna].equals("( )")){
                tablero[i][columna] = pieza.pieza;
                break;
            }
        }
    }

    //otros
    //RF06
    public Boolean can_play(){
        for (int i = 0; i < 7; i++) {
            if (tablero[0][i].equals("( )")) {
                return true;
            }
        }
        return false;
    }

    //RF08
    public int check_vertical_win() {
        int contador = 1;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (tablero[j][i].equals("( )")) {
                    contador = 1;
                }
                else if (tablero[j][i].equals(tablero[j+1][i])) {
                    contador = contador + 1;
                }
                if (contador == 4) {
                    if (tablero[j][i].equals(p1)) return 1;
                    else if (tablero[j][i].equals(p2)) return 2;
                }
            }
        }
        return 0;
    }

    //RF09
    public int check_horizontal_win() {
        int contador = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablero[i][j].equals("( )")) {
                    contador = 1;
                }
                else if (tablero[i][j].equals(tablero[i][j+1])) {
                    contador = contador + 1;
                }
                if (contador == 4) {
                    if (tablero[i][j].equals(p1)) return 1;
                    else if (tablero[i][j].equals(p2)) return 2;
                }
            }
        }
        return 0;
    }


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
                System.out.println("|-----------------------------|");
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
