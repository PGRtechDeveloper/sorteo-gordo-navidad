package com.accenture;

import org.junit.Test;
import static org.junit.Assert.*;


public class SorteoTest {
    
    public SorteoTest() {
    }
    
    /**
    * Test para comprobar que se rellenan los 0 a la izquierda
    */
    @Test
    public void testGetBolaNumeroString(){
        Premio premio = new Premio(new BolaNumero(999) , new BolaPremio(BolaPremio.EL_GORDO)) ;
        String esperado = "00999";
        assertEquals(esperado, premio.getNumeroString());    
    }
    /**
    * Test de rellenarBomboNumeros()
    */
    @Test
    public void testRellenarBomboNumeros() {
      Sorteo sorteoTest = new Sorteo();
      int bomboNumerosEsperado = 99999; 
      assertEquals(bomboNumerosEsperado,sorteoTest.bomboNumeros.contarBolas());
    }
    
    /**
    * Test de rellenarBomboPremios()
    */
    @Test
    public void testRellenarBomboPremios() {
      Sorteo sorteoTest = new Sorteo();
      //1 premio gordo, 1 segundo premio, 1 tercer premio,  2 cuartos premios, 8 quintos premios, 1794 pedreas y 1 bola sin premio
      int bomboPremiosEsperado = 1+1+1+2+8+1794+1;
      assertEquals(bomboPremiosEsperado,sorteoTest.bomboPremios.contarBolas());
    }
    
    /**
    * Test que comprueba que las bolas se extraen correctamente y sean distintas
    */
    @Test
    public void testExtraerBolas() {
      Sorteo sorteoTest = new Sorteo();
      Bola bola1 = sorteoTest.bomboNumeros.extraerBola();
      Bola bola2 = sorteoTest.bomboNumeros.extraerBola();
      
      int bomboNumerosEsperado = 99997; //Tiene que haber dos bolas menos
      assertEquals(bomboNumerosEsperado,sorteoTest.bomboNumeros.contarBolas());
      assertNotSame(bola1, bola2); //Las bolas deben de ser diferentes
    }
    
    /**
    * Test que comprueba que se produce la excepción TipoSinPremioException
     * @throws TipoSinPremioException 
    */
    @Test(expected = TipoSinPremioException.class)
  
    public void testTipoSinPremioException() throws TipoSinPremioException {
      Sorteo sorteoTest = new Sorteo();
      	do {
                sorteoTest.sacaBolas(); 
        }while(sorteoTest.bomboPremios.quedanBolas());   
    }  
}
