package com.accenture;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

public class Tabla {
    private static HashMap<Integer, Premio> premios;
    private static HashMap<String, Integer> premiosOrdenados; //He añadido este atributo para poder hacer un recuento final ordenado de todos los premios

    public Tabla(){
        Tabla.premios = new HashMap<Integer, Premio>();
        Tabla.premiosOrdenados = new HashMap<String, Integer>();	
    }
    
    /**
    * @param numero el número de la bola a comprobar)
    * @param numDecimos el número de décimos con los que está jugando el usuario.
    * Multiplico este numero por 0.1 (1/10)
    * @return String resultado devuelve un mensaje en función de si hay premio o no
    */
    public static String comprobarPremio(int numero){
        String resultado = "";
    	DecimalFormat df = new DecimalFormat("###.#"); //Para quitar el decimal al final del numero Ej: 6000€ en lugar de 6000.0€
        double cantidadEnEuros = 0;
        boolean boletoCorrecto = false;
        if ( numero > 0 && numero<=99999 ) {
             boletoCorrecto = true;
        }else {
             resultado = "Error. Ha introducido un número mayor que 99999";
        }
        if (boletoCorrecto) {
            System.out.println("¿Con cuánto dinero estás jugando? :");
            Scanner teclado = new Scanner(System.in);
            cantidadEnEuros = teclado.nextDouble();
        	if (Tabla.premios.containsKey(numero)) {
                resultado = "¡Enhorabuena! has sido premiado con "+ df.format(Tabla.premios.get(numero).getValorPremio()*(cantidadEnEuros*0.005)) + "€";
        	}else {
                resultado = "¡Lo sentimos! Tu número no ha sido premiado.";
        	}
        }
        if (boletoCorrecto && (cantidadEnEuros < 0 || cantidadEnEuros > 200)){
            resultado = "Error. Cantidad en euros errónea (min 0, max 200)";
        }
        if (numero < 1){
            resultado = "Muchas gracias por jugar. ¡Que la suerte te acompañe!";
        }
        return resultado;
    }
    
    /**
    * Agrega un premio al HashMap premios (sirve para comprobar un premio en concreto) 
    * y premiosOrdenados (para mostrar los premios por orden descendente al final)
    * @param premio
    */
    public static void agregarPremio(Premio premio){
        Tabla.premios.put(premio.getNumero(), premio);
        //premiosOrdenados es un HashMap<String , Integer> necesario para poder ordenar
        //los premios de mayor a menor y mostrarlos después de que el sorteo haya terminado.
        Tabla.premiosOrdenados.put(premio.getNumeroString(), premio.getValorPremio());
    }
    
    public static void mostrarPremios(){
        ordenarPremios();
    }
    
    /**
    * Ordena el HashMap por Values para poder imprimir los premios de mayor a menor
    * Código sacado de aquí -> https://stackoverflow.com/questions/8119366/sorting-hashmap-by-values
    */
    private static void ordenarPremios(){ 
        Set<Entry<String, Integer>> set = Tabla.premiosOrdenados.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        pintarPremiosPorOrden(list);
    }
    
    /**
    * @param list
    * Finalmente se recorre la lista de premios ya ordenados y los muestra en la consola cuando el sorteo haya finalizado
    */
    public static void pintarPremiosPorOrden(List<Entry<String, Integer>> list){
        //
        for (Entry<String, Integer> entry : list) {
            if (entry.getValue() == 4000000){
                 System.out.println("El gordo : Número : " + entry.getKey() + " Premio : " + entry.getValue() + "€");
            }
            if (entry.getValue() == 1250000){
                 System.out.println("Segundo premio : Número : " + entry.getKey() + " Premio : " + entry.getValue() + "€");
            }
            if (entry.getValue() == 500000){
                 System.out.println("Tercer premio : Número : " + entry.getKey() + " Premio : " + entry.getValue() + "€");
            }
            if (entry.getValue() == 200000){
                 System.out.println("Cuarto premio : Número : " + entry.getKey() + " Premio : " + entry.getValue() + "€");
            }
            if (entry.getValue() == 60000){
                 System.out.println("Quinto premio : Número : " + entry.getKey() + " Premio : " + entry.getValue() + "€");
            }
        }   
    }
}
        


       

