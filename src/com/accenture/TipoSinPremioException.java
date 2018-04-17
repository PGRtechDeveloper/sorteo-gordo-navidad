package com.accenture;
 
public class TipoSinPremioException extends Exception {
     
    private static final long serialVersionUID = -751919180722083197L;
 
    public TipoSinPremioException(String mensaje) {
        super(mensaje);
    }    
}