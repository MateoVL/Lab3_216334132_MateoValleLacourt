package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Objeto que representa a un juego
 */
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

    /**
     * RF12, Constructor de Game
     * @param jugador1 Player
     * @param jugador2 Player
     */
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


    //Selectores
    //RF16

    /**
     * RF16, entrega el jugador del turno actual
     * @return Player
     */
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

    @Override
    public int getEstado(){
        return estado;
    }

    //Modificadores
    //RF18

    /**
     * RF18, dependiendo de quien gana o si hay empate, cambia las estadisticas de los jugadores
     */
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

    /**
     * RF19, verifica que la posicion y el jugador sean correctos, realiza el movimiento en el tablero, descuenta una ficha, cambia el turno, agrega el movimiento al historial y si hay victoria o empate, termina el juego
     * @param jugador Player
     * @param columna int
     */
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

                if (is_draw() || board.check_winner() != 0) {
                    end_game();
                }
            }
        }
    }

    //Otros
    //RF13

    /**
     * RF13, muestra el historial por pantalla
     */
    @Override
    public void history() {
        for (int i = 0; i < historial.size(); i++) {
            System.out.println(Arrays.toString(historial.get(i)));
        }
    }

    //RF14

    /**
     * RF14, verifica si el tablero esta lleno o si los jugadores no tienen fichas
     * @return Boolean
     */
    @Override
    public Boolean is_draw() {
        return !board.can_play() || player1.getRemaining_pieces() == 0
                && player2.getRemaining_pieces() == 0;
    }

    //RF17

    /**
     * RF17, muestra el tablero del juego
     */
    @Override
    public void show_Board() {
        board.mostrarTablero();
    }
}
