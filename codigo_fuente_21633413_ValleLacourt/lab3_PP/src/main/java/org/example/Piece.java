package org.example;

public class Piece {
    //Atributos
    String pieza;

    //Metodos
    //Constructor
    //RF04
    public Piece(String color) {
        char caracter = Character.toUpperCase(color.charAt(0));
        this.pieza = "(" + caracter + ")";
    }
}
