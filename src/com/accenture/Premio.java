package com.accenture;

public class Premio {
    
    private final BolaNumero bolaNumero;
    private final BolaPremio bolaPremio;
    
    public Premio (BolaNumero bolaNumero, BolaPremio bolaPremio){
        
        this.bolaNumero = bolaNumero;
        this.bolaPremio = bolaPremio;
    }
    
    /**
    * Obtiene un int con el número premiado.
    * @return int
    */
    public int getNumero(){
       return this.bolaNumero.cantar();
    }
    /**
    * Obtiene un String con el número premiado pero con ceros a la izquierda.
    * @return String
    */
    public String getNumeroString(){
        String ceros = "";
        for (int i = contarDigitos(this.bolaNumero.cantar()) ; i<5; i++){
            ceros += "0";
        }
        ceros += this.bolaNumero.cantar();
        return ceros;
    }
    private int contarDigitos(int numero){
        String numeroString = numero+"";
        int cont = 0;
        for (int i = 0, len = numeroString.length(); i < len; i++) {
            if (Character.isDigit(numeroString.charAt(i))) {
              cont++;
            }
        } 
        return cont;
    }
    
    /**
    * Obtiene un int con el valor del premio en euros.
    * @return int
    */
    public int getValorPremio(){
       return this.bolaPremio.cantar();
    }
}
