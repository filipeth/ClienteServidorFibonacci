import java.io.*;
import java.net.*;
public class Servidor {

	public static void main(String[] args) throws Exception {
		int num;
		
		// INICIA UMA COMUNICAÇÃO TCP NA PORTA 456
		ServerSocket welcomeSocket = new ServerSocket(456); 
		while (true){
			
			//ACEITA A CONECAO COM O CLIENTE
			Socket connectionSocket = welcomeSocket.accept(); 
			
			//INICIA VARIAVEIS DE ENTRADA E SAIDA DOS DADOS
			DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			//LE O NUMERO ENVIADO PELO CLIENTE NA PORTA 456
			num = inFromClient.readInt();
			if(num!=0){
				System.out.println("\n NUMERO INFORMADO PELO CLIENTE: " + num);
				num = fibonacci(num);
				System.out.println("\n ENVIANDO PARA CLIENTE RESULTADO: " + num);
				//ENVIA NA PORTA 456 O RESULTADO DA OPERAÇÃO
				outToClient.writeInt(num);
			}
		}
	}
	
	//METODO PARA CALCULAR O FIBONACCI
	
	public static int fibonacci(int num) {
		if (num < 2) {
			return num;
		} else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}
		
}
