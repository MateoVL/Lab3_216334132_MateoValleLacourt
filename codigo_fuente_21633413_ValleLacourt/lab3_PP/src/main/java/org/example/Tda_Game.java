package org.example;

/**
 * interface que representa el TDA Game con sus metodos
 */
public interface Tda_Game {
    //Selectores
    //RF16
    Player get_current_player();
    Board getBoard();
    int getTurn();
    Player getPlayer1();
    Player getPlayer2();
    int getEstado();

    //Modificadores
    //RF18
    void end_game();
    //RF19
    void player_set_move(Player jugador, int columna);

    //Otros
    //RF13
    void history();
    //RF14
    Boolean is_draw();
    //RF17
    void show_Board();
}
