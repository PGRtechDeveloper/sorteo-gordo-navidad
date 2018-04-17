package com.accenture;

public class BolaNumero implements Bola{
    public int numero;

    public BolaNumero(int numero) {
        this.numero = numero;	
    }

    /**
    * Devuelve un int con el número de la bola
    * @return numero
    */
    @Override
    public int cantar() {
        return this.numero;
    }
}
