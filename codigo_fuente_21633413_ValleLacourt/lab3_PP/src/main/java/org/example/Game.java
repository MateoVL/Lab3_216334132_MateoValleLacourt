package org.example;

import java.util.Arrays;

public class Game implements Tda_Game{
    //Atributos
    private Player player1;
    private Player player2;
    private Board board;
    private int turn;
    private String[][] history;

    //Metodos
    //Constructor
    //RF12
    public Game() {
        this.history = new String[][]{};
        this.board = new Board();
        this.turn = 1;
    }

    //Selectores

    //Modificadores

    @Override
    public void setPlayer1(Player player1) {
        this.player1 = player1;
        board.setPiece1(player1);
    }

    @Override
    public void setPlayer2(Player player2) {
        this.player2 = player2;
        board.setPiece2(player2);
    }

    //Otros

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                ", board=" + board +
                ", turn=" + turn +
                ", history=" + Arrays.toString(history) +
                '}';
    }
}
