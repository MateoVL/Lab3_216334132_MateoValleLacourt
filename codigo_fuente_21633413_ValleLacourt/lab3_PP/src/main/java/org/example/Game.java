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
    //RF16
    @Override
    public Player get_current_player() {
        if (turn == 1) {
            return player1;
        }
        return player2;
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public int getTurn() {
        return turn;
    }

    @Override
    public Player getPlayer1() {
        return player1;
    }

    @Override
    public Player getPlayer2() {
        return player2;
    }

    //Modificadores
    //RF18
    @Override
    public void end_game() {
        estado = 0;
        if (is_draw()) {
            player1.update_stats("draw");
            player2.update_stats("draw");
        } else if (board.check_winner() == 1) {
            player1.update_stats("win");
            player2.update_stats("loss");
        } else if (board.check_winner() == 2) {
            player1.update_stats("loss");
            player2.update_stats("win");
        }
    }

    //RF19
    @Override
    public void player_set_move(Player jugador, int columna) {
        if (jugador == get_current_player() && 0 <= columna && columna <= 6) {
            if (board.can_play_columna(columna)) {
                if (jugador == player1) {
                    board.play_piece(columna, board.getPiece1());
                    player1.sub_pieces();
                    turn++;
                    String[] movimiento = new String[]{player1.getColor(), String.valueOf(columna + 1)};
                    historial.add(movimiento);
                } else if (jugador == player2) {
                    board.play_piece(columna, board.getPiece2());
                    player2.sub_pieces();
                    turn--;
                    historial.add(new String[]{player2.getColor(), String.valueOf(columna + 1)});
                }

                if (is_draw()) {
                    end_game();
                    System.out.println("### Empate! ###");

                } else if (board.check_winner() != 0) {
                    end_game();
                }
            }
        }
    }

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

    //RF17
    @Override
    public void show_Board() {
        board.mostrarTablero();
    }
}
