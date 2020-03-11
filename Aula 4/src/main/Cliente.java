package main;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class Cliente {

	public static void main(String args[]) {
		boolean flag = true;
		Socket cliente = null;

		 try {
			 while(flag == true) {
				// conecta ao servidor
				 if(cliente == null) {
					 System.out.print("Aguardando servidor... \n\n");
					 cliente = new Socket("127.0.0.1",18974);
					 System.out.println("O cliente se conectou ao servidor!\n");
				 }
				 
				 DataInputStream in = new DataInputStream(cliente.getInputStream());
				 DataOutputStream ot = new DataOutputStream( cliente.getOutputStream() );
				 
				 
				 //---------------------------------------------------------------------------
				 //recebe resposta do servidor
				 System.out.print("SERVIDOR-> ");
			     System.out.println(in.readUTF()); 
				 	
			     //---------------------------------------------------------------------------
				 //escreve para o servidor
			     
			     //DataOutputStream ot = new DataOutputStream( cliente.getOutputStream() );
			     
			     BufferedReader iin = new BufferedReader(new InputStreamReader(System.in));
					 
				 String mensageOut = null;
					 System.out.print("CLIENTE-> ");
					 try {
						 mensageOut = iin.readLine();
					 } catch (IOException e1) {
						 e1.printStackTrace();
					 }
				
				 	ot.writeUTF(mensageOut);
				 	
				 	
				 if(mensageOut.equals("Adeus")) {
					 flag = false;
					 cliente.close();
					 cliente = null;
				 }

			 }

		 } catch (Exception e) {

			 // em caso de erro
			 System.out.println("Ocorreu um erro na conexão");
			 e.printStackTrace();

		 }
	 }
 }

//192.168.56.1    10.100.13.105