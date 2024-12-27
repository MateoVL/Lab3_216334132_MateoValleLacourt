package org.example;

/**
 * interface que representa el TDA Player con sus metodos
 */
public interface Tda_Player {
    //Selectores
    String getColor();
    int getRemaining_pieces();
    String getName();

    //modificadores
    void sub_pieces();
    void setPieces(int pieces);
    void update_stats(String resultado);

    //otros
    void show_stats();
}
