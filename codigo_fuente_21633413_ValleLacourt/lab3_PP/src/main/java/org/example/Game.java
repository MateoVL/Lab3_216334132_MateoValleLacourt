package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game implements Tda_Game {
    //Atributos
    private Player player1;
    private Player player2;
    private Board board;
    private int turn;
    private List<String[]> historial;
    private int estado;

    //Metodos
    //Constructor
    //RF12
    public Game(Player jugador1, Player jugador2) {
        this.player1 = jugador1;
        this.player2 = jugador2;
        this.board = new Board();
        this.turn = 1;
        this.historial = new ArrayList<>();
        this.estado = 1;
        board.setPiece1(jugador1);
        board.setPiece2(jugador2);
    }

    public Game() {}

    //Selectores



    //Otros
    //RF13
    @Override
    public void history() {
        for (int i = 0; i < historial.size(); i++) {
            System.out.println(Arrays.toString(historial.get(i)));
        }
    }

    //RF14
    @Override
    public Boolean is_draw() {
        return !board.can_play() || player1.getRemaining_pieces() == 0
                && player2.getRemaining_pieces() == 0;
    }

}
