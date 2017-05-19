import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Cliente {

	public static void main(String[] args) throws Exception {
		
		int num;
		while(true){
			//INICIA UMA CONEÇAO COM O SERVIDOR NA PORTA 456 COM O HOST LOCAL
			Socket socketCliente = 	new Socket("192.168.56.1", 456);
			System.out.println("Olá do cliente para servidor \n");
			//INICIA VARIAVEIS DE ENTRADA E SAIDA DOS DADOS
			DataOutputStream outToServer = new DataOutputStream(socketCliente.getOutputStream());
			DataInputStream inFromServer = new DataInputStream(socketCliente.getInputStream());

			System.out.println("Digite o numero para calcular o Fibonacci: ");
			num = new Scanner(System.in).nextInt();
			System.out.println("Enviando para o SERVIDOR " + num + "\n");
			//ENVIA PARA SERVIDOR O NUMERO DIGITADO PELO USUARIO
			outToServer.writeInt(num);
			//LE O NUMERO ENVIADO PELO SERVIDOR COM O RESULTADO DO FIBONACCI
			num = inFromServer.readInt();
			System.out.println("Recebendo do SERVIDOR " + num + "\n");
			//FECHA A CONEXAO COM O SERVIDOR
			socketCliente.close();
		}
		
	}
	
}
