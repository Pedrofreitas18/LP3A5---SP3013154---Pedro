package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadQ implements Runnable {
 	
   @Override
   public void run(){
    	Repositorio.setDados(mathQuadrado());
    	Repositorio.setThread("ThreadQ");
    	
    	Repositorio.print();
   }
   
   private List<BigDecimal> mathQuadrado() {
		List<BigDecimal> list = new ArrayList<BigDecimal>(); 
		int contador;
		
		for(contador=1;contador<100;contador++) {
			if(contador % 2 !=0) {
				list.add(new BigDecimal(Math.sqrt(contador)));
			}
		}
		return list;		
	}
 
}