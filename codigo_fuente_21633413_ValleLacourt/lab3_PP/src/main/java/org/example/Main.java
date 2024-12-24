package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game juego = null;
        Player jugador1 = null;
        Player jugador2 = null;
        int cantFichas = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Bienvenido a Conecta-4");



        int choice;
        do {
            imprimirMenu();
            choice = input.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("\n-- Configuracion Jugador 1 --");
                    System.out.print("Ingrese nombre del jugador 1: ");
                    String nombreP1 = input.next();
                    System.out.print("Ingrese el color del jugador 1(Rojo/Amarillo): ");
                    String color1 = input.next();
                    color1 = color1.toUpperCase();
                    if (!(color1.equals("ROJO") || color1.equals("AMARILLO"))){
                        System.out.println("Seleccione un color válido");
                        break;
                    }

                    System.out.println("\n-- Configuracion Jugador 2 --");
                    System.out.print("Ingrese nombre del jugador 2: ");
                    String nombreP2 = input.next();
                    System.out.print("Ingrese el color del jugador 2(Rojo/Amarillo): ");
                    String color2 = input.next();
                    color2 = color2.toUpperCase();
                    if (!(color2.equals("ROJO") || color2.equals("AMARILLO"))){
                        System.out.println("Seleccione un color válido");
                        break;
                    }
                    if(color2.equals(color1)){
                        System.out.println("Error: color ya seleccionado");
                        break;
                    }

                    System.out.println("\n-- Configuración de juego --");
                    System.out.print("Ingrese la cantidad de fichas (4-21): ");
                    cantFichas = input.nextInt();

                    jugador1 = new Player(nombreP1, color1, cantFichas);
                    jugador2 = new Player(nombreP2, color2, cantFichas);
                    juego = new Game(jugador1, jugador2);
                    break;

                case 2:
                    if(juego == null){
                        System.out.println("No se ha creado ningún juego.");
                        break;
                    }
                    System.out.println("### Estado del juego ###");
                    juego.show_Board();
                    break;

                case 3:
                    if(juego == null){
                        System.out.println("No se ha creado ningún juego.");
                        break;
                    }
                    System.out.println("### Realizar Jugada ###");
                    if (juego.getTurn()==1){
                        System.out.println("Turno de " + juego.getPlayer1().getName() +
                                "(" + juego.getPlayer1().getColor() + ")");
                        System.out.println("Cantidad de fichas: " + juego.getPlayer1().getRemaining_pieces());
                        System.out.println("\nSeleccione columna (1-7): ");
                        int columna = input.nextInt() - 1;
                        juego.player_set_move(juego.getPlayer1(), columna);
                    }
                    else if (juego.getTurn()==2){
                        System.out.println("Turno de " + juego.getPlayer2().getName() +
                                "(" + juego.getPlayer2().getColor() + ")");
                        System.out.println("Cantidad de fichas: " + juego.getPlayer2().getRemaining_pieces());
                        System.out.println("\nSeleccione columna (1-7): ");
                        int columna = input.nextInt() - 1;
                        juego.player_set_move(juego.getPlayer2(), columna);
                    }
                    System.out.println("### Movimiento realizado: ###");
                    juego.show_Board();

                    if(juego.getBoard().check_winner()>0 || juego.is_draw()){
                        if(juego.is_draw()){
                            System.out.println("### EMPATE!!! ###");
                        }
                        if(juego.getBoard().check_winner()==1){
                            System.out.println("### " + juego.getPlayer1().getName() + " GANA!!! ###");
                        }
                        else if(juego.getBoard().check_winner()==2){
                            System.out.println("### " + juego.getPlayer2().getName() + " GANA!!! ###");
                        }

                        System.out.println("### Estadísticas Actualizadas ###");
                        juego.getPlayer1().show_stats();
                        System.out.println();
                        juego.getPlayer2().show_stats();

                        System.out.println("-- ¿Quieren seguir jugando? --");
                        System.out.println("Ingrese Y/N: ");
                        String respuesta = input.next().toUpperCase();
                        if(respuesta.equals("Y")){
                            jugador1.setPieces(cantFichas);
                            jugador2.setPieces(cantFichas);
                            juego = new Game(jugador1, jugador2);
                            System.out.println("### Tablero Restablecido ###");
                            System.out.println("### Cantidad de Fichas Restablecidas ###");
                            System.out.println("### Historial Restablecido ###");
                            System.out.println("### Siga Jugando! ###");

                        }
                        else if(respuesta.equals("N")){
                            juego = null;
                            jugador1 = null;
                            jugador2 = null;
                        }
                    }
                    break;

                case 4:
                    if(juego==null){
                        System.out.println("No se ha creado ningún juego.");
                        break;
                    }
                    System.out.println("### Estadísticas generales ###");
                    juego.getPlayer1().show_stats();
                    System.out.println();
                    juego.getPlayer2().show_stats();
                    break;

                case 5://mostrar historial
                    if(juego==null){
                        System.out.println("No se ha creado ningún juego.");
                        break;
                    }
                    else{
                        juego.history();
                    }
                    break;

                case 6:
                    System.out.println("Gracias por jugar <3");
                    System.exit(0);
                    break;

                default:
                    System.out.println(choice + " no es una opción válida, seleccione una opción válida porfavor.");

            }
        } while (true);
    }


    private static void imprimirMenu() {
        System.out.println("\nMenu principal\n");
        System.out.print("1. Crear nuevo juego \n");
        System.out.print("2. Ver juego actual\n");
        System.out.print("3. Realizar jugada\n");
        System.out.print("4. Ver estadisticas\n");
        System.out.print("5. Ver historial de juego\n");
        System.out.print("6. Salir\n");
        System.out.print("\nIngrese opción: ");
    }

}
