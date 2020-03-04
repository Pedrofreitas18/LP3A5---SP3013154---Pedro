package main;

import java.math.BigDecimal;
import java.util.List;

public class Repositorio implements Runnable{
	
	static List<BigDecimal> dados;
	static String thread;
	static boolean rodar = false;
	
	public static String getThread() {
		return thread;
	}

	public static void setThread(String thread) {
		Repositorio.thread = thread;
	}

	public static boolean isRodar() {
		return rodar;
	}

	public static void setRodar(boolean rodar) {
		Repositorio.rodar = rodar;
	}

	public static List<BigDecimal> getDados() {
		return dados;
	}

	public static void setDados(List<BigDecimal> dados) {
		Repositorio.dados = dados;
	}

	@Override
	public void run() {
		synchronized(this){
			while(true) {	
	           
				if(rodar == true) {
	            	
					for(BigDecimal item : dados) {
	            		System.out.println(thread+" -> " + item.toString());
	            	}
					
					rodar = false;
				}
		
			}	
				//rodar = false;
		}
	}
	
	
	
	
	
}
