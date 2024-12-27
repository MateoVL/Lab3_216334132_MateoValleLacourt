package org.example;

/**
 * Objeto que representa una pieza
 */
public class Piece implements Tda_Piece{
    //Atributos
    private String pieza;

    //Metodos
    //Constructor
    //RF04

    /**
     * RF04, Constructor de Piece
     * @param color String
     */
    public Piece(String color) {
        char caracter = Character.toUpperCase(color.charAt(0));
        this.pieza = "(" + caracter + ")";
    }

    @Override
    public String getPieza() {
        return pieza;
    }
}
