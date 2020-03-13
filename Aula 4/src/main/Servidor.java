package main;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;


 public class Servidor {

 public static void main(String args[]) {
	 boolean flag = true;
	 
	 try {
		 ServerSocket servidor = new ServerSocket(18970);
		 Socket cliente = null;
		 
		 DataOutputStream ot = null;
		 DataInputStream in = null;
		 
		 while(flag == true) {
			//Conecta com o cliente 
			 if(cliente == null) {
				 System.out.print("Aguardando cliente... \n\n");
				 
				 cliente = servidor.accept();
				 ot = new DataOutputStream( cliente.getOutputStream() );
				 in = new DataInputStream(cliente.getInputStream());
				 
				 System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress() + "\n");
			 }
			 
             //---------------------------------------------------------------------------
			 //escreve para o cliente
			 
			 
			 //Scanner sc = new Scanner(System.in);
			 //System.out.print("SERVIDOR-> ");
			 //String mensageOut = sc.nextLine(); 
			 ot.writeUTF("ok man");
			 //ot.writeUTF(mensageOut);

			 //---------------------------------------------------------------------------
			 //recebe resposta do cliente
			 
			 //DataInputStream in = new DataInputStream(cliente.getInputStream());
			 String mensagemCliente = in.readUTF();
			 
			 System.out.print("CLIENTE-> ");
		     System.out.println(mensagemCliente); 

		     if(mensagemCliente.equals("Adeus")) {
		    	 flag = false;
		    	 cliente.close();
		         servidor.close();
		         cliente = null;
		         
		         System.out.print("\n\n\n\nFim da brincadeira. ");
		     }
		
		 }
	 } catch (IOException e) {

		 // em caso de erro
		 System.out.println("Ocorreu um erro na conexão");
		 e.printStackTrace();
	 }
 }
 }
