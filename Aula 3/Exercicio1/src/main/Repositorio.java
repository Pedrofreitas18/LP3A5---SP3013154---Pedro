package main;

import java.math.BigDecimal;
import java.util.List;

public class Repositorio{
	
	static List<BigDecimal> dados;
	static String thread;

	public static String getThread() {
		return thread;
	}

	public static void setThread(String thread) {
		Repositorio.thread = thread;
	}

	public synchronized static List<BigDecimal> getDados() {
		return dados;
	}

	public synchronized static void setDados(List<BigDecimal> dados) {
		Repositorio.dados = dados;
	}

	public synchronized static void print() {
		for(BigDecimal item : dados) {
	      	System.out.println(thread+"-> " + item.toString());
	   	}
	}
		
}
