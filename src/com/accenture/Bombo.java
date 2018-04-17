package com.accenture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bombo {
    private final List<Bola> bombo;

    public Bombo() {
        this.bombo = new ArrayList<Bola>();	
    }

    /**
    * Comprueba que haya bolas en el bombo, mezcla aleatoriamente su contenido 
    * con rotarBombo(), extrae una bola y por último la elimina del bombo.
    * @return una bola.
    */
    public Bola extraerBola() {
        Bola bola = null;
        if (quedanBolas()) {
            //rotarBombo();
            bola = this.bombo.get(0);
            this.bombo.remove(0);
        }else{
            System.err.println("El bombo está vacío");
        }
        return bola;
    }

    /**
    * Agrega una bola al bombo.
    * @param bola
    */
    public void agregarBola(Bola bola) {
        this.bombo.add(bola);
    }

    /**
    * Mezcla aleatoriamente el contenido del bombo
    */
    public void rotarBombo() {
        Collections.shuffle(this.bombo);
    }

    /**
    * Comprueba si quedan bolas en el bombo
    * @return true si quedan bolas y false si no quedan.
    */
    public boolean quedanBolas() {
        return !this.bombo.isEmpty();
    }
    /**
    * Cuenta el número de bolas que tiene el bombo
    * @return int numeroDeBolas
    */
    public int contarBolas() {
        return this.bombo.size();
    }

    /**
    * Imprime por pantalla un array con todas las bolas que hay en el bombo
    * (descomentad el bucle para ver el contenido linea por linea)
    */
    public void mostrarContenidoDelBombo(){
        //for (int i = 0; i< this.bombo.size(); i++){
        //    System.out.println(this.bombo.get(i).cantar());
        //}
        System.out.println(this.bombo);
    }    
}
