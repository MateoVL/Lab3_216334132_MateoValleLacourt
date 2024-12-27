package org.example;

/**
 * interface que representa el TDA Board con sus metodos
 */
public interface Tda_Board {
    //Selectores
    Piece getPiece1();
    Piece getPiece2();

    //Modificadores
    void setPiece1(Player p1);
    void setPiece2(Player p2);
    void play_piece(int columna, Piece pieza);

    //Otros
    Boolean can_play();
    Boolean can_play_columna(int columna);
    int check_vertical_win();
    int check_horizontal_win();
    int check_diagonal_win();
    int check_winner();
    void mostrarTablero();
}
