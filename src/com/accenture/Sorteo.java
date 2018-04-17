package com.accenture;

public final class Sorteo {
    
    public Bombo bomboNumeros;
    public Bombo bomboPremios;
    public Tabla tabla;
    
    public Sorteo() {
       
       this.bomboNumeros = new Bombo();
       this.bomboPremios = new Bombo();
       this.tabla = new Tabla();
       //Al crearse el objeto Sorteo se preparan los bombos
       rellenarBombos(); 
    }
   
    /**
    * Se llama a los métodos que rellenan ambos bombos
    */
    public void rellenarBombos(){
       rellenenarBomboNumeros();
       rellenarBomboPremios();  
    }
   
    /**
    * Extrae una bola de bomboNumeros y de bomboPremios.
    * Crea un objeto de tipo Premio y lo agregha a la tabla.
    * @return un premio.
    * @throws com.accenture.TipoSinPremioException
    */
    public Premio sacaBolas() throws TipoSinPremioException {
        Premio premio = new Premio((BolaNumero)this.bomboNumeros.extraerBola() ,(BolaPremio) this.bomboPremios.extraerBola());
        //Solo se imprimen los premios mayores de 1000€
        if (premio.getValorPremio()>1000){ 
            System.out.println(cantarPremio(premio));
        }
        if (premio.getValorPremio() != BolaPremio.TIPO_SIN_PREMIO){
            Tabla.agregarPremio(premio);
        }else{
            throw new TipoSinPremioException("Hay una bola con un premio en blanco. ¡Toooongo!");
        }
        return premio;
    }
   
    /**
    * @param premio Recibe un premio
    * Coge de cada premio su número y su valor en euros.
    * @return un string con la información del premio cantada.
    */
    public String cantarPremio(Premio premio){ 
       return "¡ " + premio.getNumeroString() +" " + premio.getValorPremio() + " eeeeuuroooos!";
    }
   
    /**
    * Mete 99999 bolas al bomboNumeros.
    */
    private void rellenenarBomboNumeros(){
        for (int i = 1; i<= 99999; i++){
            this.bomboNumeros.agregarBola(new BolaNumero(i));
        } 
        this.bomboNumeros.rotarBombo();
    }
   
    /**
    * Mete los siguientes premios:
    * 1 premio gordo (4000000€) , 1 segundo premio (1250000€), 1 tercer premio (500000€), 2 cuartos premios (200000€)
    * 8 quintos premios (60000€) , 1794 pedrea (1000€) y 1 bola sin premio
    */
    private void rellenarBomboPremios(){
        this.bomboPremios.agregarBola(new BolaPremio(BolaPremio.EL_GORDO));
        this.bomboPremios.agregarBola(new BolaPremio(BolaPremio.SEGUNDO_PREMIO));
        this.bomboPremios.agregarBola(new BolaPremio(BolaPremio.TERCER_PREMIO));
        this.bomboPremios.agregarBola(new BolaPremio(BolaPremio.CUARTO_PREMIO));
        this.bomboPremios.agregarBola(new BolaPremio(BolaPremio.CUARTO_PREMIO));
        for (int i = 1; i<= 8; i++){
            this.bomboPremios.agregarBola(new BolaPremio(BolaPremio.QUINTO_PREMIO)); 
        }
        for (int i = 1; i<= 1794; i++){
            this.bomboPremios.agregarBola(new BolaPremio(BolaPremio.PEDREA_PREMIO)); 
        }
        this.bomboPremios.agregarBola(new BolaPremio(BolaPremio.TIPO_SIN_PREMIO)); 
        this.bomboPremios.rotarBombo();
    }

}
