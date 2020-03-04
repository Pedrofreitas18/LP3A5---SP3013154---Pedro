package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadC implements Runnable {
 
	List<BigDecimal> resultado;
	String mensagem = new String("Processo C - Não iniciado");
	
   @Override
   public void run(){
       synchronized(this){
    	   mensagem = new String("Processo C - Rodando");
    	   resultado = mathCubico();
           
    	  // for (BigDecimal item : resultado) {
    	  //  	System.out.println("-> " + item.toString());
    	  //  }  
    	   
    	   mensagem = new String("Processo C - Finalizado");
           notify();
       }
   }
   
   private List<BigDecimal> mathCubico() {
		List<BigDecimal> list = new ArrayList<BigDecimal>(); 
		int contador;
		
		for(contador=2;contador<=1000;contador++) {
			if(contador % 2 == 0) {
				list.add(new BigDecimal(Math.cbrt(contador)));
			}
		}
		
		try { 
			List<BigDecimal> synlist = Collections.synchronizedList(list);
			return synlist;
		}catch (IllegalArgumentException e) { 
			System.out.println("Exception thrown : " + e);
			return null;
	    }
		
	}
 
}
