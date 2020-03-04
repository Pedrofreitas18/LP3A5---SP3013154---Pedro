package main;

public class ThreadA {
 
public static void main(String[] args) throws InterruptedException{
//Runnable threadQR = new Runnable();
	int c = 1;
	
	System.out.println("WTF -WORKS?!! " + c);
	c++;
	
ThreadQ threadQ = new ThreadQ();

System.out.println("WTF -WORKS?!! " + c);
c++;
//ThreadC threadC = new ThreadC();
Repositorio repositorio = new Repositorio();

System.out.println("WTF -WORKS?!! " + c);
c++;

threadQ.run();

System.out.println("WTF -WORKS?!! " + c);
c++;

//threadC.run();
repositorio.run();


System.out.println("WTF -WORKS?!! " + c);
c++;
 

    System.out.println("Inicio dos Thread...\n");
      
      //while(threadQ.mensagem.equals("Processo Q - Rodando") || threadC.mensagem.equals("Processo C - Rodando")) {
    while(threadQ.mensagem.equals("Processo Q - Rodando")) {
		if(threadQ.mensagem.equals("Processo Q - Finalizado")) {
			threadQ.mensagem = new String("Processo Q - Não iniciado");
			
			Repositorio.setThread("Thread Quadrado");
			Repositorio.setDados(threadQ.resultado);
			Repositorio.setRodar(true);      		
		}
		//if(threadC.mensagem.equals("Processo C - Finalizado")) {
			//threadC.mensagem = new String("Processo C - Não iniciado");
			
		//	Repositorio.setThread("Thread Cubico");
		//	Repositorio.setDados(threadC.resultado);
		//	Repositorio.setRodar(true);
		//}
	}
    
    //System.out.println("\n"+threadC.mensagem);
    System.out.println("\n"+threadQ.mensagem);
    
    }
 }

 
