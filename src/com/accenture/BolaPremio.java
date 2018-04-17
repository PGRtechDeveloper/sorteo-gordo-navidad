package com.accenture;

public class BolaPremio implements Bola{
    public static final int EL_GORDO = 4000000;
    public static final int SEGUNDO_PREMIO = 1250000;
    public static final int TERCER_PREMIO = 500000;
    public static final int CUARTO_PREMIO = 200000;
    public static final int QUINTO_PREMIO = 60000; 
    public static final int PEDREA_PREMIO = 1000;
    public static final int TIPO_SIN_PREMIO = 0;
    private final int valorPremio;

    public BolaPremio (int valorPremio) {
        this.valorPremio = valorPremio;	
    }
	
    /**
    * Devuelve un int con el valor del premio en euros.
    * @return valorPremio
    */
    @Override
    public int cantar() {
        return this.valorPremio;
    }
}
