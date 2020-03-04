package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadQ implements Runnable {
 
	List<BigDecimal> resultado;
	String mensagem = new String("Processo Q - Não iniciado");
	
   @Override
   public void run(){
       synchronized(this){
    	   mensagem = new String("Processo Q - Rodando");
    	   resultado = mathQuadrado();
           
    	   //for (BigDecimal item : resultado) {
    	   // 	System.out.println("-> " + item.toString());
    	    //}  
    	   
    	   mensagem = new String("Processo Q - Finalizado");
           notify();
       }
   }
   
   private List<BigDecimal> mathQuadrado() {
		List<BigDecimal> list = new ArrayList<BigDecimal>(); 
		int contador;
		
		for(contador=1;contador<100;contador++) {
			if(contador % 2 !=0) {
				list.add(new BigDecimal(Math.sqrt(contador)));
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