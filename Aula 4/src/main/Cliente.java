package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;


public class Cliente{

	public static void main(String args[]) {
		 boolean flag = true;
		 Socket cliente = null;
		
 	   	 DataInputStream in = null;
		 DataOutputStream ot = null;

		 try {
			 while(flag == true) {
				// conecta ao servidor
				 if(cliente == null) {
					 System.out.print("Aguardando servidor... \n\n");
					 
					 cliente = new Socket("127.0.0.1",18970);
					 in = new DataInputStream(cliente.getInputStream());
					 ot = new DataOutputStream( cliente.getOutputStream() );
					 
					 System.out.println("O cliente se conectou ao servidor!\n");
				 }
				 
				 
				 //---------------------------------------------------------------------------
				 //recebe resposta do servidor
				 System.out.print("SERVIDOR-> ");
			     System.out.println(in.readUTF()); 
				 	
			     //---------------------------------------------------------------------------
				 //escreve para o servidor
			     
			     //DataOutputStream ot = new DataOutputStream( cliente.getOutputStream() );
			 
				 Scanner sc = new Scanner(System.in);
				 System.out.print("CLIENTE-> ");
				 String mensageOut = sc.nextLine(); 
				
				 ot.writeUTF(mensageOut);
				 	
				 	
				 if(mensageOut.equals("Adeus")) {
					 flag = false;
					 cliente.close();
					 cliente = null;
					 
					 System.out.print("\n\n\n\nFim da brincadeira. ");
				 }

			 }

		 } catch (Exception e) {

			 // em caso de erro
			 System.out.println("Ocorreu um erro na conexão");
			 e.printStackTrace();

		 }
	 }
 }
