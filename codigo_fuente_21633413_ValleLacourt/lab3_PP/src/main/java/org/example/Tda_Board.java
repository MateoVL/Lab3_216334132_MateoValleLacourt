package org.example;

public interface Tda_Board {
    //Modificadores
    public void setPiece1(Player p1);
    public void setPiece2(Player p2);
    public void play_piece(int columna, Piece pieza);

    //Otros
    public Boolean can_play();
    public int check_vertical_win();
    public int check_horizontal_win();
    public int check_diagonal_win();
    public int check_winner();
    public void mostrarTablero();
}
