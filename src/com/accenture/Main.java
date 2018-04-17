package com.accenture;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Práctica JavaSE "Sorteo del Gordo de Navidad"
* @author  Pablo Girón Ramírez
* @version 1.0
* @since   16/08/2018
*/

public class Main {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Sorteo sorteoNavidad = new Sorteo();
        System.err.println("¡Empieza el sorteo!");
        //Se repite el bucle mientras haya bolas
        do{
            try {
                sorteoNavidad.sacaBolas(); //Se saca una bola de cada tipo
            } catch (TipoSinPremioException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); //Se controla la excepción en caso de que salga la bola en blanco
            }
        }while(sorteoNavidad.bomboPremios.quedanBolas());

        System.err.println("¡Termina el sorteo!");
        System.err.println("Premios principales: ");
        Tabla.mostrarPremios(); //Se muestran los premios por orden de mayor a menor
        int opcion = 0;        
        do{
            System.out.println("Introduce tu número de la lotería: (-1 para salir) :");
            opcion = teclado.nextInt();
            System.out.println(Tabla.comprobarPremio(opcion));  
        }while(opcion > 0);
        teclado.close();
    }
    
}
