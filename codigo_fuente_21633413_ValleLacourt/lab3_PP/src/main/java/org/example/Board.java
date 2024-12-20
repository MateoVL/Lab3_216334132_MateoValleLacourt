package org.example;

import java.util.Arrays;

public class Board implements Tda_Board {
    //Atributos
    private String[][] tablero;
    private Piece piece1;
    private Piece piece2;


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
    @Override
    public Piece getPiece1() {
        return piece1;
    }

    @Override
    public Piece getPiece2() {
        return piece2;
    }

    //modificadores
    @Override
    public void setPiece1(Player p1) {
        this.piece1 = new Piece(p1.getColor());
    }

    @Override
    public void setPiece2(Player p2) {
        this.piece2 = new Piece(p2.getColor());
    }

    //RF07
    @Override
    public void play_piece(int columna, Piece pieza) {
        for (int i = 0; i < 6; i++) {
            if (i == 5 && tablero[i][columna].equals("( )")) {
                tablero[i][columna] = pieza.getPieza();
                break;
            }
            if (!tablero[i + 1][columna].equals("( )")) {
                tablero[i][columna] = pieza.getPieza();
                break;
            }
        }
    }

    //otros

    //RF06
    @Override
    public Boolean can_play() {
        for (int i = 0; i < 7; i++) {
            if (tablero[0][i].equals("( )")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean can_play_columna(int columna) {
        return tablero[0][columna].equals("( )");
    }

    //RF08
    @Override
    public int check_vertical_win() {
        int contador = 1;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                if (tablero[j][i].equals("( )")) {
                    contador = 1;
                } else if (tablero[j][i].equals(tablero[j + 1][i])) {
                    contador = contador + 1;
                }
                if (contador == 4) {
                    if (tablero[j][i].equals(piece1.getPieza())) return 1;
                    else if (tablero[j][i].equals(piece2.getPieza())) return 2;
                }
            }
        }
        return 0;
    }

    //RF09
    @Override
    public int check_horizontal_win() {
        int contador = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (tablero[i][j].equals("( )")) {
                    contador = 1;
                } else if (tablero[i][j].equals(tablero[i][j + 1])) {
                    contador = contador + 1;
                }
                if (contador == 4) {
                    if (tablero[i][j].equals(piece1.getPieza())) return 1;
                    else if (tablero[i][j].equals(piece2.getPieza())) return 2;
                }
            }
        }
        return 0;
    }

    //RF10
    @Override
    public int check_diagonal_win() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (tablero[i][j].equals("( )")) {
                    j = 4;
                } else if (tablero[i][j].equals(tablero[i + 1][j + 1]) &&
                        tablero[i][j].equals(tablero[i + 2][j + 2]) &&
                        tablero[i][j].equals(tablero[i + 3][j + 3])) {
                    if (tablero[i][j].equals(piece1.getPieza())) return 1;
                    else if (tablero[i][j].equals(piece2.getPieza())) return 2;
                }
            }
        }
        for (int i = 5; i > 2; i--) {
            for (int j = 0; j < 4; j++) {
                if (tablero[i][j].equals("( )")) {
                    j = 4;
                } else if (tablero[i][j].equals(tablero[i - 1][j + 1]) &&
                        tablero[i][j].equals(tablero[i - 2][j + 2]) &&
                        tablero[i][j].equals(tablero[i - 3][j + 3])) {
                    if (tablero[i][j].equals(piece1.getPieza())) return 1;
                    else if (tablero[i][j].equals(piece2.getPieza())) return 2;
                }
            }
        }
        return 0;
    }

    //RF11
    @Override
    public int check_winner() {
        int winnerV = check_vertical_win();
        int winnerH = check_horizontal_win();
        int winnerD = check_diagonal_win();
        if (winnerV >= winnerH && winnerV >= winnerD) {
            return winnerV;
        } else if (winnerH >= winnerV && winnerH >= winnerD) {
            return winnerH;
        }
        return winnerD;
    }

    @Override
    public void mostrarTablero() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(tablero[i][j] + " ");
                if (j == 6) {
                    System.out.print("|");
                }
            }
            System.out.print("\n");
            if (i == 5) {
                System.out.println("|-----------------------------|");
            }
        }
    }
}
