package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadC implements Runnable {
 
   @Override
   public void run(){
	   Repositorio.setDados(mathCubico()); 
	   Repositorio.setThread("ThreadC");
	   
       Repositorio.print();
   }
   
   private List<BigDecimal> mathCubico() {
		List<BigDecimal> list = new ArrayList<BigDecimal>(); 
		int contador;
		
		for(contador=2;contador<=1000;contador++) {
			if(contador % 2 == 0) {
				list.add(new BigDecimal(Math.cbrt(contador)));
			}
		}
		return list;	
	}
 
}
