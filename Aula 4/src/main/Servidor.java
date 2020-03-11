package main;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

 public class Servidor {

 public static void main(String args[]) {
	 boolean flag = true;
	 
	 try {
		 ServerSocket servidor = new ServerSocket(18974);
		 Socket cliente = null;
		 
		 while(flag == true) {
			//Conecta com o cliente 
			 if(cliente == null) {
				 System.out.print("Aguardando cliente... \n\n");
				 cliente = servidor.accept();
				 System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress() + "\n");
			 }

			 DataOutputStream ot = new DataOutputStream( cliente.getOutputStream() );
			 DataInputStream in = new DataInputStream(cliente.getInputStream());
			 
             //---------------------------------------------------------------------------
			 //escreve para o cliente
			 BufferedReader iin = null;
			 iin = new BufferedReader(new InputStreamReader(System.in));
	
			 String mensageOut = null;
		     try {
				System.out.print("SERVIDOR-> ");
				mensageOut = iin.readLine();
		   	 } catch (IOException e1) {
				e1.printStackTrace();
		     }
			 		     
			 ot.writeUTF(mensageOut);

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
		     }
		
		 }
	 } catch (IOException e) {

		 // em caso de erro
		 System.out.println("Ocorreu um erro na conexão");
		 e.printStackTrace();
	 }
 }
 }
